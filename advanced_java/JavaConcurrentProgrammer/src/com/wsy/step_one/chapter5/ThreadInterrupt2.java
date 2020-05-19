package com.wsy.step_one.chapter5;

public class ThreadInterrupt2 {

	private static Object monitor=new Object();
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1=new Thread() {

			@Override
			public void run() {
				while(true) {
					synchronized(monitor){
						try {
							monitor.wait(10); //使用wait捕获中断异常
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		};
		t1.start();
		Thread.sleep(1_000);
		System.out.println(t1.isInterrupted());
		t1.interrupt();
		System.out.println(t1.isInterrupted());
		
	}
}
