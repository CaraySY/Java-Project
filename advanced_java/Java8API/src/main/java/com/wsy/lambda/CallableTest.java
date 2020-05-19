package com.wsy.lambda;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest {

	public static void main(String[] args) {
		
		Callable<Integer> call=new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				
				System.out.println("hello callable");
				return null;
			}
		};
		FutureTask<Integer> task=new FutureTask<>(call);
		Thread t=new Thread(task);
		t.start();
	}
}
