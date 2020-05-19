package com.wsy.step_one.chapter5;

public class ThreadCloseForce {

	private static class Worker extends Thread{
		
		private boolean flag=true;
		@Override
		public void run() {
			
			while(flag) {
				// connection -------- 假定在通讯的过程中被block，该线程无法去捕获中断信号，需要强制去关闭线程
			}
		}
	}
	
	public static void main(String[] args) {
		
		Worker worker=new Worker();
		worker.start();
	}
}
