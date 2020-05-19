package com.syw.tree;

import java.util.Stack;

/**
 * 	����ThreadBinaryTree ʵ�������������ܵĶ�����
 * ��ҵ��������������ǰ�򡢺�����Ҫ���
 * @author Administrator
 *
 */
public class ThreadedBinaryTree {

	private HeroNode root=new HeroNode(1, "Tom");
	
	//Ϊ��ʡ��������������Ҫ����һ��ָ��ǰ�ڵ㵽���ǰ���ڵ�
	//��Ϊ�������Ĳ�ѯ�ǵ���ģ���Ҫ����ǰһ���ڵ����Ϣ����ʵ��������
	private HeroNode prev;
	
	// �ֶ�����������
	
	HeroNode node2 = new HeroNode(3, "Jackey");
	HeroNode node3 = new HeroNode(6, "Smith");
	HeroNode node4 = new HeroNode(8, "Mary");
	HeroNode node5 = new HeroNode(10, "King");
	HeroNode node6 = new HeroNode(14, "Dim");
	
	public void init() {
		//�ֶ�����������
		root.left=node2;
		root.right=node3;
		node2.left=node4;
		node2.right=node5;
		node3.left=node6;
	}
	
	public void test() {
		System.out.println("10��ǰ���ڵ���"+node5.left);
		System.out.println("10�ź�̽ڵ���"+node5.right);
	}
	
	public void threadedTreeByInfix() {
		
		if(root==null) {
			System.out.println("������Ϊ��...");
			return;
		}
		threadedTreeByInfix(root);
	}
	
	public void threadedTreeByPre() {
		
		if(root==null) {
			System.out.println("������Ϊ��...");
			return;
		}
		threadedTreeByPre(root);
	}
	
	public void threadedTreeByPost() {
		
		if(root==null) {
			System.out.println("������Ϊ��...");
			return;
		}
		threadedTreeByPost(root);
	}
	
	public void printThreadedTreeByPost() {
		
		if(root==null) {
			System.out.println("������Ϊ��...");
			return;
		}
		printThreadedTreeByPost(root);
	}
	
	/**
	 * 	�����������������Ϊ����ȫ����������Ҫ������ڵ㡣��������ѭ������
	 * @param node
	 */
	private void printThreadedTreeByPost(HeroNode node) {

		Stack<HeroNode> stack=new Stack<HeroNode>();
		stack.push(node.right);
		while(node!=null) {
			
			if(stack.size() >0 ) {
				while(node.leftType==0) {
					node=node.left;
				}
				System.out.println(node);
				node=node.right;
				while(node!=null && node.rightType==1) {
					System.out.println(node);
					node=node.right;
				}
				System.out.println(node);
				node=stack.pop();
			}
		}
	}

	public void printThreadedTreeByPre() {
		
		if(root==null) {
			System.out.println("������Ϊ��...");
			return;
		}
		printThreadedTreeByPre(root);
	}
	
	/**
	 * 	ǰ�����������������
	 * @param node
	 */
	private void printThreadedTreeByPre(HeroNode node) {
		
		while(node!=null) {
			System.out.println(node); //ֱ�������ǰ�ڵ�
			while(node.leftType==0) { //ֱ��������Ѱ����һ����ָ��ǰ���ڵ�ĵ�ǰ�ڵ�
				node=node.left;
				System.out.println(node);
			}
			//�л�����ָ��
			node=node.right;
			while(node!=null && node.rightType==1) { //ѭ�������ָ���̽ڵ�ĵ�ǰ�ڵ�
				System.out.println(node);
				node=node.right;
			}
		}
	}
	
	/**
	 * 	ʹ������������������
	 * @param node
	 */
	private void threadedTreeByPre(HeroNode node) {
		
		if(node==null) {
			return;
		}
		/*����ǰ�ڵ�������*/
		if(node.left==null) {
			node.left=prev;//ָ��ǰ���ڵ�
			node.leftType=1;
		}
		/*��ǰ�ڵ�ĺ��ָ��Ӧ������һ���ڵ�ָ��ǰ�ڵ� [��һ���ڵ㲻Ϊ��]*/
		if(prev!=null && prev.right==null) {
			prev.right=node;
			prev.rightType=1;
		}
		prev=node; //��ǰ�ڵ�����Ϊǰ���ڵ�
		if(node.leftType==0) { //�жϵ�ǰ�ڵ��Ƿ������ӽڵ�
			threadedTreeByPre(node.left); 
		}
		if(node.rightType==0) { //�жϵ�ǰ�ڵ��Ƿ������ӽڵ�
			threadedTreeByPre(node.right); 
		}
	} 
	
