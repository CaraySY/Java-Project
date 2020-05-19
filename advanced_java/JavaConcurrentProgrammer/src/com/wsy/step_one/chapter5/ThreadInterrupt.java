package com.wsy.step_one.chapter5;

public class ThreadInterrupt {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t1=new Thread() {

			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(10); //使用sleep捕获中断异常
					} catch (InterruptedException e) {
						System.out.println("收到中断信号...");
						e.printStackTrace();
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
