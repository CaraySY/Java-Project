package com.syw;

import java.util.Arrays;

import org.junit.Test;

import com.syw.tree.BinaryTree;
import com.syw.tree.HeapSort;
import com.syw.tree.SeqTree;
import com.syw.tree.ThreadedBinaryTree;

public class BinaryTreeTest {

	/**
	 * 	二叉树的遍历
	 */
	@Test
	public void fun1() {
		
		BinaryTree tree=new BinaryTree();
		tree.init();
		System.out.println("前序遍历:");
		tree.preOrder();
		System.out.println("中序遍历:");
		tree.infixOrder();
		System.out.println("后序遍历:");
		tree.postOrder();
		System.out.println("前序查询...");
		tree.preSearch(1);
		System.out.println("中序查询...");
		tree.infixSearch(3);
		System.out.println("后序查询...");
		tree.postSearch(3);
	}
	
	@Test
	public void fun2() {
		
		BinaryTree tree=new BinaryTree();
		tree.init();
		System.out.println("删除前-->前序遍历:");
		tree.preOrder();
		tree.delNode(5);
		System.out.println("删除后-->前序遍历:");
		tree.preOrder();
	}
	
	/*
	 *   	1
	 * 	  2    3
	 *  4   5 6  7	
	 */
	//顺序二叉树
	@Test
	public void fun3() {
		
		SeqTree tree=new SeqTree();
		System.out.println("前序遍历:");
		tree.preOrder();
		System.out.println("\n中序遍历:");
		tree.infixOrder();
		System.out.println("\n后序遍历:");
		tree.postOrder();
	}
	
	/**
	 * 	中序线索化二叉树
	 * 
	 * /*
	 *     1
	 *  3      6
	 *8   10 14  
	 * 
	 * 中序遍历-->8 3 10 1 14 6
	 */
	@Test
	public void fun4() {
		
		ThreadedBinaryTree tree=new ThreadedBinaryTree();
		tree.init();
		tree.threadedTreeByInfix();
		tree.printThreadedBinaryTree();
	}
	/**
	 * 
	 * 
	 *     1
	 *  3      6
	 *8   10 14  
	 * 
	 * 前序遍历-->1 3 8 10 6 14
	 *
	 * 	前序线索化二叉树
	 */
	@Test
	public void fun5() {
		
		ThreadedBinaryTree tree=new ThreadedBinaryTree();
		tree.init();
		tree.threadedTreeByPre();
		tree.printThreadedTreeByPre();
	}
	/**
	 * 
	 * 
	 *     1
	 *  3      6
	 *8   10 14  
	 * 
	 * 后序遍历-->8 10 3 14 6 1
	 *
	 * 	后序线索化二叉树
	 */
	@Test
	public void fun6() {
		
		ThreadedBinaryTree tree=new ThreadedBinaryTree();
		tree.init();
		tree.threadedTreeByPost();
		tree.printThreadedTreeByPost();
	}
	
	/**
	 * 	顺序二叉树实现堆排序
	 */
	@Test
	public void fun7() {
		
		int[] array= {4,3,2,10,12,1,5,6};
		HeapSort sort=new HeapSort();
		sort.heapSort(array);
		System.out.println("排序后数组："+Arrays.toString(array));
	}
	/**
	 * 			*   n=7  5/2-1=1
	 *        *   *
	 *      * *    
	 */
}
