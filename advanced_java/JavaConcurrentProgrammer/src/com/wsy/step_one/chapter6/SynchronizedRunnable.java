package com.wsy.step_one.chapter6;

/**
 * 	同步方法
 * @author Administrator
 *
 */
public class SynchronizedRunnable implements Runnable{

	private final int MAX=500; //_readonly的data
	private int index=1; 
	
	//this
	@Override
	public void run() {

		while(true) {
			if(!ticket()) {
				break;
			}
		}
	}
	
	/**
	 * 	有共享的数据index-----需要共享代码块
	 *  对方法使用synchronized等价与对this(当前对象)加锁
	 * @return
	 */
	private synchronized boolean ticket() {
		
		//1、getField
		if(index > MAX) {
			return false;
		}
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//index ++
		//=>
		//1、getField
		//2、index=index+1
		//3、putField
		System.out.println(Thread.currentThread() + " 的号码是:" + (index++));
		return true;
	}
}