	/**
	 * 	���������������� [����������]
	 * @param node ��Ҫ�������Ľڵ�
	 */
	private void threadedTreeByInfix(HeroNode node) {
		
		if(node==null) { //��ǰ�ڵ�Ϊ�ղ���Ҫ������
			return;
		}
		
		/*����ǰָ���������*/
		if(node.left==null) {
			node.left=prev; //�õ�ǰ�ڵ����ָ��ָ��ǰ���ڵ�
			node.leftType=1;//�޸�ָ������ 1 ǰ����� 0  ������
		}
		
		/*���ڶ������ǵ���ݹ飬��Ҫ��ǰ�ڵ�ĺ��ָ��ǰ�ڵ�ʵ�ֵ�ǰ�ڵ��������*/
		if(prev!=null && prev.right==null) { //��֤ǰ���ڵ㲻Ϊ���������ӽڵ�Ϊ�գ�����ָ��node
			//ǰ���ڵ����ָ��ָ��ǰ�ڵ�
			prev.right=node;
			prev.rightType=1;  //�޸�ָ������ 1 ��̽�� 0  ������
		}
		//!!! ÿ�δ���һ���ڵ���õ�ǰ�ڵ�����һ���ڵ��ǰ���ڵ�
		prev=node;
		//��ǰ�ڵ����ָ��ݹ����������
		if(node.leftType==0) {
			threadedTreeByInfix(node.left);
		}
		if(node.rightType==0) {
			threadedTreeByInfix(node.right);
		}
	}
	
	private void threadedTreeByPost(HeroNode node) {
		
		if(node==null) {
			return;//�ݹ��˳�����
		}
		if(node.leftType==0) {//��ݹ�
			threadedTreeByPost(node.left);
		}
		if(node.rightType==0) {
			threadedTreeByPost(node.right);
		}
		/*����ǰָ���������*/
		if(node.left==null) {
			node.left=prev; //�õ�ǰ�ڵ����ָ��ָ��ǰ���ڵ�
			node.leftType=1;//�޸�ָ������ 1 ǰ����� 0  ������
		}
		
		/*���ڶ������ǵ���ݹ飬��Ҫ��ǰ�ڵ�ĺ��ָ��ǰ�ڵ�ʵ�ֵ�ǰ�ڵ��������*/
		if(prev!=null && prev.right==null) { //��֤ǰ���ڵ㲻Ϊ���������ӽڵ�Ϊ�գ�����ָ��node
			//ǰ���ڵ����ָ��ָ��ǰ�ڵ�
			prev.right=node;
			prev.rightType=1;  //�޸�ָ������ 1 ��̽�� 0  ������
		}
		//!!! ÿ�δ���һ���ڵ���õ�ǰ�ڵ�����һ���ڵ��ǰ���ڵ�
		prev=node;
	}
	
	/**
	 * 	��Root���ڵ��������������
	 */
	public void printThreadedBinaryTree() {
		
		HeroNode node=root;//����ָ��������Ǳ�������������
		while(node!=null) { //��ǰ�ڵ㲻Ϊ�գ�ѭ�����
			while(node.leftType==0) { //ѭ���ҵ���һ���к�̽ڵ��ָ��
				//��leftType=1��˵���ýڵ��ǰ�����������
				node=node.left; 
			}
			//ֱ�������һ�к�̽ڵ�ָ���ֵ
			System.out.println(node);
			while(node.rightType==1){ //��ǰ�ڵ����ָ��ָ��ǰ���ڵ㣬һֱ���
				node=node.right;
				System.out.println(node);
			}
			node=node.right;//�л��ڵ�����
		}
	}
	
	
	/**
	 * 	�������������� node�ڵ��
	 * 			���ӽڵ����ָ��������������ǰ���ڵ�
	 * 			���ӽڵ����ָ�������������Ǻ�̽ڵ�
	 * @author Administrator
	 *
	 */
	private class HeroNode {

		private int no;
		private String name;
		private HeroNode left; //���ӽڵ�
		private HeroNode right; //���ӽڵ�
		
		// leftType=0-->ָ��������
		// leftType=1-->ָ��ǰ���ڵ�
		private int leftType;
		// rightType=0-->ָ��������
		// rightType=1-->ָ���̽ڵ�
		private int rightType;

		public HeroNode(int no, String name) {

			this.no = no;
			this.name = name;
		}

		@Override
		public String toString() {
			return "HeroNode [no=" + no + ", name=" + name + "]";
		}
	}
}
