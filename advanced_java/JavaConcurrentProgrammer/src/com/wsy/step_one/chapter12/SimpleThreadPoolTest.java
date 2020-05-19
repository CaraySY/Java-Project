package com.wsy.step_one.chapter12;

import java.util.Optional;
import java.util.stream.IntStream;

public class SimpleThreadPoolTest {

	public static void main(String[] args) {
		
		SimpleThreadPool pool=new SimpleThreadPool();
		IntStream.rangeClosed(0, 40)
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
	}
}
