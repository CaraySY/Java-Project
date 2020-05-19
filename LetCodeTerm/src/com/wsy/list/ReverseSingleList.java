package com.wsy.list;

/**
 *  ��תһ����ͷ���ĵ�����
 * @author Administrator
 *
 */
public class ReverseSingleList {

	private Node head;
	
	public Node getRoot() {
		
		return head;
	}
	
	/**
	 * 	ɾ��������N���ڵ�
	 */
	public void removeNthFromEnd(int n) {
		
		int i=0;
		Node cur=head;
		int size=0;
		while(cur!=null) {
			size++;
			cur=cur.next;
		}
		if(n==size) {
			head=head.next;
			return;
		}
		cur=head;
		// i<size-n�ҵ���ɾ���Ľڵ㣬 size-n-1�ҵ�ǰһ���ڵ�
		while(i < size-n-1) {
			cur=cur.next;
			i++;
		}
		if(cur.next!=null) {
			cur.next=cur.next.next;
		}
	}
	
	// ��ͷ�ڵ�
	public void addNode(int data) {
		
		Node temp=head;
		Node node=new Node(data);
		if(head==null) {
			head=node;
			return;
		}
		//ѭ���ҵ����һ������
		while(true) {
			if(temp.next==null) {
				break;
			}
			temp=temp.next;
		}
		//���һ���ڵ�ָ���½��
		temp.next=node;
		//temp=node;
	}
	
	/**
	 * 	�Լ�д�ģ�����һ���µ�����--->�ڴ���������
	 */
	public void reverse() {
		
		Node newHead=new Node();
		Node curNode=head;
		Node node;
		while(curNode!=null) {
			node=new Node(curNode.val); //�����µĽڵ�
			node.next=newHead;
			newHead=node;
			curNode=curNode.next;
		}
		//�����������
		curNode=newHead;
		while(curNode.next!=null) {
			System.out.print(curNode.val+"->");
			curNode=curNode.next;
		}
		System.out.println("NULL");
	}
	
	/**
	 * 	���������ı�ָ�뷽��
	 * 	�ڱ����б�ʱ������ǰ�ڵ�� next ָ���Ϊָ��ǰһ��Ԫ��
	 *  ��prev����ǰһ���ڵ㣬next������һ���ڵ�
	 * @return
	 */
	public void reverse2() {
		
		Node cur=head,next=null,prev = null;
		while(cur!=null) {
			next=cur.next; //����next�ڵ�
			cur.next=prev; //����ǰ�ڵ�ָ�� prevָ��
			prev=cur; // ��cur��ֵ��prev
			cur=next; //cur�ƶ�����һ���ڵ�
		}
		cur=prev;
		while(cur!=null) {
			System.out.print(cur.val+"->");
			cur=cur.next;
		}
		System.out.println("NULL");
	}
	
	/**
	 * 	ʹ�õݹ鷨
	 */
	private Node reverse3(Node head) {
		
		if(head==null || head.next==null) return head;
		Node p=reverse3(head.next);
		head.next.next=head;
		head.next=null;
		return p;
	}
	
	public void reverse3() {
		
		Node cur = reverse3(head);
		while(cur!=null) {
			System.out.print(cur.val+"->");
			cur=cur.next;
		}
		System.out.println("NULL");
		
	}
	
	public void print() {
		
		Node curNode=head;
		while(curNode!=null) {
			System.out.print(curNode.val+"->");
			curNode=curNode.next;
		}
		System.out.println("NULL");
	}
	
	public static ReverseSingleList mergeList(ReverseSingleList l1,ReverseSingleList l2) {
		
		Node la=l1.getRoot();
		Node lb=l2.getRoot();
		ReverseSingleList l3=new ReverseSingleList();
		l3.addNode(-1); //����ͷ�ڵ�
		Node lc=l3.getRoot();
		while(la!=null && lb!=null) {
			if(la.val <= lb.val) {
				lc.next=la;
				la=la.next;
			}else {
				lc.next=lb;
				lb=lb.next;
			}
			lc=lc.next;
		}
		lc.next=la==null ? lb : la;
		return l3;
	}
	
	public ReverseSingleList twoListAdd(ReverseSingleList l1,ReverseSingleList l2) {
		
		Node la=l1.getRoot();
		Node lb=l2.getRoot();
		ReverseSingleList l3=new ReverseSingleList();
		l3.addNode(0);
		Node lc=l3.getRoot();
		while(la!=null || lb!=null) {
			
			if(lb.next!=null) {
				lb=lb.next;
			}
			if(lc.next!=null) {
				la=la.next;
			}
		}
		return l3;
	}
	
	private class Node{
		
		private int val;
		private Node next;
		
		public Node() {
			
			
		}
		
		public Node(int val) {
			
			this.val=val;
		}
		
		@Override
		public String toString() {
			return "Node [val=" + val + "]";
		}
		
		
	}
}
