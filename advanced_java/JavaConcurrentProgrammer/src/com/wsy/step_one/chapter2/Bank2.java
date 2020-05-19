package com.wsy.step_one.chapter2;

/**
 * 	银行取号	version 1.2
 * @author Administrator
 *
 */
public class Bank2 {

	public static void main(String[] args) {
		
		TicketWindowRunable window=new TicketWindowRunable();
		Thread t1=new Thread(window,"一号窗口");
		Thread t2=new Thread(window,"二号窗口");
		Thread t3=new Thread(window,"三号窗口");
		t1.start();
		t2.start();
		t3.start();
	}
}
