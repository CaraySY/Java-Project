package com.wsy.list;

/**
 *  反转一个无头结点的单链表
 * @author Administrator
 *
 */
public class ReverseSingleList {

	private Node head;
	
	public Node getRoot() {
		
		return head;
	}
	
	/**
	 * 	删除倒数第N个节点
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
		// i<size-n找到待删除的节点， size-n-1找到前一个节点
		while(i < size-n-1) {
			cur=cur.next;
			i++;
		}
		if(cur.next!=null) {
			cur.next=cur.next.next;
		}
	}
	
	// 无头节点
	public void addNode(int data) {
		
		Node temp=head;
		Node node=new Node(data);
		if(head==null) {
			head=node;
			return;
		}
		//循环找到最后一个顶点
		while(true) {
			if(temp.next==null) {
				break;
			}
			temp=temp.next;
		}
		//最后一个节点指向新结点
		temp.next=node;
		//temp=node;
	}
	
	/**
	 * 	自己写的，创建一个新的链表--->内存消耗严重
	 */
	public void reverse() {
		
		Node newHead=new Node();
		Node curNode=head;
		Node node;
		while(curNode!=null) {
			node=new Node(curNode.val); //创建新的节点
			node.next=newHead;
			newHead=node;
			curNode=curNode.next;
		}
		//反向输出链表
		curNode=newHead;
		while(curNode.next!=null) {
			System.out.print(curNode.val+"->");
			curNode=curNode.next;
		}
		System.out.println("NULL");
	}
	
	/**
	 * 	迭代法，改变指针方向
	 * 	在遍历列表时，将当前节点的 next 指针改为指向前一个元素
	 *  用prev保存前一个节点，next保存下一个节点
	 * @return
	 */
	public void reverse2() {
		
		Node cur=head,next=null,prev = null;
		while(cur!=null) {
			next=cur.next; //保存next节点
			cur.next=prev; //将当前节点指向 prev指针
			prev=cur; // 将cur复值到prev
			cur=next; //cur移动到下一个节点
		}
		cur=prev;
		while(cur!=null) {
			System.out.print(cur.val+"->");
			cur=cur.next;
		}
		System.out.println("NULL");
	}
	
	/**
	 * 	使用递归法
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
		l3.addNode(-1); //带了头节点
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
