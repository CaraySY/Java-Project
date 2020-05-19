package com.syw.list;


public class DoubleLinkedList {
	
	private HeroNode head = new HeroNode();// ����һ���յ�ͷ�ڵ�

	public HeroNode getHead() {
		
		return head;
	}
	
	/**
	 * 	�ҵ����һ������Ȼ�����
	 * @param heroNode
	 */
	private void add(HeroNode heroNode) {

		HeroNode temp=head;
		while(true) {
			if(isNull(temp.next)) {
				break;
			}
			temp=temp.next;//�ҵ����һ���ڵ�
		}
		/*Ĭ���ҵ����һ���ڵ�ɾ��*/
		temp.next=heroNode;
		heroNode.prev=temp;
	}

	public void add(int no,String name,String nickname) {
		
		HeroNode heroNode=new HeroNode(no,name,nickname);
		add(heroNode);
	}
	
	/**
	 * 	��Ҫ�ҵ����һ���ڵ�
	 * @param heroNode
	 */
	private void addByOrder(HeroNode heroNode) {
		
		HeroNode temp=head;
		boolean flag=false;
		while(true) {
			if(isNull(temp.next)) {
				break;
			}
			if(temp.next.no > heroNode.no) {
				break;
			}else if(temp.next.no == heroNode.no) { //��ͬ���޷����
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag) {
			System.out.println("�ýڵ��Ѿ����ڣ��޷����");
		}else {
			/*�ǵñ���next�ڵ㣬��ֹ����*/
			HeroNode next=temp.next;
			temp.next=heroNode;
			heroNode.prev=temp;
			heroNode.next=next;
		}
	}
	
	public void addByOrder(int no,String name,String nickname) {
		
		HeroNode heroNode=new HeroNode(no,name,nickname);
		addByOrder(heroNode);
	}

	public void update(int no,String name,String nickname) {
		
		HeroNode temp=head.next;//��Ч�ڵ�
		if(isNull(temp)) {
			System.out.println("����Ϊ��,�޷�����...");
			return;
		}
		boolean flag=false;//�ҵ��ı�ʶ
		while(true) {
			if(isNull(temp)) {
				break;
			}
			if(temp.no == no) {
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag) {
			System.out.printf("����[%d]:(%s)\n",temp.no,temp.name);
			temp.name=name;
			temp.nickname=nickname;
		}else {
			System.out.println("�Ҳ����ýڵ�...");
		}
	}
	
	/**
	 * 	˫������ɾ��ʱ������Ҫ�ҵ�ǰһ���ڵ�
	 * 	ֱ���ҵ���ǰ�ڵ㣬�޸ĵ�ǰ�ڵ��ǰ��ڵ��ָ��ɾ���ýڵ�
	 * 		temp.prev.next=temp.next;
			temp.next.prev=temp.prev;
	 * @param no
	 */
	public void remove(int no) {
		
		HeroNode temp=head.next;
		boolean flag=false;
		if(isNull(temp)) {
			System.out.println("����Ϊ��,�޷�ɾ��...");
			return;
		}
		while(true) {
			if(isNull(temp)) {
				break;
			}
			if(temp.no == no) {
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag) {
			System.out.printf("ɾ��[%d]:(%s)\n",temp.no,temp.name);
			temp.prev.next=temp.next;
			/*���ɾ�����һ���ڵ㣬���ֿ�ָ���쳣����Ҫ�пղ���*/
			if(!isNull(temp.next)) {
				temp.next.prev=temp.prev;
			}
		}else {
			System.out.println("�Ҳ����ýڵ�...");
		}
	}
	
	private boolean isNull(HeroNode node) {

		return node == null;
	}
	
	public void print() {

		HeroNode temp = head.next;
		if(isNull(temp)) {
			System.out.println("����Ϊ��...");
			return;
		}
		while (!(isNull(temp))) {
			System.out.println(temp);
			temp = temp.next;// ָ����һ���ڵ�
		}
	}

	/**
	 * ��������Ľڵ�
	 * 
	 * @author Administrator
	 *
	 */
	private class HeroNode {

		private int no;
		private String name;
		private String nickname;
		private HeroNode next; // ָ����һ���ڵ�
		private HeroNode prev;//ָ��ǰһ���ڵ�

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
