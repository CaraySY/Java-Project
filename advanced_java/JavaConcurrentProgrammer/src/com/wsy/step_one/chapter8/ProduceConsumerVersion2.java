package com.wsy.step_one.chapter8;

/**
 * 	�����߳�֮���ͨ�ţ����͵����ӣ���������������
 * 	version 2---ֻ����һ�������ߺ�������
 * @author Administrator
 *
 */
public class ProduceConsumerVersion2 {

	private int i=1;
	final private Object LOCK=new Object();
	private volatile boolean isProduced=false; //�ж��Ƿ�����
	
	private void produce() {
		
		synchronized(LOCK) {
			if(isProduced) {
				try {
					LOCK.wait(); //�Ѿ������˵ȴ�������ȥ����
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("P->"+(i++));
				//TODO--֪ͨ������ȥ����
				LOCK.notify();
				isProduced=true;
			}
		}
	}
	
	private void cunsume() {
		
		synchronized(LOCK) {
			if(isProduced) {
				System.out.println("C->"+i);
				//֪ͨ�������Ѿ�������
				LOCK.notify();
				//�����Ѿ�����
				isProduced=false;
			}else {
				//����������û����������Ҫ�ȴ�
				try {
					LOCK.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		ProduceConsumerVersion2 version=new ProduceConsumerVersion2();
		new Thread("P") { //������
			@Override
			public void run() {
				while(true) {
					version.produce();
				}
			}
		}.start();
		new Thread("C") {	//������
			
			@Override
			public void run() {
				while(true) {
					version.cunsume();
				}
			}
		}.start();
	}
}
