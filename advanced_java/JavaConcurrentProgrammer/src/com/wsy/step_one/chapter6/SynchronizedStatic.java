package com.wsy.step_one.chapter6;

/**
 * 	静态方法的加锁
 * @author Administrator
 *
 */
public class SynchronizedStatic {

	//静态方法的锁是对类的锁，使用类锁定当前方法
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
