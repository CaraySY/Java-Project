package com.wsy.step_one.chapter8;

import java.util.stream.Stream;

/**
 * 	�����߳�֮���ͨ�ţ����͵����ӣ���������������
 * 	version 2---ֻ����һ�������ߺ�������----��������ߡ������߻���ּ���---�����̶߳�����CPUִ��Ȩ
 * 		ʹ��while���Խ����������ߡ�������������������ظ����ѵ�����
 * @author Administrator
 *
 */
public class ProduceConsumerVersion4 {

	private int i=1;
	final private Object LOCK=new Object();
	private volatile boolean isProduced=false; //�ж��Ƿ�����
	
	private void produce() {
		
		synchronized(LOCK) {
			while(isProduced) {
				try {
					LOCK.wait(); //�Ѿ������˵ȴ�������ȥ����
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			i++;
			System.out.println("P->" + i);
			// TODO--֪ͨ������ȥ����
			LOCK.notifyAll();
			isProduced = true;
			
		}
	}
	
	private void cunsume() {
		
		synchronized(LOCK) {
			
			while(!isProduced) {
				try {
					// ����������û����������Ҫ�ȴ�
					LOCK.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("C->"+i);
			//֪ͨ�������Ѿ�������
			LOCK.notifyAll();
			//�����Ѿ�����
			isProduced=false;
		}
	}
	
	public static void main(String[] args) {
		
		ProduceConsumerVersion4 version=new ProduceConsumerVersion4();
		//����stream�������������ߺ�������
		Stream.of("p1","p2","p3","p4").forEach(n->{
			new Thread() { //������
				@Override
				public void run() {
					while(true) {
						version.produce();
					}
				}
			}.start();
		});
		Stream.of("c1","c2","c3","c4").forEach(n->{
			new Thread() {	//������
				
				@Override
				public void run() {
					while(true) {
						version.cunsume();
					}
				}
			}.start();
		});

		
	}
}
