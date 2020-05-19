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
	 * 	���m2����synchronized�ؼ��֣���ô������߳�ͬʱ���ʾ���synchronized���ķ���ʱ���߳��Ǵ��н��У���ĳ���߳�
	 *  ��Ҫ�ȴ���һ���߳�ִ����ϲ��ܷ���--------�� synchronized ��������(this����)
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