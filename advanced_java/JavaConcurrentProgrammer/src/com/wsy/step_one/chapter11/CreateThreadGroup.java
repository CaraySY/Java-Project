package com.wsy.step_one.chapter11;

import java.util.Optional;

/**
 * 	创建线程组
 * @author Administrator
 *
 */
public class CreateThreadGroup {

	//ThreadGroup have two Constructors.
	public static void main(String[] args) {
		
		//1.use name
		ThreadGroup tg1=new ThreadGroup("tg1");
		Thread t1=new Thread(tg1,"t1") {
			@Override
			public void run() {

				Optional.of(Thread.currentThread().getName()+" belong to "
					+getThreadGroup().getName()+" threadgroup")
					.ifPresent(System.out::println);
				Optional.of(getThreadGroup().getName()
					+" super group is "+getThreadGroup().getParent().getName()+" threadgroup")
					.ifPresent(System.out::println);
			}
		};
		t1.start();
		ThreadGroup tg2=new ThreadGroup("tg1");
		Optional.of(Thread.currentThread().getName()+" belong to "
				+tg2.getName()+" threadgroup")
				.ifPresent(System.out::println);
			Optional.of(tg2.getName()
				+" super group is "+tg2.getParent().getName()+" threadgroup")
				.ifPresent(System.out::println);
		//2.use parent，name
		/*** main thread group
		Optional.of("Current ThreadGroup name "+Thread.currentThread().getThreadGroup().getName())
			.ifPresent(System.out::println);
		Optional.of("Current Thread name "+Thread.currentThread().getName())
		.ifPresent(System.out::println);
		*/
		
	}
}
