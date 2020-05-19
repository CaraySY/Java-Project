package com.wsy.step_one.chapter8;

/**
 * 	两个线程之间的通信，典型的例子：生产者与消费者
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
		new Thread("P") { //生产者
			@Override
			public void run() {
				while(true) {
					version.produce();
				}
			}
		}.start();
		new Thread("C") {	//消费者
			
			@Override
			public void run() {
				while(true) {
					version.cunsumer();
				}
			}
		}.start();
	}
}
