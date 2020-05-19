package com.wsy.step_one.chapter5;

/**
 * 	使用一个开关来中断某个线程
 * @author Administrator
 *
 */
public class ThreadCloseGraceful {

	private static class Worker extends Thread{
		
		private volatile boolean start=true;//设置一个开闭来shutdown线程
		@Override
		public void run() {
			
			while(start) {
				
			}
		}
		
		public void shutDown() {
			
			System.out.println("shutdown current thread...");
			this.start=false;
		}
	}
	
	public static void main(String[] args) {
		
		Worker worker=new Worker();
		worker.start();
		try {
			Thread.sleep(10_000); //主线程等待 10秒
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		worker.shutDown(); //关闭当前线程[worker线程]
	}
}
