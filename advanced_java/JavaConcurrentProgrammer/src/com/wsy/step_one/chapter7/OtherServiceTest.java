package com.wsy.step_one.chapter7;

public class OtherServiceTest {

	public static void main(String[] args) {
		
		OtherService otherService=new OtherService();
		DeadLock deadLock=new DeadLock(otherService);
		otherService.setDeadLock(deadLock);
		new Thread() {
			@Override
			public void run() {
				while(true) {
					deadLock.m1();
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				while(true) {
					otherService.s2();
				}
			}
		}.start();;
		
		
		
	}
}
