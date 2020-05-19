package com.wsy.leetcode_competition.t180;

import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {

	private Node root;
	private Scanner keyboard=new Scanner(System.in);
	
	public void create() {
		
		if(root==null) {
			Node node=new Node();
			root=node.createTree(node);
		}else {
			System.out.println("Error��root is null...");
		}
	}
	
	public void preOrder() {
		
		if(root!=null) {
			root.preOrder();
		}else {
			System.out.println("������Ϊ�գ��޷�����...");
		}
	}
	public void infixOrder() {
		
		if(root!=null) {
			root.infixOrder();
		}else {
			System.out.println("������Ϊ�գ��޷�����...");
		}
	}
	public void postOrder() {
		
		if(root!=null) {
			root.postOrder();
		}else {
			System.out.println("������Ϊ�գ��޷�����...");
		}
	}
	
	public void preOrderNoRecusion() {
		
		if(root!=null) {
			root.preOrderNoRecursion();
		}else {
			System.out.println("������Ϊ�գ��޷�����...");
		}
	}
	
	public void infixOrderNoRecursion() {
		
		if(root!=null) {
			root.infixOrderNoRecursion();
		}else {
			System.out.println("������Ϊ�գ��޷�����...");
		}
	}
	
	public void postOrderNoRecursion() {
		
		if(root!=null) {
			root.postOrderNoRecursion();
		}else {
			System.out.println("������Ϊ�գ��޷�����...");
		}
	}
	
	private class Node {
		
		private char no;
		private Node left; //��ڵ�
		private Node right;//�ҽڵ�
		
		public Node(char no) {
			this.no = no;
		}
		
		public Node() {

		}

		/**
		 * 	ǰ�򴴽�������
		 * @param node
		 * @return
		 */
		public Node createTree(Node node) {
			
			char data=keyboard.next().charAt(0);
			if(data=='#') {
				return null; // #�Ŵ���սڵ�
			}else {
				node=new Node(data);
				//��ݹ�
				node.left=createTree(node.left);
				//�ҵݹ� 
				node.right=createTree(node.right);
				return node;
			}
		}
		
		/*�ݹ����*/
		public void preOrder() {
			
			System.out.println(this);
			if(this.left!=null) {
				this.left.preOrder();
			}
			if(this.right!=null) {
				this.right.preOrder();
			}
		}
		
		public void infixOrder() {
			
			if(this.left!=null) {
				this.left.infixOrder();
			}
			System.out.println(this);
			if(this.right!=null) {
				this.right.infixOrder();
			}
		}
		
		public void postOrder() {
			
			if(this.left!=null) {
				this.left.postOrder();
			}
			if(this.right!=null) {
				this.right.postOrder();
			}
			System.out.println(this);
		}

		/**
		 * 		  a
		 *     b     c
		 *   d  e  f
		 */
		/*�ǵݹ����*/
		public void preOrderNoRecursion() {
			
			Node temp=this;
			Stack<Node> stack=new Stack<>();
			while(temp!=null || !stack.empty()) {
				while(temp!=null) {
					System.out.println(temp);
					stack.push(temp);//��ǰ�Ѿ���ӡ���Ľڵ���ջ
					temp=temp.left;//����������Ѱ
				}
				if(!stack.isEmpty()) {
					temp=stack.pop();
					temp=temp.right;
				}
			}
		}
		
		public void infixOrderNoRecursion() {
			
			Node temp=this;
			Stack<Node> stack=new Stack<>();
			while(temp!=null || !stack.empty()) {
				while(temp!=null) {
					stack.push(temp);//��ǰ�ڵ���ջ
					temp=temp.left;//����������Ѱֱ������ߵ�һ���ڵ�
				}
				if(!stack.isEmpty()) {
					temp=stack.pop();
					System.out.println(temp);
					temp=temp.right;
				}
			}
		}
		
		/**
		 * 	����ǵݹ����--->ʹ��˫ջ��
		 */
		public void postOrderNoRecursion() {
			
			Stack<Node> s1=new Stack<>();
			Stack<Node> s2=new Stack<>(); //s2ջ�����ڴ�ӡ���
			s1.push(this);//��root
			Node node;
			while(!s1.isEmpty()) {
				node=s1.pop();
				s2.push(node);
				if(node.left!=null) {
					s1.push(node.left);
				}
				if(node.right!=null) {
					s1.push(node.right);
				}
			}
			while(!s2.isEmpty()) {
				System.out.println(s2.pop());
			}
		}
		
		@Override
		public String toString() {
			return "Node [no=" + no + "]";
		}
	}
}
