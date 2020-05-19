package com.wsy.step_one.chapter9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 * 	�Զ���boolean��
 * @author Administrator
 *
 */
public class BooleanLock implements Lock {

	//��ʼ��Ϊtrue��ָ���Ѿ�����
	//falseָ�����Ѿ��ͷ�
	private boolean initValue;
	
	private Thread currentThread;
	
	private Collection<Thread> blockedThreadCollection=new ArrayList<>();
	
	public BooleanLock() {
		
		this.initValue=false;
	}
	
	/**
	 * 	����
	 */
	@Override
	public synchronized void lock() throws InterruptedException {

		while(initValue) {
			blockedThreadCollection.add(Thread.currentThread());
			this.wait();
		}
		blockedThreadCollection.remove(Thread.currentThread()); //�б���ɾ��
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
		//��ʶ���߳�
		this.currentThread=Thread.currentThread();
	}

	@Override
	public synchronized void unlock() {

		if(currentThread==Thread.currentThread()) {
			this.initValue=false;
			//�ͷŵ���BooleanLock��ʵ��
			Optional.of(Thread.currentThread()+" �Ѿ��ͷ������ļ�����..").ifPresent(System.out::println);
			//֪ͨ�����߳�
			this.notifyAll();
		}
	}

	@Override
	public Collection<Thread> getBlockedThread() {
		//����һ���޷����޸ĵ�Collection
		return Collections.unmodifiableCollection(blockedThreadCollection);
	}

	@Override
	public int getBlockedSize() {

		return blockedThreadCollection.size();
	}

}
