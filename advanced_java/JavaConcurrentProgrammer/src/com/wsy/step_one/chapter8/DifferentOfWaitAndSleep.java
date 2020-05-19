package com.wsy.step_one.chapter8;

import java.util.stream.Stream;

/**
 * 	sleep()与wait()方法的区别
 * @author Administrator
 *
 */
public class DifferentOfWaitAndSleep {

	private static final Object LOCK=new Object(); //监听器
	
	public static void main(String[] args) {
		
		Stream.of("t1","t2").forEach(name->{
			new Thread(name) { //传递参数
				@Override
				public void run() {
					m2();
				}
			}.start();
		});
	}
	
	/**
	 * 	sleep() 不需要释放监听器的锁---无需唤醒---即可获取CPU的执行权
	 */
	public static void m1() {
		
		synchronized(LOCK) {
			try {
				System.out.println("Thread "+Thread.currentThread().getName()+" enter...");
				Thread.sleep(3_000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 	wait() 需要释放监听器的锁---方法会让线程加入的监听器队列中，交出CPU的执行权并等待唤醒
	 */
	public static void m2() {
		
		synchronized(LOCK) {
			try {
				System.out.println("Thread "+Thread.currentThread().getName()+" enter...");
				LOCK.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
