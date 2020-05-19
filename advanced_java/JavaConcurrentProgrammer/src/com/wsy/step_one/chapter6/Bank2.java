package com.wsy.step_one.chapter6;

/**
 * 	模拟银行调度取号码--------线程的安全问题
 * @author Administrator
 *
 */
public class Bank2 {

	public static void main(String[] args) {
		
		final SynchronizedRunnable window=new SynchronizedRunnable();
		Thread t1=new Thread(window,"一号窗口");
		Thread t2=new Thread(window,"二号窗口");
		Thread t3=new Thread(window,"三号窗口");
		t1.start();
		t2.start();
		t3.start();
	}
}
