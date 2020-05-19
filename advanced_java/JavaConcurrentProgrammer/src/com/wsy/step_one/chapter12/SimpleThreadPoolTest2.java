package com.wsy.step_one.chapter12;

import java.util.Optional;
import java.util.stream.IntStream;

public class SimpleThreadPoolTest2 {

	public static void main(String[] args) throws InterruptedException {
		
		SimpleThreadPool2 pool=new SimpleThreadPool2(5,5,SimpleThreadPool2.DEFAULT_DISCARD_POLICY) ;
		IntStream.rangeClosed(0, 10)
			.forEach(i->{
				pool.submit(()->{
					Optional.of("The runnable "+i+" be serviced by "+Thread.currentThread()+" start.")
							.ifPresent(System.out::println);
					try {
						Thread.sleep(1_000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Optional.of("The runnable "+i+" be serviced by "+Thread.currentThread()+" finished.")
					.ifPresent(System.out::println);
				});
			});
		Thread.sleep(3_000);
		pool.shutdown();
		pool.submit(()->{
			System.out.println("hello world..");
		});
	}
}
