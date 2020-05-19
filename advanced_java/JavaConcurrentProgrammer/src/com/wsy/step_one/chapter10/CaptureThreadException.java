package com.wsy.step_one.chapter10;

/**
 * 	捕获线程在run方法的的异常
 * @author Administrator
 *
 */
public class CaptureThreadException {

	private final static int A=10;
	private final static int B=0;
	
	public static void main(String[] args) {
		
		Thread t=new Thread(()->{
			
			try {
				//休眠
				Thread.sleep(3_000);
				int res=A/B;
				System.out.println("the result is "+res);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		},"t");
		t.start();
		//使用注入接口的方式捕获多线程运行时的异常
		t.setUncaughtExceptionHandler((thread,e)->{
			System.out.println("Thread "+thread+"Exception information:"+e);
		});
	}
}
