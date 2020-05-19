package com.syw.queue;

/**
 * 	使用数组来模拟队列
 * @author Administrator
 *
 */
public class ArrayQueue {

	private int maxSize;//存储的最大值
	private int front;//指向第一个元素的前一个位置
	private int rear;//指向最后一个元素
	private int[] arr;//保存数据的数组
	
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
			System.out.println("队列满了，无法插入数据...");
			return;
		}
		arr[++rear]=data;
	}
	
	public int getQueue() {
		
		if(isEmpty()) {
			/*抛异常处理返回值*/
			throw new RuntimeException("出队列出错，队列为空...");
		}
		return arr[++front]; //后移并返回出队列的值
	}
	
	public void printQueue() {
		
		if(isEmpty()) {
			System.out.println("空队列，无法遍历...");
			return;
		}
		
		for(int i=front+1;i<=rear;i++) {
			
			System.out.printf("Queue arr[%d]=%d\n",i,arr[i]);
		}
	}
}
