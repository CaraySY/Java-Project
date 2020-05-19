package com.syw.stack;

public class ArrayStack {

	private int maxSize;
	private int top;
	private int[] stack;
	
	/*��ʼ��ջ*/
	public ArrayStack(int maxSize) {

		this.maxSize=maxSize;
		this.top=-1;
		this.stack=new int[maxSize];
	}
	
	/*ѹ��ջ*/
	public void push(int data) {
		
		/*���ջ���ˣ��޷���������*/
		if(isFull()) {
			System.out.println("ջ�����޷������µ�����...");
			return;
		}
		stack[++top]=data;
	}
	
	public int pop() {
		
		if(isEmpty()) {
			throw new RuntimeException("ջΪ�գ��޷�pop...");
		}
		return stack[top--];
	}
	
	public void print() {
		
		System.out.println("ջ�е�����:");
		for(int i=top;i>=0;i--) {
			System.out.print(stack[i]);
			if(i!=0) {
				System.out.print("->");
			}
		}
		System.out.println();
	}
	
	public boolean isEmpty() {
		
		return top==-1;
	}
	
	public boolean isFull() {
		
		return top==maxSize-1;
	}
}
