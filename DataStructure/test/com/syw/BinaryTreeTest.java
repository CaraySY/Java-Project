package com.syw;

import java.util.Arrays;

import org.junit.Test;

import com.syw.tree.BinaryTree;
import com.syw.tree.HeapSort;
import com.syw.tree.SeqTree;
import com.syw.tree.ThreadedBinaryTree;

public class BinaryTreeTest {

	/**
	 * 	�������ı���
	 */
	@Test
	public void fun1() {
		
		BinaryTree tree=new BinaryTree();
		tree.init();
		System.out.println("ǰ�����:");
		tree.preOrder();
		System.out.println("�������:");
		tree.infixOrder();
		System.out.println("�������:");
		tree.postOrder();
		System.out.println("ǰ���ѯ...");
		tree.preSearch(1);
		System.out.println("�����ѯ...");
		tree.infixSearch(3);
		System.out.println("�����ѯ...");
		tree.postSearch(3);
	}
	
	@Test
	public void fun2() {
		
		BinaryTree tree=new BinaryTree();
		tree.init();
		System.out.println("ɾ��ǰ-->ǰ�����:");
		tree.preOrder();
		tree.delNode(5);
		System.out.println("ɾ����-->ǰ�����:");
		tree.preOrder();
	}
	
	/*
	 *   	1
	 * 	  2    3
	 *  4   5 6  7	
	 */
	//˳�������
	@Test
	public void fun3() {
		
		SeqTree tree=new SeqTree();
		System.out.println("ǰ�����:");
		tree.preOrder();
		System.out.println("\n�������:");
		tree.infixOrder();
		System.out.println("\n�������:");
		tree.postOrder();
	}
	
	/**
	 * 	����������������
	 * 
	 * /*
	 *     1
	 *  3      6
	 *8   10 14  
	 * 
	 * �������-->8 3 10 1 14 6
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
	 * ǰ�����-->1 3 8 10 6 14
	 *
	 * 	ǰ��������������
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
	 * �������-->8 10 3 14 6 1
	 *
	 * 	����������������
	 */
	@Test
	public void fun6() {
		
		ThreadedBinaryTree tree=new ThreadedBinaryTree();
		tree.init();
		tree.threadedTreeByPost();
		tree.printThreadedTreeByPost();
	}
	
	/**
	 * 	˳�������ʵ�ֶ�����
	 */
	@Test
	public void fun7() {
		
		int[] array= {4,3,2,10,12,1,5,6};
		HeapSort sort=new HeapSort();
		sort.heapSort(array);
		System.out.println("��������飺"+Arrays.toString(array));
	}
	/**
	 * 			*   n=7  5/2-1=1
	 *        *   *
	 *      * *    
	 */
}
