package com.wsy.step_one.chapter2;

/**
 * 	ʵ��Runnable�ӿڿ��Բ�ʹ�þ�̬����ʵ�ָ����߳�֮������Ĺ���
 * @author Administrator
 *
 */
public class TicketWindowRunable implements Runnable{
	
	private final int MAX=50;
	private int index=1; 
	

	@Override
	public void run() {
		
		while(index<=MAX) {
			System.out.println(Thread.currentThread().getName()+",��ǰ�ĺ���:"+(index++));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
