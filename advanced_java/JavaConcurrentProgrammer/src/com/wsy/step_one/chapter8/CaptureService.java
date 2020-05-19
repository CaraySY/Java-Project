package com.wsy.step_one.chapter8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * 	�����������߽��Java 8ʵ��
 * @author Administrator
 *
 */
public class CaptureService {

	final private static int MAX_WORKERS=5;
	final private static LinkedList<Control> CONTROLES=new LinkedList<>();
	
	public static void main(String[] args) {
		
		List<Thread> worker=new ArrayList<>();
		Arrays.asList("m1","m2","m3","m4","m5","m6","m7","m8","m9","m10").stream()
			.map(CaptureService::createThread).forEach(t->{
				t.start();
				worker.add(t);//�����̳߳�
			});
		worker.stream().forEach(t->{
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Optional.of("All Thread END .").ifPresent(System.out::println);
	}
	
	private static Thread createThread(String name) {
		
		return new Thread(()->{ //ʹ��Runnable�ӿڴ���һ���̲߳�����������
			Optional.of("The worker ["+Thread.currentThread().getName()+" ] BEGIN capture data.")
				.ifPresent(System.out::println);
			synchronized(CONTROLES) {
				while(CONTROLES.size() > MAX_WORKERS) {
					try {
						CONTROLES.wait(); //�ȴ�����
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				//����������
				CONTROLES.addLast(new Control());
			}
			//���ڹ���
			Optional.of("The work [" +Thread.currentThread().getName()+ "] is working ...")
				.ifPresent(System.out::println);
			//������
			try {
				Thread.sleep(10_000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized(CONTROLES) {
				
				Optional.of("The work [" +Thread.currentThread().getName()+ "] is finshing.")
					.ifPresent(System.out::println);
				CONTROLES.removeFirst(); //��������Ƴ��̹߳�������
				CONTROLES.notifyAll();//���������߳�
			}
		},name);
	}
	
	private static class Control{
		
	}
}
