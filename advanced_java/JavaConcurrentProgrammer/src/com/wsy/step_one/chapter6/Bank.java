package com.wsy.step_one.chapter6;

/**
 * 	ģ�����е���ȡ����--------�̵߳İ�ȫ����
 * @author Administrator
 *
 */
public class Bank {

	public static void main(String[] args) {
		
		TicketWindowRunable window=new TicketWindowRunable();
		Thread t1=new Thread(window,"һ�Ŵ���");
		Thread t2=new Thread(window,"���Ŵ���");
		Thread t3=new Thread(window,"���Ŵ���");
		t1.start();
		t2.start();
		t3.start();
	}
}