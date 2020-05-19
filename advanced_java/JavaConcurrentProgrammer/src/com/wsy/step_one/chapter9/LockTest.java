package com.wsy.step_one.chapter9;

import java.util.Optional;
import java.util.stream.Stream;

import com.wsy.step_one.chapter9.Lock.TimeoutException;

public class LockTest {

	public static void main(String[] args) {
		
		final BooleanLock booleanLock=new BooleanLock();
		Stream.of("t1","t2","t3","t4")
			.forEach(
				name->new Thread(()->{
					try {
						booleanLock.lock(3_000);
						Optional.of(Thread.currentThread().getName()+" have the lock montiter..")
							.ifPresent(System.out::println);
						work();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (TimeoutException e) {
						Optional.of(Thread.currentThread().getName()+" timeout Exception...").ifPresent(System.out::println);;
					}finally{
						booleanLock.unlock(); //必须确保谁加锁谁去释放
					}
					
				},name).start()
			);
		
		//测试已经满足谁上锁谁释放的原则
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		booleanLock.unlock();
	}
	
	public static void work() {
		
		Optional.of(Thread.currentThread().getName()+" is working...")
			.ifPresent(System.out::println);
		try {
			Thread.sleep(5_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
