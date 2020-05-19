package com.wsy.step_one.chapter11;

import java.util.Optional;

/**
 * Thread Group common API
 * 
 * @author Administrator
 *
 */
public class ThreadGroupAPI {

	public static void main(String[] args) {

		// 1.use name
		ThreadGroup tg1 = new ThreadGroup("tg1");
		Thread t1 = new Thread(tg1, "t1") {
			@Override
			public void run() {

				Optional.of(
						Thread.currentThread().getName() + " belong to " + getThreadGroup().getName() + " threadgroup")
						.ifPresent(System.out::println);
				Optional.of(getThreadGroup().getName() + " super group is " + getThreadGroup().getParent().getName()
						+ " threadgroup").ifPresent(System.out::println);
			}
		};
		t1.start();
		// 2.use parent name
		ThreadGroup tg2 = new ThreadGroup(tg1, "tg2");
		Thread t2 = new Thread(tg2, "t2") {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1_000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t2.start();
		t1.checkAccess();
	}
}
