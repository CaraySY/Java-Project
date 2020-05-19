package com.wsy.step_one.chapter6;

public class SynchronizedStaticTest {

	public static void main(String[] args) {
		
		Thread t1=new Thread() {
			@Override
			public void run() {
				SynchronizedStatic.m1();
			}
		};
		Thread t2=new Thread() {
			@Override
			public void run() {
				SynchronizedStatic.m2();
			}
		};
		Thread t3=new Thread() {
			@Override
			public void run() {
				SynchronizedStatic.m3();
			}
		};
		t1.start();
		t2.start();
		t3.start();
	}
}
