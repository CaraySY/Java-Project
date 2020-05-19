package com.syw.queue;

public class LinkedQueue {

	private HeroNode front=new HeroNode();
	private HeroNode rear=new HeroNode();
	
	/**
	 * 	使用尾插法建立链表模拟链接队列
	 * @param no
	 * @param name
	 * @param nickname
	 */
	
	public LinkedQueue() {
		
		front=rear; //头，尾节点指向同一个位置
	}
	
	public void addQueue(int no,String name,String nickname) {
		
		HeroNode heroNode=new HeroNode(no,name,nickname);
		rear.next=heroNode;
		rear=heroNode;
	}
	
	public void popQueue() {
		
		if(isEmpty()) {
			System.out.println("队列为空，无法出队列...");
			return;
		}
		HeroNode curNode=front.next;//保存当前移除的节点信息
		System.out.println("移除的节点信息:"+curNode);
		//删除节点
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
		private HeroNode next; // 指向下一个节点

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
