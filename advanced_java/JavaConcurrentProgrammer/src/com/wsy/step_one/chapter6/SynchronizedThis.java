package com.wsy.step_one.chapter6;

public class SynchronizedThis {

	public static void main(String[] args) {
		
		ThisLock lock=new ThisLock();
		Thread t1=new Thread("t1") {
			@Override
			public void run() {
				lock.m1();
			}
		};
		Thread t2=new Thread("t2") {
			@Override
			public void run() {
				lock.m2();
			}
		};
		t1.start();
		t2.start();
	}
}

class ThisLock{
	
	public synchronized void m1() {
		
		try {
			System.out.println("currentThread "+Thread.currentThread().getName());
			Thread.sleep(5_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	如果m2加了synchronized关键字，那么当多个线程同时访问具有synchronized锁的方法时，线程是串行进行，即某个线程
	 *  需要等待另一个线程执行完毕才能访问--------即 synchronized 锁定的是(this对象)
	 */
	public synchronized void m2() {
		
		try {
			System.out.println("currentThread "+Thread.currentThread().getName());
			Thread.sleep(5_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}