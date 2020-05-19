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
		t1.join();//��t1ִ�н�����ִ�е�ǰ�߳�
		Thread t2=new Thread(()->{
			IntStream.range(1,1000).forEach(i->{
				System.out.println(Thread.currentThread().getName()+"-"+i);
			});
		});
		t2.start();
		t2.join();//��t2ִ�н�����ִ�е�ǰ�߳�
		//t1 t2�ύ��ִ��
		Optional.of("All Thread have done.").ifPresent(System.out::println);;
		IntStream.range(1,1000).forEach(i->{
			System.out.println(Thread.currentThread().getName()+"-"+i);
		});
	}
}
