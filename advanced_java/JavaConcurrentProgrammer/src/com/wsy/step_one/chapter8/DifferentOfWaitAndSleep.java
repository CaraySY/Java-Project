package com.wsy.step_one.chapter8;

import java.util.stream.Stream;

/**
 * 	sleep()��wait()����������
 * @author Administrator
 *
 */
public class DifferentOfWaitAndSleep {

	private static final Object LOCK=new Object(); //������
	
	public static void main(String[] args) {
		
		Stream.of("t1","t2").forEach(name->{
			new Thread(name) { //���ݲ���
				@Override
				public void run() {
					m2();
				}
			}.start();
		});
	}
	
	/**
	 * 	sleep() ����Ҫ�ͷż���������---���軽��---���ɻ�ȡCPU��ִ��Ȩ
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
	 * 	wait() ��Ҫ�ͷż���������---���������̼߳���ļ����������У�����CPU��ִ��Ȩ���ȴ�����
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
