package com.wsy.step_one.chapter6;

/**
 * 	ʵ��Runnable�ӿڿ��Բ�ʹ�þ�̬����ʵ�ָ����߳�֮������Ĺ���
 * @author Administrator
 *
 */
public class TicketWindowRunable implements Runnable{
	
	private final int MAX=500;
	private int index=1; 
	
	/*����һ��������--ͬ��*/
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
				System.out.println(Thread.currentThread()+" �ĺ�����:"+(index++));
			}
		}
	}

}
