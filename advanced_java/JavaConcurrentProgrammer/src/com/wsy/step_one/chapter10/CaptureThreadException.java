package com.wsy.step_one.chapter10;

/**
 * 	�����߳���run�����ĵ��쳣
 * @author Administrator
 *
 */
public class CaptureThreadException {

	private final static int A=10;
	private final static int B=0;
	
	public static void main(String[] args) {
		
		Thread t=new Thread(()->{
			
			try {
				//����
				Thread.sleep(3_000);
				int res=A/B;
				System.out.println("the result is "+res);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		},"t");
		t.start();
		//ʹ��ע��ӿڵķ�ʽ������߳�����ʱ���쳣
		t.setUncaughtExceptionHandler((thread,e)->{
			System.out.println("Thread "+thread+"Exception information:"+e);
		});
	}
}
