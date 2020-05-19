package com.wsy.step_one.chapter5;

public class ThreadInterrupt {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t1=new Thread() {

			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(10); //ʹ��sleep�����ж��쳣
					} catch (InterruptedException e) {
						System.out.println("�յ��ж��ź�...");
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
