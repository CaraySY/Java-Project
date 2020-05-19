package com.wsy.step_one.chapter7;

public class DeadLock {

	private final Object LOCK=new Object();
	private OtherService otherService=new OtherService();
	
	public DeadLock(OtherService otherService) {
		super();
		this.otherService = otherService;
	}

	
	public void m1() {
		
		synchronized (LOCK) {
			
			System.out.println("m1========");
			otherService.s1(); //Ҳ����һ����
		}
	}
	
	public void m2() {
		
		synchronized (LOCK) {
			
			System.out.println("m2=========");
		}
	}
}
