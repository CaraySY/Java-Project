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
		t1.start();//ֻ���ڴ�����ʱ������̣߳����ᱻ����
		Thread t2=new Thread(()-> {
			for(int i=0;i<1000;i++) {
				System.out.println("thread2:"+i);
			}
		});
		t2.start();
	}
}
