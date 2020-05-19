package com.syw.queue;

public class CircleArrayQueue {

	private int maxSize;//存储的最大值
	private int front;//指向第一个元素
	private int rear;//指向最后一个元素的下一个位置，空出一个位置
	private int[] arr;//保存数据的数组
	
	public CircleArrayQueue(int maxSize) {
		
		this.maxSize=maxSize;
		this.arr=new int[maxSize];
		this.front=0;
		this.rear=0;
	}
	
	public void addQueue(int data) { //return (rear+1)%maxSize==front;
		
		if(isFull()) {
			System.out.println("队列满了，无法插入数据...");
			return;
		}
		arr[rear]=data;//数据直接插入到队尾
		rear=(rear+1)%maxSize;//rear指针移动，求模运算保证rear在 0<-->[maxSize-1]
	}
	
	public int getQueue() {
		
		if(isEmpty()) {
			/*抛异常处理返回值*/
			throw new RuntimeException("出队列出错，队列为空...");
		}
		int data=arr[front];//返回移除的数据
        front=(front+1)%maxSize;//front指针移动，求模运算保证front在 0<-->[maxSize-1]
        return data;
	}
	
	public void printQueue() {
		
		if(isEmpty()) {
			System.out.println("空队列，无法遍历...");
			return;
		}
		for(int i=front;i<front+size();i++) { 
			/*如果 front=5,size()为4，则i的大小小于队列容量无法打印数据需要  + front */
			/*i 需要求模运算保证数值在 0<-->maxSize-1*/
			System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
		}
	}
	
	public int size() {
		
		return (rear-front+maxSize)%maxSize; // 返回循环队列的长度，求模运算保证返回一个正整数
	}
	
	public boolean isFull() {
		
		return (rear+1)%maxSize==front;
	}
	
	public boolean isEmpty() {
		
		return front==rear;
	}
}
