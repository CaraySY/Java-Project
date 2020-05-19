package com.wsy.step_one.chapter9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 * 	自定义boolean锁
 * @author Administrator
 *
 */
public class BooleanLock implements Lock {

	//初始化为true，指明已经上锁
	//false指明锁已经释放
	private boolean initValue;
	
	private Thread currentThread;
	
	private Collection<Thread> blockedThreadCollection=new ArrayList<>();
	
	public BooleanLock() {
		
		this.initValue=false;
	}
	
	/**
	 * 	上锁
	 */
	@Override
	public synchronized void lock() throws InterruptedException {

		while(initValue) {
			blockedThreadCollection.add(Thread.currentThread());
			this.wait();
		}
		blockedThreadCollection.remove(Thread.currentThread()); //列表中删除
		this.initValue=true;
		this.currentThread=Thread.currentThread();
	}

	@Override
	public synchronized void lock(long milesecond) throws InterruptedException, TimeoutException {

		if(milesecond <= 0) {
			lock();
		}
		long hasRemaining=milesecond;
		long endTime=System.currentTimeMillis()+milesecond;
		while(initValue) {
			if(hasRemaining <= 0) {
				throw new TimeoutException("Time out...");
			}
			blockedThreadCollection.add(Thread.currentThread());
			this.wait(milesecond);
			hasRemaining=endTime-System.currentTimeMillis();
		}
		this.initValue=true;
		//标识该线程
		this.currentThread=Thread.currentThread();
	}

	@Override
	public synchronized void unlock() {

		if(currentThread==Thread.currentThread()) {
			this.initValue=false;
			//释放的是BooleanLock的实例
			Optional.of(Thread.currentThread()+" 已经释放锁定的监听器..").ifPresent(System.out::println);
			//通知所有线程
			this.notifyAll();
		}
	}

	@Override
	public Collection<Thread> getBlockedThread() {
		//返回一个无法被修改的Collection
		return Collections.unmodifiableCollection(blockedThreadCollection);
	}

	@Override
	public int getBlockedSize() {

		return blockedThreadCollection.size();
	}

}
