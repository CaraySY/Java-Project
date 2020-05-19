package com.wsy.step_one.chapter5;

public class ThreadInterrupt3 {

	public static void main(String[] args){
		
		Thread main=Thread.currentThread();
		Thread t1=new Thread() {

			@Override
			public void run() {
				while(true) {
					
				}
			}
		};
		t1.start();
		Thread t2=new Thread() {

			@Override
			public void run() {
				try {
					Thread.sleep(1_000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("interrupt t1...");
				//t1.interrupt(); //中断的是t1线程
				main.interrupt(); //需要中断main线程
				
			}
		};
		t2.start();
		try {
			t1.join(); // join的是main线程
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
