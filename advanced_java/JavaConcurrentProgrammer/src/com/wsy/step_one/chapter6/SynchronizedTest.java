package com.wsy.step_one.chapter6;

/**
 * 	同步代码块
 * @author Administrator
 *
 */
public class SynchronizedTest {

	private final static Object LOCK = new Object(); //定义一个锁
	
	public static void main(String[] args) {
		
		Runnable runnable=()->{
			
			synchronized(LOCK) {
				
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread t1=new Thread(runnable,"t1");
		Thread t2=new Thread(runnable,"t2");
		Thread t3=new Thread(runnable,"t3");
		t1.start();
		t2.start();
		t3.start();
	}
}
