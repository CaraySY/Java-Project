package com.wsy.step_one.chapter3;

public class DaemonThread {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t=new Thread(()->{
			
			try {
				System.out.println(Thread.currentThread().getName()+" starting...");
				Thread.sleep(1000*10);
				System.out.println(Thread.currentThread().getName()+" finishing...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});// new ״̬
		t.setDaemon(true);
		t.start();//runnable ״̬  Ȼ�� -> running|block|dead
		Thread.sleep(1000*10);
		System.out.println("main thread finishing..."+Thread.currentThread().getName());
	}
}
