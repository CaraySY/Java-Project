package com.wsy.step_one.chapter5;

/**
 * 	使用一个开关来中断某个线程
 * @author Administrator
 *
 */
public class ThreadCloseGraceful2 {

	private static class Worker extends Thread{
		
		@Override
		public void run() {
			
			while(true) {
				try {
					Thread.sleep(1_000);
				} catch (InterruptedException e) { //捕获到中断异常跳出循环
					break;
				}
				
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		Worker worker=new Worker();
		worker.start();
		try {
			Thread.sleep(5_000); //主线程等待 10秒
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		worker.interrupt();
	}
}
