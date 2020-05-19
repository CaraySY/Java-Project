package com.syw.queue;

/**
 * 	ʹ��������ģ�����
 * @author Administrator
 *
 */
public class ArrayQueue {

	private int maxSize;//�洢�����ֵ
	private int front;//ָ���һ��Ԫ�ص�ǰһ��λ��
	private int rear;//ָ�����һ��Ԫ��
	private int[] arr;//�������ݵ�����
	
	public ArrayQueue(int maxSize) {
		
		this.maxSize=maxSize;
		this.front=-1;
		this.rear=-1;
		this.arr=new int[maxSize];
	}
	
	public boolean isFull() {
		
		return rear==maxSize-1;
	}
	
	public boolean isEmpty() {
		
		return front==rear;
	}
	
	public void addQueue(int data) {
		
		if(isFull()) {
			System.out.println("�������ˣ��޷���������...");
			return;
		}
		arr[++rear]=data;
	}
	
	public int getQueue() {
		
		if(isEmpty()) {
			/*���쳣������ֵ*/
			throw new RuntimeException("�����г�������Ϊ��...");
		}
		return arr[++front]; //���Ʋ����س����е�ֵ
	}
	
	public void printQueue() {
		
		if(isEmpty()) {
			System.out.println("�ն��У��޷�����...");
			return;
		}
		
		for(int i=front+1;i<=rear;i++) {
			
			System.out.printf("Queue arr[%d]=%d\n",i,arr[i]);
		}
	}
}
