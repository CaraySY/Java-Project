package com.wsy.leetcode_competition.t180;

public class TreeTest {

	public static void main(String[] args) {
		
		BinaryTree tree=new BinaryTree();
		//a b d # # e # # c f # # #
		tree.create(); //使用 前序递归创建二叉树
		System.out.println("前序遍历...");
		tree.preOrder();
		System.out.println("中序遍历...");
		tree.infixOrder();
		System.out.println("后序遍历...");
		tree.postOrder();
		//非递归遍历
		System.out.println("非递归前序遍历...");
		tree.preOrderNoRecusion();
		System.out.println("非递归中序遍历...");
		tree.infixOrderNoRecursion();
		System.out.println("非递归后序遍历...");
		tree.postOrderNoRecursion();
	}
}
