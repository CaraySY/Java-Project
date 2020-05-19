package com.wsy.step_one.chapter8;

import java.util.stream.Stream;

/**
 * 	两个线程之间的通信，典型的例子：生产者与消费者
 * 	version 2---只适用一个生产者和消费者----多个生产者、消费者会出现加锁---所有线程都放弃CPU执行权
 * @author Administrator
 *
 */
public class ProduceConsumerVersion3 {

	private int i=1;
	final private Object LOCK=new Object();
	private volatile boolean isProduced=false; //判断是否生产
	
	private void produce() {
		
		synchronized(LOCK) {
			if(isProduced) {
				try {
					LOCK.wait(); //已经生产了等待消费者去消费
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				i++;
				System.out.println("P->"+i);
				//TODO--通知消费者去消费
				LOCK.notify();
				isProduced=true;
			}
		}
	}
	
	private void cunsume() {
		
		synchronized(LOCK) {
			if(isProduced) {
				System.out.println("C->"+i);
				//通知生产者已经消费了
				LOCK.notify();
				//代表已经消费
				isProduced=false;
			}else {
				//代表生产者没有生产，需要等待
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
		//适用stream流定义多个生产者和消费者
		Stream.of("p1","p2").forEach(n->{
			new Thread() { //生产者
				@Override
				public void run() {
					while(true) {
						version.produce();
					}
				}
			}.start();
		});
		Stream.of("c1","c2").forEach(n->{
			new Thread() {	//消费者
				
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
