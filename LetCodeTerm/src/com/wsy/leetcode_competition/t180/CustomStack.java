package com.wsy.leetcode_competition.t180;

public class CustomStack {

	private int[] stack;
	private int top;
	private int maxSize;
	private int size;
	
	public CustomStack(int maxSize) {

		stack=new int[maxSize];
		this.top=-1;
		this.maxSize=maxSize;
		this.size=0;
	}

	public void push(int x) {

		if(size<maxSize) {
			stack[++top]=x;
			size++;
		}
	}

	public int pop() {

		if(size==0) {
			return -1;
		}else {
			size--;
			return stack[top--];
		}
	}

	public void increment(int k, int val) {

		if(k<=size) {
			for(int i=0;i<k;i++) {
				stack[i]+=val;
			}
		}else if(k>size) {
			for(int i=0;i<k;i++) {
				stack[i]+=val;
			}
		}
	}
}
