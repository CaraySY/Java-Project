package com.wsy.step_one.chapter8;

/**
 * 	�����߳�֮���ͨ�ţ����͵����ӣ���������������
 * @author Administrator
 *
 */
public class ProduceConsumerVersion {

	private int i=1;
	final private Object LOCK=new Object();
	
	private void produce() {
		
		synchronized(LOCK) {
			System.out.println("P->"+(i++));
		}
	}
	
	private void cunsumer() {
		
		synchronized(LOCK) {
			System.out.println("C->"+(i++));
		}
	}
	
	public static void main(String[] args) {
		
		ProduceConsumerVersion version=new ProduceConsumerVersion();
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
					version.cunsumer();
				}
			}
		}.start();
	}
}
