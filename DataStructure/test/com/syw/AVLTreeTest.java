package com.syw;

import org.junit.Test;

import com.syw.avl.AVLTree;

public class AVLTreeTest {

	/**
	 * 	AVL��������ת
	 */
	@Test
	public void fun1() {
		
		int[] array= {4,3,6,5,7,8};
		AVLTree tree=new AVLTree();
		for(int i=0;i<array.length;i++) {
			tree.add(array[i]);
		}
		tree.infixOrder();
		System.out.println("���ĸ߶ȣ�"+tree.getRootHeigh());
		System.out.println("�������ĸ߶ȣ�"+tree.getLeftHeight());
		System.out.println("�������ĸ߶ȣ�"+tree.getRightHeight());
		
	}
	
	/**
	 * 	AVL������ת
	 */
	@Test
	public void fun2() {
		
		int[] array= {10,12,8,9,7,6};
		AVLTree tree=new AVLTree();
		for(int i=0;i<array.length;i++) {
			tree.add(array[i]);
		}
		tree.infixOrder();
		System.out.println("���ĸ߶ȣ�"+tree.getRootHeigh());
		System.out.println("�������ĸ߶ȣ�"+tree.getLeftHeight());
		System.out.println("�������ĸ߶ȣ�"+tree.getRightHeight());
		
	}
	
	@Test
	public void fun3() {
		
		int[] array= {10,11,7,6,8,9};
		AVLTree tree=new AVLTree();
		for(int i=0;i<array.length;i++) {
			tree.add(array[i]);
		}
		tree.infixOrder();
		System.out.println("���ĸ߶ȣ�"+tree.getRootHeigh());
		System.out.println("�������ĸ߶ȣ�"+tree.getLeftHeight());
		System.out.println("�������ĸ߶ȣ�"+tree.getRightHeight());
		System.out.println("���ڵ㣺"+tree.getRoot());
		
	}
}
