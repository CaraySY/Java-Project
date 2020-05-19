package com.wsy.step_one.chapter12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 	Thread Pool Test version 1<br>
 * 	<strong>key</strong>: <br>
 * 		1.task queue <br>
 * 		2.refuse strategy[throw exception、throw direct、block、temporary queue] <br>
 * 		3.initial (minus) <br>
 * 		4.active thread <br>
 * 		5.max thread numbers <br>
 * 			minus >= active >= max <br>
 * @author Administrator
 *
 */
public class SimpleThreadPool2 {

	// pool size
	private final int size; 
	// task queue contain max numbers
	private final int queueSize;
	// default pool size
	private final static int DEFUALT_SIZE=10; 
	// default 
	private final static int DEFAULT_TASK_QUEUE_SIZE=2000;
	// task queue to invoke waiting task
	private final static LinkedList<Runnable> TASK_QUEUE=new LinkedList<>();
	// auto increment
	private static volatile int seg=0;
	// prefix of pool's name 
	private final static String THREAD_PRFIX="SIMPLE_THREAD_POOL-";
	// define thread_group
	private final static ThreadGroup GROUP=new ThreadGroup("POOL_GROUP");
	// define thread pool
	private final static List<WorkTask>  THREAD_QUEUE=new ArrayList<>();
	// refuse strategy
	private final DiscardPolicy discardPolicy;
	// destroy flag
	private volatile boolean destroy=false;
	// default refuse strategy
	public static final DiscardPolicy DEFAULT_DISCARD_POLICY=()->{
		throw new DiscardException("refuse current task.");
	};
	public SimpleThreadPool2() {
		this(DEFUALT_SIZE,DEFAULT_TASK_QUEUE_SIZE,DEFAULT_DISCARD_POLICY);
	}
	
	public SimpleThreadPool2(int size,int queueSize,DiscardPolicy discardPolicy) {
		this.size = size;
		this.queueSize=queueSize;
		this.discardPolicy=discardPolicy;
		init();
	}
	
	// initialize thread task
	private void init() {
		
		for(int i=0;i<size;i++) {
			createWorkTask(); //初始化任务
		}
	}

	// create work task
	private void createWorkTask() {
		
		// generate default task name
		WorkTask task=new WorkTask(GROUP,THREAD_PRFIX+(seg++));
		task.start();
		// add into thread pool to execute 
		THREAD_QUEUE.add(task);
	}
	
	//	expose outer interface to invoke specified task
	public void submit(Runnable runnable) {
		
		if(destroy) {
			throw new IllegalStateException("The pool have been destroyed and not allow submit task.");
		}
		synchronized(TASK_QUEUE) {
			if(TASK_QUEUE.size() > queueSize) {
				discardPolicy.discard(); // execute refuse strategy
			}
			TASK_QUEUE.addLast(runnable); // add a task to execute current task
			TASK_QUEUE.notifyAll();	// wake up all threads
		}
	}
	
	// shutdown thread
	public void shutdown() throws InterruptedException {
		
		while(!TASK_QUEUE.isEmpty()) {
			Thread.sleep(50);
		}
		int initVal=THREAD_QUEUE.size();
		while(initVal > 0){
			for(WorkTask task:THREAD_QUEUE) {
				if(task.getTaskState()==TaskState.BLOCK) {
					task.interrupt();
					task.close();
					initVal--;
				}else {
					Thread.sleep(10);
				}
			}
		}
		this.destroy=true;
		System.out.println("Thread pool has disposed.");
	}
	
	// define task state
	private enum TaskState{
		FREE,
		RUNNING,
		BLOCK,
		DEAD
	}
	
	public int getSize() {
		return size;
	}

	public int getQueueSize() {
		return queueSize;
	}
	
	public boolean isDestory() {
		
		return destroy;
	}
	
	public static class DiscardException extends RuntimeException{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public DiscardException(String msg) {
			super(msg);
		}
	}
	
	@FunctionalInterface
	public interface DiscardPolicy{
		
		void discard() throws DiscardException;
	}
	private static class WorkTask extends Thread{
		
		// default task state is FREE
		private volatile TaskState taskState=TaskState.FREE;
		//constructor to initialize some thread's information
		public WorkTask(ThreadGroup group,String name) {
			super(group,name);
		}

		// return current task state
		public TaskState getTaskState() {
			return taskState;
		}
		//close thread
		public void close() {
			taskState=TaskState.DEAD;
		}

		@Override
		public void run() {
			OUTER:
			while(taskState!=TaskState.DEAD) {
				//define a Runnable reference variable
				Runnable runnable = null;
				synchronized (TASK_QUEUE) { // current thread locked by TASK_QUEUE MONITOR
					while(TASK_QUEUE.isEmpty()) { // if task queue haven't task
						try {
							taskState=TaskState.BLOCK; // block current thread
							TASK_QUEUE.wait(); // wait to wake
						} catch (InterruptedException e) {
							// while appear exception,program  will be break in OUTER label
							break  OUTER; 
						} 
					}
					//invoke task
					runnable = TASK_QUEUE.removeFirst();
					if(runnable!=null) { // no null
						taskState=TaskState.RUNNING; //running task
						runnable.run(); // current thread into runnable state to waiting execute
					}
				}
			}
		}
	}
	
}
