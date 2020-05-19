package com.wsy.step_one.chapter8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * 	生产者消费者结合Java 8实例
 * @author Administrator
 *
 */
public class CaptureService {

	final private static int MAX_WORKERS=5;
	final private static LinkedList<Control> CONTROLES=new LinkedList<>();
	
	public static void main(String[] args) {
		
		List<Thread> worker=new ArrayList<>();
		Arrays.asList("m1","m2","m3","m4","m5","m6","m7","m8","m9","m10").stream()
			.map(CaptureService::createThread).forEach(t->{
				t.start();
				worker.add(t);//加入线程池
			});
		worker.stream().forEach(t->{
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Optional.of("All Thread END .").ifPresent(System.out::println);
	}
	
	private static Thread createThread(String name) {
		
		return new Thread(()->{ //使用Runnable接口创建一个线程并给它起名字
			Optional.of("The worker ["+Thread.currentThread().getName()+" ] BEGIN capture data.")
				.ifPresent(System.out::println);
			synchronized(CONTROLES) {
				while(CONTROLES.size() > MAX_WORKERS) {
					try {
						CONTROLES.wait(); //等待唤醒
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				//加入容器中
				CONTROLES.addLast(new Control());
			}
			//正在工作
			Optional.of("The work [" +Thread.currentThread().getName()+ "] is working ...")
				.ifPresent(System.out::println);
			//简单休眠
			try {
				Thread.sleep(10_000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized(CONTROLES) {
				
				Optional.of("The work [" +Thread.currentThread().getName()+ "] is finshing.")
					.ifPresent(System.out::println);
				CONTROLES.removeFirst(); //工作完毕移除线程工作队列
				CONTROLES.notifyAll();//唤醒所有线程
			}
		},name);
	}
	
	private static class Control{
		
	}
}
