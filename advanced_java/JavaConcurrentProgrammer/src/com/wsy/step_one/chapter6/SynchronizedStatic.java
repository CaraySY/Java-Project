package com.wsy.step_one.chapter6;

/**
 * 	��̬�����ļ���
 * @author Administrator
 *
 */
public class SynchronizedStatic {

	//��̬���������Ƕ��������ʹ����������ǰ����
	static {
		synchronized(SynchronizedStatic.class) {
			try {
				System.out.println("static "+Thread.currentThread().getName());
				Thread.sleep(5_000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized static void m1() {
		
		try {
			System.out.println("currentThread "+Thread.currentThread().getName());
			Thread.sleep(5_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized static void m2() {
		
		try {
			System.out.println("currentThread "+Thread.currentThread().getName());
			Thread.sleep(5_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void m3() {
		
		try {
			System.out.println("currentThread "+Thread.currentThread().getName());
			Thread.sleep(5_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
