package com.wsy.step_one.chapter6;

/**
 * 	ģ�����е���ȡ����--------�̵߳İ�ȫ����
 * @author Administrator
 *
 */
public class Bank2 {

	public static void main(String[] args) {
		
		final SynchronizedRunnable window=new SynchronizedRunnable();
		Thread t1=new Thread(window,"һ�Ŵ���");
		Thread t2=new Thread(window,"���Ŵ���");
		Thread t3=new Thread(window,"���Ŵ���");
		t1.start();
		t2.start();
		t3.start();
	}
}
