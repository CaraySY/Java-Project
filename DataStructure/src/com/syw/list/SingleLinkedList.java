package com.syw.list;

/**
 * 带头节点的单链表实现
 * Java类创建，没有初始化默认引用类型为空
 * @author Administrator
 *
 */
public class SingleLinkedList {

	private HeroNode head = new HeroNode();// 创建一个空的头节点
	
	/**
	 * 使用尾插法添加节点
	 * 
	 * @param no
	 * @param name
	 * @param nickname
	 */
	/*
	 * public void add(int no,String name,String nickname) {
	 * 
	 * HeroNode tail=head; if(isNull(tail.next)) {
	 * 
	 * HeroNode node=new HeroNode(no,name,nickname); if(!isNull(node)) {
	 * tail.next=node; node.next=null; tail=node; } return; } 遍历链表，找到最后一个节点
	 * while(tail.next!=null) { tail=tail.next; } HeroNode node=new
	 * HeroNode(no,name,nickname); tail.next=node; node.next=null; tail=node; }
	 */
	
	public HeroNode getHead() {
		
		return head;
	}
	
	/**
	 *  老师的方法
	 *  Java中类的成员变量没有显示的初始化，会给予默认的初始化值
	 *  引用类型赋值为空 
	 *  int short byte long为 0
	 *  boolean：false char：'\0"
	 *  double:0.0 float:0.0f
	 * @param no
	 * @param name
	 * @param nickname
	 */
	private void add(HeroNode heroNode) {
		
		HeroNode tail=head;//头节点不动
		while(true) {//遍历链表，找到最后
			if(tail.next==null) {
				break; //找到最后一个节点，跳出循环
			}
			tail=tail.next;//没有找到指向下一个节点
		}
		//找到了最后一个节点
		tail.next=heroNode;
	}

	public void add(int no,String name,String nickname) {
		
		HeroNode heroNode=new HeroNode(no,name,nickname);
		add(heroNode);
	}
	
	/**
	 * 	按英雄的编号顺序插入链表，如果编号存在则无法插入该数据
	 * @param heroNode
	 */
	private void addByOrder(HeroNode heroNode) {
		
		HeroNode temp=head;
		boolean flag=false;//表示数据是否存在
		while(true) {
			if(isNull(temp.next)) {
				break;
			}
			if(temp.next.no > heroNode.no) {
				break;
			}else if(temp.next.no == heroNode.no) {
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag) {
			System.out.println("该英雄"+heroNode.no+"("+heroNode.name+")已经存在，无法重复插入数据...");
		}else {
			heroNode.next=temp.next;
			temp.next=heroNode;
		}
	}
	
	/**
	 * 	按照英雄的编号按顺序插入数据，如果该编号已经存在了----找到添加位置的前一个节点
	 * 	则提示无法添加到链表中
	 * @param no
	 * @param name
	 * @param nickname
	 */
	public void addByOrder(int no,String name,String nickname) {
		
		HeroNode heroNode=new HeroNode(no,name,nickname);
		addByOrder(heroNode);
	}
	
	public void print() {

		HeroNode temp = head.next;
		if(temp==null) {
			System.out.println("链表为空...");
			return;
		}
		while (!(isNull(temp))) {
			System.out.println(temp);
			temp = temp.next;// 指向下一个节点
		}
	}
	
	/**
	 * 	更新数据信息----找到当前节点
	 * @param no
	 * @param name
	 * @param nickname
	 */
	public void update(int no,String name,String nickname) {
		
		HeroNode heroNode=new HeroNode(no,name,nickname);
		boolean flag=false;//标识是否找到
		HeroNode temp=head.next; // temp 标识指向节点数据
		while(true) {
			if(isNull(temp)) {
				break;//找不到节点，或者空链表
			}
			if(temp.no == heroNode.no) {
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag) {
			temp.name=heroNode.name;
			temp.nickname=heroNode.nickname;
		}else {
			System.out.printf("找不到该英雄:%d(%s)",heroNode.no,heroNode.name);
		}
	}

	/**
	 * 	删除节点数据----找到需要删除节点的前一个节点
	 * @param no
	 */
	public void remove(int no) {
		
		HeroNode temp=head;
		boolean flag=false;//删除标识
		while(true) {
			if(isNull(temp.next)) {
				break;
			}
			if(temp.next.no == no) {
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag) {
			temp.next=temp.next.next;
		}else {
			System.out.println("找不到该英雄:");
			get(no);
		}
	}
	
	/**
	 * 	查找数据信息----找到当前节点
	 * @param no
	 */
	public void get(int no) {
		
		HeroNode temp=head.next;
		boolean flag=false;
		while(true) {
			if(isNull(temp)) {
				break;
			}
			if(temp.no==no) {
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag) {
			System.out.println(temp);
		}else {
			System.out.printf("找不到该英雄编号(%d)的数据...\n",no);
		}
	}
	
	public int size() {
		
		HeroNode temp=head.next;
		int count=0;
		while(!isNull(temp)) {
			count++;
			temp=temp.next;
		}
		return count;
	}
	
	/**
	 * 	获取链表倒数第 index个节点，从第一个有效节点开始遍历链表
	 * @param head
	 * @param index
	 * @return
	 */
	public void findLastIndexHeroNode(HeroNode head,int index) {
		
		HeroNode temp=head.next;
		int length=size();
		if(index <= 0 || index > length) {
			System.out.println("输入的下标数据有误...");
			return;
		}
		/*假设查找最后一个节点，总数为3 即遍历次数：3-1=2-----又因为下标从0开始，0,1--->推论正确*/
		for(int i=0;i<length-index;i++) {
			temp=temp.next;
		}
		System.out.println("+++++++result+++++++");
		System.out.println(temp);
	}
	
	/**
	 * 	反转单链表
	 */
	public void reverse() {
		
		HeroNode curNode=head.next;
		HeroNode newHead=new HeroNode();
		/*空链表或者只有一个节点，直接返回*/
		if(curNode.next==null || curNode.next.next==null) {
			return;
		}
		/*定义一个辅助指针帮助遍历链表*/
		HeroNode next=null;
		while(curNode!=null) {
			next=curNode.next;//保存下一个节点，不然链表会断裂
			curNode.next=newHead.next;//将新链表的后续节点给当前插入节点
			newHead.next=curNode;// 新链表头节点指向当前插入的节点
			curNode=next; //移动指针指向下一个数据
		}
		head.next=newHead.next;//新链表赋值给旧链表，完成反转
	}
	
	public static void mergeList4one(SingleLinkedList la,SingleLinkedList lb,SingleLinkedList lc) {
		
		HeroNode node_a=la.getHead().next;
		HeroNode node_b=lb.getHead().next;
		HeroNode node_c=lc.getHead();
		while(node_a!=null && node_b!=null) {
			if(node_a.no <= node_b.no) {
				node_c.next=node_a; //指向node_a节点
				node_a=node_a.next;
			}else {
				node_c.next=node_b;
				node_b=node_b.next;
			}
			node_c=node_c.next;//移动node_c指针
		}
		node_c.next=node_a==null ? node_b : node_a;
	}
	
	private boolean isNull(HeroNode node) {

		return node == null;
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
