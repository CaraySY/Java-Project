package com.wsy.step_one.chapter1;

public class MainTest {

	public static void main(String[] args) {
		
		Thread t1=new Thread(()->{
			for(int i=0;i<1000;i++) {
				System.out.println(Thread.currentThread().getName());
				System.out.println("thread1:"+i);
			}
		}); 
		t1.setName("ds1");
		t1.start();//只有在创建的时候才是线程，不会被阻塞
		Thread t2=new Thread(()-> {
			for(int i=0;i<1000;i++) {
				System.out.println("thread2:"+i);
			}
		});
		t2.start();
	}
}
