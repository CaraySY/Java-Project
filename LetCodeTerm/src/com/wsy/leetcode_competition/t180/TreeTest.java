package com.wsy.leetcode_competition.t180;

public class TreeTest {

	public static void main(String[] args) {
		
		BinaryTree tree=new BinaryTree();
		//a b d # # e # # c f # # #
		tree.create(); //ʹ�� ǰ��ݹ鴴��������
		System.out.println("ǰ�����...");
		tree.preOrder();
		System.out.println("�������...");
		tree.infixOrder();
		System.out.println("�������...");
		tree.postOrder();
		//�ǵݹ����
		System.out.println("�ǵݹ�ǰ�����...");
		tree.preOrderNoRecusion();
		System.out.println("�ǵݹ��������...");
		tree.infixOrderNoRecursion();
		System.out.println("�ǵݹ�������...");
		tree.postOrderNoRecursion();
	}
}
