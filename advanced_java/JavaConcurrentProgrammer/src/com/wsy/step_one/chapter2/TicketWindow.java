package com.wsy.step_one.chapter2;


public class TicketWindow extends Thread{

	private static final int MAX=50;
	private static int index=1; //���徲̬���������ڲ�ͬ���̹߳���һ������
	private final String name;
	
	public TicketWindow(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		
		while(index<=MAX) {
			System.out.println("��̨"+name+"����ǰ�ĺ���:"+(index++));
		}
	}
}
