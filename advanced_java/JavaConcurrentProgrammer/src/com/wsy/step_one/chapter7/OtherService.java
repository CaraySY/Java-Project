package com.wsy.step_one.chapter7;

public class OtherService {

	private final Object LOCK=new Object();
	
	private DeadLock deadLock;
	
	public void s1() {
		
		synchronized (LOCK) {
			System.out.println("s1===============");
		}
	}

	public void s2() {

		synchronized (LOCK) {
			System.out.println("s2===============");
			deadLock.m2(); //´æÔÚËø
		}
	}
	
	public void setDeadLock(DeadLock deadLock) {
		this.deadLock = deadLock;
	}
}
