package com.syw.queue;

public class LinkedQueue {

	private HeroNode front=new HeroNode();
	private HeroNode rear=new HeroNode();
	
	/**
	 * 	ʹ��β�巨��������ģ�����Ӷ���
	 * @param no
	 * @param name
	 * @param nickname
	 */
	
	public LinkedQueue() {
		
		front=rear; //ͷ��β�ڵ�ָ��ͬһ��λ��
	}
	
	public void addQueue(int no,String name,String nickname) {
		
		HeroNode heroNode=new HeroNode(no,name,nickname);
		rear.next=heroNode;
		rear=heroNode;
	}
	
	public void popQueue() {
		
		if(isEmpty()) {
			System.out.println("����Ϊ�գ��޷�������...");
			return;
		}
		HeroNode curNode=front.next;//���浱ǰ�Ƴ��Ľڵ���Ϣ
		System.out.println("�Ƴ��Ľڵ���Ϣ:"+curNode);
		//ɾ���ڵ�
		front.next=curNode.next;
	}
	
	public int size() {
		
		HeroNode temp=front.next;
		int size=0;
		while(temp!=null) {
			size++;
			temp=temp.next;
		}
		return size;
	}
	
	public boolean isEmpty() {
		
		return front.next==null;
	}
	
	public void print() {
		
		HeroNode temp=front.next;
		while(temp!=null) {
			System.out.println(temp);
			temp=temp.next;
		}
	}
	
	private class HeroNode {

		private int no;
		private String name;
		private String nickname;
		private HeroNode next; // ָ����һ���ڵ�

		public HeroNode() {

		}

		public HeroNode(int no, String name, String nickname) {

			this.no = no;
			this.name = name;
			this.nickname = nickname;
		}

		@Override
		public String toString() {
			return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
		}
	}
}
