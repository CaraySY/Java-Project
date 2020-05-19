package com.wsy.step_one.chapter2;

public class CreateThread {

	private static int count=0;
	
	public static void main(String[] args) {
		
		//修改虚拟机栈帧的大小
		Thread t1=new Thread(null,new Runnable() {

			@Override
			public void run() {
				try {
					add(0);
				} catch (Error e) {
					e.printStackTrace();
					System.out.println(count);
				}
			}
			
			private void add(int i) {
				count++;
				add(i+1);
			}
		},"test",1 << 24);
		t1.start();
	}
}
