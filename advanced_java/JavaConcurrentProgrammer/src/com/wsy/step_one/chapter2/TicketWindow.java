package com.wsy.step_one.chapter2;


public class TicketWindow extends Thread{

	private static final int MAX=50;
	private static int index=1; //定义静态变量可以在不同的线程共享共一个变量
	private final String name;
	
	public TicketWindow(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		
		while(index<=MAX) {
			System.out.println("柜台"+name+"，当前的号码:"+(index++));
		}
	}
}
