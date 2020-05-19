package com.syw;

import org.junit.Test;

import com.syw.binary_sort_tree.BinarySortTree;

/**
 * 	        7
 *       3    10
 *     1  5  9  12
 *      2 
 * @author Administrator
 *
 */
public class BSTreeTest {

	@Test
	public void fun1() {

		int[] array= {7,3,10,12,5,1,9,2};
		BinarySortTree tree=new BinarySortTree();
		for(int i=0;i<array.length;i++) {
			tree.add(array[i]);
		}
		System.out.println("É¾³ýÇ°£º");
		tree.infixOrder();
		System.out.println("É¾³ýºó£º");
		tree.delNode(2);
		tree.delNode(5);
		tree.delNode(9);
		tree.delNode(12);
		tree.delNode(7);
		tree.delNode(3);
		tree.delNode(10);
		tree.delNode(1);
		tree.infixOrder();
		System.out.println("root="+tree.getRoot());
	}
}
