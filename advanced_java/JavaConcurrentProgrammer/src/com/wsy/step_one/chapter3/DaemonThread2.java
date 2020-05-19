package com.wsy.step_one.chapter3;

public class DaemonThread2 {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t=new Thread(()->{
			
			Thread innerThread=new Thread(()->{
				
				try {
					Thread.sleep(10_000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
			innerThread.setDaemon(true); //����Ϊ�ػ��̣߳����ⲿ�̹߳رպ󣬿��Բ����ֶ��ر��ػ��߳�
			innerThread.start();
			try {
				Thread.sleep(1_000);
				System.out.println("Thread t finishing...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});// new ״̬
		//t.setDaemon(true);
		t.start();//runnable ״̬  Ȼ�� -> running|block|dead
		
	}
}