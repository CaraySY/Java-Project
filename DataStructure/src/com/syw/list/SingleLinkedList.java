package com.syw.list;

/**
 * ��ͷ�ڵ�ĵ�����ʵ��
 * Java�ഴ����û�г�ʼ��Ĭ����������Ϊ��
 * @author Administrator
 *
 */
public class SingleLinkedList {

	private HeroNode head = new HeroNode();// ����һ���յ�ͷ�ڵ�
	
	/**
	 * ʹ��β�巨��ӽڵ�
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
	 * tail.next=node; node.next=null; tail=node; } return; } ���������ҵ����һ���ڵ�
	 * while(tail.next!=null) { tail=tail.next; } HeroNode node=new
	 * HeroNode(no,name,nickname); tail.next=node; node.next=null; tail=node; }
	 */
	
	public HeroNode getHead() {
		
		return head;
	}
	
	/**
	 *  ��ʦ�ķ���
	 *  Java����ĳ�Ա����û����ʾ�ĳ�ʼ���������Ĭ�ϵĳ�ʼ��ֵ
	 *  �������͸�ֵΪ�� 
	 *  int short byte longΪ 0
	 *  boolean��false char��'\0"
	 *  double:0.0 float:0.0f
	 * @param no
	 * @param name
	 * @param nickname
	 */
	private void add(HeroNode heroNode) {
		
		HeroNode tail=head;//ͷ�ڵ㲻��
		while(true) {//���������ҵ����
			if(tail.next==null) {
				break; //�ҵ����һ���ڵ㣬����ѭ��
			}
			tail=tail.next;//û���ҵ�ָ����һ���ڵ�
		}
		//�ҵ������һ���ڵ�
		tail.next=heroNode;
	}

	public void add(int no,String name,String nickname) {
		
		HeroNode heroNode=new HeroNode(no,name,nickname);
		add(heroNode);
	}
	
	/**
	 * 	��Ӣ�۵ı��˳��������������Ŵ������޷����������
	 * @param heroNode
	 */
	private void addByOrder(HeroNode heroNode) {
		
		HeroNode temp=head;
		boolean flag=false;//��ʾ�����Ƿ����
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
			System.out.println("��Ӣ��"+heroNode.no+"("+heroNode.name+")�Ѿ����ڣ��޷��ظ���������...");
		}else {
			heroNode.next=temp.next;
			temp.next=heroNode;
		}
	}
	
	/**
	 * 	����Ӣ�۵ı�Ű�˳��������ݣ�����ñ���Ѿ�������----�ҵ����λ�õ�ǰһ���ڵ�
	 * 	����ʾ�޷���ӵ�������
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
			System.out.println("����Ϊ��...");
			return;
		}
		while (!(isNull(temp))) {
			System.out.println(temp);
			temp = temp.next;// ָ����һ���ڵ�
		}
	}
	
	/**
	 * 	����������Ϣ----�ҵ���ǰ�ڵ�
	 * @param no
	 * @param name
	 * @param nickname
	 */
	public void update(int no,String name,String nickname) {
		
		HeroNode heroNode=new HeroNode(no,name,nickname);
		boolean flag=false;//��ʶ�Ƿ��ҵ�
		HeroNode temp=head.next; // temp ��ʶָ��ڵ�����
		while(true) {
			if(isNull(temp)) {
				break;//�Ҳ����ڵ㣬���߿�����
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
			System.out.printf("�Ҳ�����Ӣ��:%d(%s)",heroNode.no,heroNode.name);
		}
	}

	/**
	 * 	ɾ���ڵ�����----�ҵ���Ҫɾ���ڵ��ǰһ���ڵ�
	 * @param no
	 */
	public void remove(int no) {
		
		HeroNode temp=head;
		boolean flag=false;//ɾ����ʶ
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
			System.out.println("�Ҳ�����Ӣ��:");
			get(no);
		}
	}
	
	/**
	 * 	����������Ϣ----�ҵ���ǰ�ڵ�
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
			System.out.printf("�Ҳ�����Ӣ�۱��(%d)������...\n",no);
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
	 * 	��ȡ�������� index���ڵ㣬�ӵ�һ����Ч�ڵ㿪ʼ��������
	 * @param head
	 * @param index
	 * @return
	 */
	public void findLastIndexHeroNode(HeroNode head,int index) {
		
		HeroNode temp=head.next;
		int length=size();
		if(index <= 0 || index > length) {
			System.out.println("������±���������...");
			return;
		}
		/*����������һ���ڵ㣬����Ϊ3 ������������3-1=2-----����Ϊ�±��0��ʼ��0,1--->������ȷ*/
		for(int i=0;i<length-index;i++) {
			temp=temp.next;
		}
		System.out.println("+++++++result+++++++");
		System.out.println(temp);
	}
	
	/**
	 * 	��ת������
	 */
	public void reverse() {
		
		HeroNode curNode=head.next;
		HeroNode newHead=new HeroNode();
		/*���������ֻ��һ���ڵ㣬ֱ�ӷ���*/
		if(curNode.next==null || curNode.next.next==null) {
			return;
		}
		/*����һ������ָ�������������*/
		HeroNode next=null;
		while(curNode!=null) {
			next=curNode.next;//������һ���ڵ㣬��Ȼ��������
			curNode.next=newHead.next;//��������ĺ����ڵ����ǰ����ڵ�
			newHead.next=curNode;// ������ͷ�ڵ�ָ��ǰ����Ľڵ�
			curNode=next; //�ƶ�ָ��ָ����һ������
		}
		head.next=newHead.next;//������ֵ����������ɷ�ת
	}
	
	public static void mergeList4one(SingleLinkedList la,SingleLinkedList lb,SingleLinkedList lc) {
		
		HeroNode node_a=la.getHead().next;
		HeroNode node_b=lb.getHead().next;
		HeroNode node_c=lc.getHead();
		while(node_a!=null && node_b!=null) {
			if(node_a.no <= node_b.no) {
				node_c.next=node_a; //ָ��node_a�ڵ�
				node_a=node_a.next;
			}else {
				node_c.next=node_b;
				node_b=node_b.next;
			}
			node_c=node_c.next;//�ƶ�node_cָ��
		}
		node_c.next=node_a==null ? node_b : node_a;
	}
	
	private boolean isNull(HeroNode node) {

		return node == null;
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
