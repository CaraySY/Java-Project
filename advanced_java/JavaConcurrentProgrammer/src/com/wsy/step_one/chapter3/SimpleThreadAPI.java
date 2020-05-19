package com.wsy.step_one.chapter3;

import java.util.Optional;

public class SimpleThreadAPI {

	public static void main(String[] args) {
		
		Thread t=new Thread(()->{
			Optional.of("Hello").ifPresent(System.out::println);
			try {
				Thread.sleep(10_000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		},"t1");
		t.start();
		Optional.of(t.getName()).ifPresent(System.out::println);
		Optional.of(t.getId()).ifPresent(System.out::println);
		Optional.of(t.getPriority()).ifPresent(System.out::println);
	}
}
