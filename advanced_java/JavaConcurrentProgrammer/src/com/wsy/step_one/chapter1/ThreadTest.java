package com.wsy.step_one.chapter1;

public class ThreadTest {

	public final void print(String msg) {
		
		wrapPrint(msg);
	}
	
	protected void wrapPrint(String msg) {
		
	}
	
	public static void main(String[] args) {
		
		ThreadTest t1=new ThreadTest() {

			@Override
			protected void wrapPrint(String msg) {
				System.out.println("+"+msg+"+");
			}
			
		};
		t1.wrapPrint("Hello");
	}
}
