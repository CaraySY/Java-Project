package com.wsy;

public class TestJoin {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t1=new Thread(()->{
			
			System.out.println("this is t1 thread....");
		},"t1");
		Thread t2=new Thread(()->{
			
			System.out.println("this is t2 thread....");
		},"t2");
		t1.start();
		t2.start();
		t2.join();
		t1.join();
		System.out.println("this is main thread...");
	}
}
