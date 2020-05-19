package com.syw.stack;

public class LinkedStack {

	private Node top=new Node(); //栈顶指针，栈顶指针下一个节点存放数据
	
	/**
	 * 	使用头插法建立链表，模拟栈的操作
	 * @param data
	 */
	public void push(int data) {
		
		Node node=new Node(data);
		node.data=data;
		node.next=top.next;
		top.next=node; //当前插入的节点设置为头节点
	}
	
	public int pop() {
		
		if(isEmpty()) {
			throw new RuntimeException("空栈，无法出栈...");
		}
		Node curNode=top.next;
		int data=curNode.data;
		top.next=curNode.next;
		return data;
	}
	
	public void print() {
		
		System.out.println("栈中的数据:");
		Node temp=top.next;
		while(temp!=null) {
			System.out.print(temp);
			if(temp.next!=null) {
				System.out.print("->");
			}
			temp=temp.next;
		}
		System.out.println();
	}
	
	public boolean isEmpty() {
		
		return top.next==null;
	}
	
	private class Node{
		
		private int data;//栈中存放的数据
		private Node next;//指向下一个节点
		
		public Node() {
			
		}
		
		public Node(int data) {
			
			this.data=data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
	}
}
