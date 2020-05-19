package com.syw.tree;

/**
 * 	1、顺序二叉树只考虑完全二叉树 [使用数组实现]
 * 	2、第n个元素的左子节点：2*n+1
 * 	3、第n个元素的右子节点：2*n+2
 * 	4、第n个元素的父亲节点：(n-1)/2
 * 	5、[n指代的是数组的下标]
 * @author Administrator
 *
 */
public class SeqTree {

	private int[] tree;
	
	public SeqTree() {
		
		tree=new int[7];
		for(int i=0;i<7;i++) {
			tree[i]=(i+1);
		}
	}
	
	public void preOrder() {
		
		preOrder(0);
	}
	
	/**
	 * 	前序遍历
	 * @param index 数组下标
	 */
	private void preOrder(int index) {
		
		if(tree==null && tree.length==0) {
			System.out.println("数组为空，无法进行二叉树的遍历...");
			return;
		}
		System.out.print(tree[index]+" ");
		if(tree.length > 2*index+1) { //数组下标合理，左递归
			preOrder(2*index+1);		
		}
		if(tree.length > 2*index+2) {
			preOrder(2*index+2);
		}
	}
	
	public void infixOrder() {
		
		infixOrder(0);
	}
	
	public void postOrder() {
		
		postOrder(0);
	}
	
	/**
	 * 	中序遍历
	 * @param index
	 */
	private void infixOrder(int index) {
		
		if(tree==null && tree.length==0) {
			System.out.println("数组为空，无法进行二叉树的遍历...");
			return;
		}
		if(tree.length > 2*index+1) { //数组下标合理，左递归
			infixOrder(2*index+1);		
		}
		System.out.print(tree[index]+" ");
		if(tree.length > 2*index+2) {
			infixOrder(2*index+2);
		}
	}
	
	private void postOrder(int index) {
		
		if(tree==null && tree.length==0) {
			System.out.println("数组为空，无法进行二叉树的遍历...");
			return;
		}
		if(tree.length > 2*index+1) { //数组下标合理，左递归
			postOrder(2*index+1);		
		}
		if(tree.length > 2*index+2) {
			postOrder(2*index+2);
		}
		System.out.print(tree[index]+" ");
	}
}
