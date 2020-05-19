package com.wsy.step_one.chapter9;

import java.util.Collection;

/**
 * 	�Զ�����ʾ��
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
	 * @param milesecond ����
	 * @throws InterruptedException �ж��쳣
	 * @throws TimeoutException ��ʱ�쳣
	 */
	void lock(long milesecond) throws InterruptedException,TimeoutException;
	
	void unlock();
	
	Collection<Thread> getBlockedThread();
	
	int getBlockedSize();
}
