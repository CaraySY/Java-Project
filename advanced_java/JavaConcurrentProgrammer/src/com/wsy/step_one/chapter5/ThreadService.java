package com.wsy.step_one.chapter5;

public class ThreadService {

	private Thread executeThread; //定义一个执行线程
	private boolean finished=false;
	
	public void execute(Runnable task) {
		
		executeThread=new Thread() {
			@Override
			public void run() {
				
				Thread runner=new Thread(task); //当守护线程去执行任务
				runner.setDaemon(true); //设置为守护线程，当执行线程关闭，守护线程也会随之而关闭
				runner.start();
				try {
					runner.join(); //守护线程需要等待执行线程结束---不然会出现执行线程结束，守护线程什么都没有做直接结束
					finished=true;
				} catch (InterruptedException e) {
					
				}
			}
		};
		executeThread.start();
	}
	
	public void shutdown(long mills) {
		
		long currentTime=System.currentTimeMillis();
		while(!finished) {
			if((System.currentTimeMillis()-currentTime) >= mills){
				System.out.println("任务超时，需要结束该任务！！！");
				executeThread.interrupt();
				break;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				System.out.println("线程被打断");
				break;
			}
		}
		finished=false;
	}
}
