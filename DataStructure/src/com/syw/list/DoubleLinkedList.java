package com.syw.list;


public class DoubleLinkedList {
	
	private HeroNode head = new HeroNode();// 创建一个空的头节点

	public HeroNode getHead() {
		
		return head;
	}
	
	/**
	 * 	找到最后一个数据然后插入
	 * @param heroNode
	 */
	private void add(HeroNode heroNode) {

		HeroNode temp=head;
		while(true) {
			if(isNull(temp.next)) {
				break;
			}
			temp=temp.next;//找到最后一个节点
		}
		/*默认找到最后一个节点删除*/
		temp.next=heroNode;
		heroNode.prev=temp;
	}

	public void add(int no,String name,String nickname) {
		
		HeroNode heroNode=new HeroNode(no,name,nickname);
		add(heroNode);
	}
	
	/**
	 * 	需要找到最后一个节点
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
			}else if(temp.next.no == heroNode.no) { //相同的无法添加
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag) {
			System.out.println("该节点已经存在，无法添加");
		}else {
			/*记得保存next节点，防止断链*/
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
		
		HeroNode temp=head.next;//有效节点
		if(isNull(temp)) {
			System.out.println("链表为空,无法更新...");
			return;
		}
		boolean flag=false;//找到的标识
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
			System.out.printf("更新[%d]:(%s)\n",temp.no,temp.name);
			temp.name=name;
			temp.nickname=nickname;
		}else {
			System.out.println("找不到该节点...");
		}
	}
	
	/**
	 * 	双向链表删除时，不需要找到前一个节点
	 * 	直接找到当前节点，修改当前节点的前后节点的指向，删除该节点
	 * 		temp.prev.next=temp.next;
			temp.next.prev=temp.prev;
	 * @param no
	 */
	public void remove(int no) {
		
		HeroNode temp=head.next;
		boolean flag=false;
		if(isNull(temp)) {
			System.out.println("链表为空,无法删除...");
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
			System.out.printf("删除[%d]:(%s)\n",temp.no,temp.name);
			temp.prev.next=temp.next;
			/*如果删除最后一个节点，出现空指针异常，需要判空操作*/
			if(!isNull(temp.next)) {
				temp.next.prev=temp.prev;
			}
		}else {
			System.out.println("找不到该节点...");
		}
	}
	
	private boolean isNull(HeroNode node) {

		return node == null;
	}
	
	public void print() {

		HeroNode temp = head.next;
		if(isNull(temp)) {
			System.out.println("链表为空...");
			return;
		}
		while (!(isNull(temp))) {
			System.out.println(temp);
			temp = temp.next;// 指向下一个节点
		}
	}

	/**
	 * 定义链表的节点
	 * 
	 * @author Administrator
	 *
	 */
	private class HeroNode {

		private int no;
		private String name;
		private String nickname;
		private HeroNode next; // 指向下一个节点
		private HeroNode prev;//指向前一个节点

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
