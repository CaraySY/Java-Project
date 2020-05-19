package com.wsy.step_one.chapter6;

/**
 * 	实现Runnable接口可以不使用静态变量实现各个线程之间变量的共享
 * @author Administrator
 *
 */
public class TicketWindowRunable implements Runnable{
	
	private final int MAX=500;
	private int index=1; 
	
	/*定义一个监听器--同步*/
	private final Object MONITOR = new Object();
	

	@Override
	public void run() {
		
		synchronized(MONITOR) {
			while(true) {
				if(index > MAX) {
					break;
				}
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread()+" 的号码是:"+(index++));
			}
		}
	}

}
