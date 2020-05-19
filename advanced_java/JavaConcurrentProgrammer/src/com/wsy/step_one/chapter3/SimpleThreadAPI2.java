package com.wsy.step_one.chapter3;

import java.util.Optional;

public class SimpleThreadAPI2 {

	public static void main(String[] args) {
		
		Thread t1=new Thread(()->{
			for(int i=0;i<100;i++) {
				Optional.of(Thread.currentThread().getName()+"-index-"+i).ifPresent(System.out::println);
			}
		},"t1");
		Thread t2=new Thread(()->{
			for(int i=0;i<100;i++) {
				Optional.of(Thread.currentThread().getName()+"-index-"+i).ifPresent(System.out::println);
			}
		},"t2");
		Thread t3=new Thread(()->{
			for(int i=0;i<100;i++) {
				Optional.of(Thread.currentThread().getName()+"-index-"+i).ifPresent(System.out::println);
			}
		},"t3");
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		t3.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
	}
}
