package com.wsy.step_one.chapter8;

import java.util.stream.Stream;

/**
 * 	�����߳�֮���ͨ�ţ����͵����ӣ���������������
 * 	version 2---ֻ����һ�������ߺ�������----��������ߡ������߻���ּ���---�����̶߳�����CPUִ��Ȩ
 * @author Administrator
 *
 */
public class ProduceConsumerVersion3 {

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
				i++;
				System.out.println("P->"+i);
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
		
		ProduceConsumerVersion3 version=new ProduceConsumerVersion3();
		//����stream�������������ߺ�������
		Stream.of("p1","p2").forEach(n->{
			new Thread() { //������
				@Override
				public void run() {
					while(true) {
						version.produce();
					}
				}
			}.start();
		});
		Stream.of("c1","c2").forEach(n->{
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
