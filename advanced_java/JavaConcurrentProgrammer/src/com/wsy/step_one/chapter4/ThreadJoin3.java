package com.wsy.step_one.chapter4;

public class ThreadJoin3 {

	public static void main(String[] args) throws InterruptedException {
		
		long startTimestamp=System.currentTimeMillis();
		Thread t1=new Thread(new CaptureRunnable("M1", 10_000L));
		Thread t2=new Thread(new CaptureRunnable("M2", 10_000L));
		Thread t3=new Thread(new CaptureRunnable("M3", 10_000L));
		t1.start();
		t2.start();
		t3.start();
		//join ���������õ�ǰִ�е��߳�---[main�߳�]�ȴ������߳̽�����ִ��
		t1.join();
		t2.join();
		t3.join();
		long endTimestamp=System.currentTimeMillis();
		System.out.printf("Data capture beginning. startTimestamp %s,endTimeStamp %s\n",startTimestamp,endTimestamp);
	}
	
	/**
	 *  ʹ�ö��߳�ģ���ڶ�̨�������ɼ�����
	 * @author Administrator
	 *
	 */
	static class CaptureRunnable implements Runnable{

		private String machineName;
		private long spendTime;
		
		public CaptureRunnable(String machineName,long spendTime) {

			this.machineName = machineName;
			this.spendTime=spendTime;
		}

		public String getResult() {
			
			return machineName + "finished";
		}
		
		@Override
		public void run() {
			
			try {
				Thread.sleep(spendTime);
				System.out.println(machineName + "at timestamp "+System.currentTimeMillis()+" successful capture data.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
