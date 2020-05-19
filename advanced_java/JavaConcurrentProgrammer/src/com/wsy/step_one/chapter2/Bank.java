package com.wsy.step_one.chapter2;

/**
 * 	模拟银行调度取号码
 * @author Administrator
 *
 */
public class Bank {

	public static void main(String[] args) {
		
		TicketWindow window=new TicketWindow("一号柜台");
		window.start();
		TicketWindow window2=new TicketWindow("二号柜台");
		window2.start();
		TicketWindow window3=new TicketWindow("三号柜台");
		window3.start();
	}
}
