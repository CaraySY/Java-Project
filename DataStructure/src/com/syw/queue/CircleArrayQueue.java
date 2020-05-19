package com.syw.queue;

public class CircleArrayQueue {

	private int maxSize;//�洢�����ֵ
	private int front;//ָ���һ��Ԫ��
	private int rear;//ָ�����һ��Ԫ�ص���һ��λ�ã��ճ�һ��λ��
	private int[] arr;//�������ݵ�����
	
	public CircleArrayQueue(int maxSize) {
		
		this.maxSize=maxSize;
		this.arr=new int[maxSize];
		this.front=0;
		this.rear=0;
	}
	
	public void addQueue(int data) { //return (rear+1)%maxSize==front;
		
		if(isFull()) {
			System.out.println("�������ˣ��޷���������...");
			return;
		}
		arr[rear]=data;//����ֱ�Ӳ��뵽��β
		rear=(rear+1)%maxSize;//rearָ���ƶ�����ģ���㱣֤rear�� 0<-->[maxSize-1]
	}
	
	public int getQueue() {
		
		if(isEmpty()) {
			/*���쳣������ֵ*/
			throw new RuntimeException("�����г�������Ϊ��...");
		}
		int data=arr[front];//�����Ƴ�������
        front=(front+1)%maxSize;//frontָ���ƶ�����ģ���㱣֤front�� 0<-->[maxSize-1]
        return data;
	}
	
	public void printQueue() {
		
		if(isEmpty()) {
			System.out.println("�ն��У��޷�����...");
			return;
		}
		for(int i=front;i<front+size();i++) { 
			/*��� front=5,size()Ϊ4����i�Ĵ�СС�ڶ��������޷���ӡ������Ҫ  + front */
			/*i ��Ҫ��ģ���㱣֤��ֵ�� 0<-->maxSize-1*/
			System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
		}
	}
	
	public int size() {
		
		return (rear-front+maxSize)%maxSize; // ����ѭ�����еĳ��ȣ���ģ���㱣֤����һ��������
	}
	
	public boolean isFull() {
		
		return (rear+1)%maxSize==front;
	}
	
	public boolean isEmpty() {
		
		return front==rear;
	}
}
