package com.wsy.step_one.chapter6;

/**
 * 	ͬ������
 * @author Administrator
 *
 */
public class SynchronizedRunnable implements Runnable{

	private final int MAX=500; //_readonly��data
	private int index=1; 
	
	//this
	@Override
	public void run() {

		while(true) {
			if(!ticket()) {
				break;
			}
		}
	}
	
	/**
	 * 	�й��������index-----��Ҫ��������
	 *  �Է���ʹ��synchronized�ȼ����this(��ǰ����)����
	 * @return
	 */
	private synchronized boolean ticket() {
		
		//1��getField
		if(index > MAX) {
			return false;
		}
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//index ++
		//=>
		//1��getField
		//2��index=index+1
		//3��putField
		System.out.println(Thread.currentThread() + " �ĺ�����:" + (index++));
		return true;
	}
}
