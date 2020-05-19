package com.wsy.step_one.chapter4;

import java.util.Optional;
import java.util.stream.IntStream;

public class ThreadJoin {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t1=new Thread(()->{
			IntStream.range(1,1000).forEach(i->{
				System.out.println(Thread.currentThread().getName()+"-"+i);
			});
		});
		t1.start();
		t1.join();//让t1执行结束才执行当前线程
		Thread t2=new Thread(()->{
			IntStream.range(1,1000).forEach(i->{
				System.out.println(Thread.currentThread().getName()+"-"+i);
			});
		});
		t2.start();
		t2.join();//让t2执行结束才执行当前线程
		//t1 t2会交替执行
		Optional.of("All Thread have done.").ifPresent(System.out::println);;
		IntStream.range(1,1000).forEach(i->{
			System.out.println(Thread.currentThread().getName()+"-"+i);
		});
	}
}
