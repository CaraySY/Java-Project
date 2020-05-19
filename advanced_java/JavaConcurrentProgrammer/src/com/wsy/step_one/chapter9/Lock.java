package com.wsy.step_one.chapter9;

import java.util.Collection;

/**
 * 	自定义显示锁
 * @author Administrator
 *
 */
public interface Lock {
	class TimeoutException extends Exception{
		/**
		 *  Default Serial ID
		 */
		private static final long serialVersionUID = 1L;

		public TimeoutException(String msg) {
			
			super(msg);
		}
	}
	
	void lock() throws InterruptedException;
	
	/**
	 * @param milesecond 毫秒
	 * @throws InterruptedException 中断异常
	 * @throws TimeoutException 超时异常
	 */
	void lock(long milesecond) throws InterruptedException,TimeoutException;
	
	void unlock();
	
	Collection<Thread> getBlockedThread();
	
	int getBlockedSize();
}
