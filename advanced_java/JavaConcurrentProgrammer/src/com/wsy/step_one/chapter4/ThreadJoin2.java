package com.wsy.step_one.chapter4;

import java.util.Optional;
import java.util.stream.IntStream;

public class ThreadJoin2 {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t1=new Thread(()->{
			System.out.println("t1 is running...");
			try {
				Thread.sleep(10_000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("t1 is finishing...");
		});
		t1.start();
		t1.join(100); //µÈ´ı100ms
		Optional.of("All task is done,Main thread is running").ifPresent(System.out::println);
		IntStream.range(1,1000).forEach(i->{
			System.out.println(Thread.currentThread().getName()+"-"+i);
		});
	}
}
