package com.wsy.step_one.chapter5;

public class ThreadCloseForce {

	private static class Worker extends Thread{
		
		private boolean flag=true;
		@Override
		public void run() {
			
			while(flag) {
				// connection -------- �ٶ���ͨѶ�Ĺ����б�block�����߳��޷�ȥ�����ж��źţ���Ҫǿ��ȥ�ر��߳�
			}
		}
	}
	
	public static void main(String[] args) {
		
		Worker worker=new Worker();
		worker.start();
	}
}
