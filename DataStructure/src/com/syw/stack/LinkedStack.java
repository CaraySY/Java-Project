package com.syw.stack;

public class LinkedStack {

	private Node top=new Node(); //ջ��ָ�룬ջ��ָ����һ���ڵ�������
	
	/**
	 * 	ʹ��ͷ�巨��������ģ��ջ�Ĳ���
	 * @param data
	 */
	public void push(int data) {
		
		Node node=new Node(data);
		node.data=data;
		node.next=top.next;
		top.next=node; //��ǰ����Ľڵ�����Ϊͷ�ڵ�
	}
	
	public int pop() {
		
		if(isEmpty()) {
			throw new RuntimeException("��ջ���޷���ջ...");
		}
		Node curNode=top.next;
		int data=curNode.data;
		top.next=curNode.next;
		return data;
	}
	
	public void print() {
		
		System.out.println("ջ�е�����:");
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
		
		private int data;//ջ�д�ŵ�����
		private Node next;//ָ����һ���ڵ�
		
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
