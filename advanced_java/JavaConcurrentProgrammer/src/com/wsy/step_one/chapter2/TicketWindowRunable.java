package com.wsy.step_one.chapter2;

/**
 * 	实现Runnable接口可以不使用静态变量实现各个线程之间变量的共享
 * @author Administrator
 *
 */
public class TicketWindowRunable implements Runnable{
	
	private final int MAX=50;
	private int index=1; 
	

	@Override
	public void run() {
		
		while(index<=MAX) {
			System.out.println(Thread.currentThread().getName()+",当前的号码:"+(index++));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
