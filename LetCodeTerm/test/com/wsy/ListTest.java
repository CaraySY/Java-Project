package com.wsy;

import org.junit.Test;

import com.wsy.list.ReverseSingleList;

public class ListTest {

	/**
	 * 	合并有序链表
	 */
	@Test
	public void fun1(){
		
		ReverseSingleList list=new ReverseSingleList();
		ReverseSingleList list2=new ReverseSingleList();
		ReverseSingleList list3=new ReverseSingleList();
		list.addNode(1);
		list.addNode(2);
		list.addNode(4);
		list.print();
		list2.addNode(1);
		list2.addNode(3);
		list2.addNode(4);
		list2.print();
		//list.reverse();
		//list.reverse2();
		//list.reverse3();
		list3=ReverseSingleList.mergeList(list, list2);
		list3.print();
	}
	
	/**
	 * 	两个链表相加
	 */
	@Test
	public void fun2() {
		
		ReverseSingleList list=new ReverseSingleList();
		ReverseSingleList list2=new ReverseSingleList();
		ReverseSingleList test=new ReverseSingleList();
		list.addNode(1);
		list.addNode(8);
		list2.addNode(1);
		list.print();
		list2.print();
		ReverseSingleList lc=test.twoListAdd(list, list2);
		lc.print();
	}
	
	/**
	 * 	删除倒数第N个节点
	 */
	@Test
	public void fun3() {
		
		ReverseSingleList list=new ReverseSingleList();
		list.addNode(1);
		list.print();
		list.removeNthFromEnd(2);
		list.print();
	}
}
