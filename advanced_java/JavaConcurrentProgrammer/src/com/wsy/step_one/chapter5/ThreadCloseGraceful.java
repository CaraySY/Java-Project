package com.wsy.step_one.chapter5;

/**
 * 	ʹ��һ���������ж�ĳ���߳�
 * @author Administrator
 *
 */
public class ThreadCloseGraceful {

	private static class Worker extends Thread{
		
		private volatile boolean start=true;//����һ��������shutdown�߳�
		@Override
		public void run() {
			
			while(start) {
				
			}
		}
		
		public void shutDown() {
			
			System.out.println("shutdown current thread...");
			this.start=false;
		}
	}
	
	public static void main(String[] args) {
		
		Worker worker=new Worker();
		worker.start();
		try {
			Thread.sleep(10_000); //���̵߳ȴ� 10��
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		worker.shutDown(); //�رյ�ǰ�߳�[worker�߳�]
	}
}
