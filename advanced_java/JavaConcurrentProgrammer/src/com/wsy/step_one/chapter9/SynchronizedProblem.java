package com.wsy.step_one.chapter9;

import java.util.Optional;

/**
 * 	SynchronizedµÄÈ±ÏÝ
 * @author Administrator
 *
 */
public class SynchronizedProblem {

	public static void main(String[] args) throws InterruptedException {
		
		new Thread() {
			@Override
			public void run() {
				Optional.of("t1 running...").ifPresent(System.out::println);
				SynchronizedProblem.run();
			}
		}.start();
		Thread t2=new Thread() {
			@Override
			public void run() {
				Optional.of("t2 running...").ifPresent(System.out::println);
				SynchronizedProblem.run();
			}
		};
		Thread.sleep(2_000);
		t2.start();
		t2.interrupt();
	}
	
	private synchronized static void run() {
		
		Optional.of("Thread ["+Thread.currentThread().getName()+" ] is working..").ifPresent(System.out::println);
		while(true) {
			
		}
	}
}
