package com.wsy.step_one.chapter5;

/**
 * 	ʹ��һ���������ж�ĳ���߳�
 * @author Administrator
 *
 */
public class ThreadCloseGraceful2 {

	private static class Worker extends Thread{
		
		@Override
		public void run() {
			
			while(true) {
				try {
					Thread.sleep(1_000);
				} catch (InterruptedException e) { //�����ж��쳣����ѭ��
					break;
				}
				
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		Worker worker=new Worker();
		worker.start();
		try {
			Thread.sleep(5_000); //���̵߳ȴ� 10��
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		worker.interrupt();
	}
}
