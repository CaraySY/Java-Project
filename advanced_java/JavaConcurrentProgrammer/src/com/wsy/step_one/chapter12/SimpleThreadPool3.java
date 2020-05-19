package com.wsy.step_one.chapter12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 	Thread Pool Test version 3<br>
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
public class SimpleThreadPool3 extends Thread{

	// pool size
	private int size; 
	// task queue contain max numbers
	private final int queueSize;
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
	
	private int min;
	// minus thread number 
	private static final int MIN_THREAD=4;
	
	private int max;
	// max thread number 
	private static final int MAX_THREAD=12;
	
	private int active;
	// active thread number 
	private static final int ACTIVE_THREAD=8;
	
	public SimpleThreadPool3() {
		this(MIN_THREAD,ACTIVE_THREAD,MAX_THREAD,DEFAULT_TASK_QUEUE_SIZE,DEFAULT_DISCARD_POLICY);
	}
	
	public SimpleThreadPool3(int min,int active,int max,int queueSize,DiscardPolicy discardPolicy) {
		this.min=min;
		this.active=active;
		this.max=max;
		this.queueSize=queueSize;
		this.discardPolicy=discardPolicy;
		init();
	}
	
	// initialize thread task
	private void init() {
		
		for(int i=0;i<this.min;i++) {
			createWorkTask(); //初始化任务
		}
		this.size=min;
		this.start();
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
	
	@Override
	public void run() {
		
		while(!destroy) {
			System.out.printf("Pool$min:%d,active:%d,max:%d,Running_Thread:%d,Task_Queue_Size:%d \n",
					min,active,max,size,TASK_QUEUE.size());
			try {
				Thread.sleep(3_000);
				if(TASK_QUEUE.size() > active && size < active) {
					// resize
					for(int i=size;i<active;i++) {
						createWorkTask();
					}
					System.out.println("pool resized.");
					this.size=active;
				}else if(TASK_QUEUE.size() > max && size < max) {
					// resize
					for(int i=size;i<max;i++) {
						createWorkTask();
					}
					System.out.println("pool size arrived max.");
					this.size=max;
				}
				// usually retain ${active} thread
				if(size > active && TASK_QUEUE.isEmpty()) {
					System.out.println("========Reduce========");
					synchronized (TASK_QUEUE) {
						int releaseSize=size-active;
						// use iterator can change collection's state in running stage of program
						for(Iterator<WorkTask> it=THREAD_QUEUE.iterator();;it.hasNext()) {
							if(releaseSize <= 0) {
								break;
							}
							WorkTask task=it.next(); // get a element
							task.close();
							task.interrupt(); // interrupt current task
							it.remove();
							releaseSize--;
						}
						this.size=active;
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
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
	
	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public boolean isDestory() {
		
		return destroy;
	}
	
	public static class DiscardException extends RuntimeException{
		
		/**
		 *  serial id
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
