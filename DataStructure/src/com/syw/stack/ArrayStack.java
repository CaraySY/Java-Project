package com.syw.stack;

public class ArrayStack {

	private int maxSize;
	private int top;
	private int[] stack;
	
	/*初始化栈*/
	public ArrayStack(int maxSize) {

		this.maxSize=maxSize;
		this.top=-1;
		this.stack=new int[maxSize];
	}
	
	/*压入栈*/
	public void push(int data) {
		
		/*如果栈满了，无法插入数据*/
		if(isFull()) {
			System.out.println("栈满，无法插入新的数据...");
			return;
		}
		stack[++top]=data;
	}
	
	public int pop() {
		
		if(isEmpty()) {
			throw new RuntimeException("栈为空，无法pop...");
		}
		return stack[top--];
	}
	
	public void print() {
		
		System.out.println("栈中的数据:");
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
