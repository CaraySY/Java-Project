package com.wsy.step_one.chapter5;

public class ThreadService {

	private Thread executeThread; //����һ��ִ���߳�
	private boolean finished=false;
	
	public void execute(Runnable task) {
		
		executeThread=new Thread() {
			@Override
			public void run() {
				
				Thread runner=new Thread(task); //���ػ��߳�ȥִ������
				runner.setDaemon(true); //����Ϊ�ػ��̣߳���ִ���̹߳رգ��ػ��߳�Ҳ����֮���ر�
				runner.start();
				try {
					runner.join(); //�ػ��߳���Ҫ�ȴ�ִ���߳̽���---��Ȼ�����ִ���߳̽������ػ��߳�ʲô��û����ֱ�ӽ���
					finished=true;
				} catch (InterruptedException e) {
					
				}
			}
		};
		executeThread.start();
	}
	
	public void shutdown(long mills) {
		
		long currentTime=System.currentTimeMillis();
		while(!finished) {
			if((System.currentTimeMillis()-currentTime) >= mills){
				System.out.println("����ʱ����Ҫ���������񣡣���");
				executeThread.interrupt();
				break;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				System.out.println("�̱߳����");
				break;
			}
		}
		finished=false;
	}
}
