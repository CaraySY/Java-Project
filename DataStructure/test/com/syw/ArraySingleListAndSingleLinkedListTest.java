package com.syw;

import org.junit.Test;

import com.syw.list.SingleLinkedList;
import com.syw.queue.ArrayQueue;
import com.syw.queue.CircleArrayQueue;

public class ArraySingleListAndSingleLinkedListTest {

	/**
	 * 	@author Administrator
	 * 	测试数组队列
	 */
	@Test
	public void fun1() {
		
		ArrayQueue queue=new ArrayQueue(5);
		for(int i=0;i<3;i++) {
			queue.addQueue(i*i);
		}
		queue.printQueue();
		System.out.println("出队列...");
		queue.getQueue();
		queue.getQueue();
		queue.printQueue();
		System.out.println("进队列...");
		queue.addQueue(6*6);
		queue.addQueue(7*7);
		queue.printQueue();
	}
	
	/**
	 * 	@author Administrator
	 * 	测试数组的循环队列
	 */
	@Test
	public void fun2() {
		
		CircleArrayQueue queue=new CircleArrayQueue(4);//只能存三个
		for(int i=1;i<4;i++) {
			queue.addQueue(i*i);
		}
		queue.printQueue();
		queue.addQueue(4*4);
		queue.getQueue();
		queue.getQueue();
		queue.printQueue();
		System.out.println("***************");
		queue.addQueue(5*5);
		queue.addQueue(6*6);
		queue.printQueue();
		queue.addQueue(34);
	}
	
	/**
	 * 	测试单链表插入、遍历
	 */
	@Test
	public void fun3() {
		
		SingleLinkedList list=new SingleLinkedList();
		list.add(0, "宋江", "及时雨");
		list.add(1, "吴用", "智多星");
		list.add(2, "花荣", "小李广");
		list.add(3, "卢俊义", "玉麒麟");
		list.print();
		list.update(2, "花荣", "小李广~");
	}
	
	/**
	 * 	测试单链表插入、遍历
	 */
	@Test
	public void fun4() {
		
		SingleLinkedList list=new SingleLinkedList();
		list.addByOrder(3, "卢俊义", "玉麒麟");
		list.addByOrder(0, "宋江", "及时雨");
		list.addByOrder(2, "花荣", "小李广");
		list.addByOrder(1, "吴用", "智多星");
		list.addByOrder(1, "吴用", "智多星");
		list.addByOrder(2, "花荣", "小李广");
		System.out.println("更新前的数据...");
		System.out.println("LinkedList length:"+list.size());
		list.print();
		list.update(3, "卢俊义", "小小玉麒麟");
		list.update(10, "da", "dafl");
		System.out.println("更新后的数据...");
		list.print();
		list.remove(0);
		System.out.println("删除后的数据...");
		System.out.println("LinkedList length:"+list.size());
		list.print();
		System.out.println("查询的数据...");
		list.get(3);
		list.get(44);
		System.out.println("LinkedList length:"+list.size());
	}
	
	/**
	 * 	获取倒数第K个元素
	 */
	@Test
	public void fun5() {
		
		SingleLinkedList list=new SingleLinkedList();
		list.addByOrder(3, "卢俊义", "玉麒麟");
		list.addByOrder(0, "宋江", "及时雨");
		list.addByOrder(2, "花荣", "小李广");
		list.addByOrder(1, "吴用", "智多星");
		list.print();
		list.findLastIndexHeroNode(list.getHead(), 4);
		/*反转单链表*/
		System.out.println("/*反转单链表*/");
		list.reverse();
		list.print();
	}
	
	@Test
	public void fun6() {
		
		SingleLinkedList list1=new SingleLinkedList();
		list1.addByOrder(3, "卢俊义", "玉麒麟");
		list1.addByOrder(6, "阮小二", "立地太岁");
		list1.addByOrder(2, "花荣", "小李广");
		list1.addByOrder(7, "李俊", "混江龙");
		System.out.println("list 1:");
		list1.print();
		SingleLinkedList list2=new SingleLinkedList();
		list2.addByOrder(4, "武松", "行者");
		list2.addByOrder(1, "吴用", "智多星");
		list2.addByOrder(5, "刘唐", "赤发鬼");
		list2.addByOrder(0, "宋江", "及时雨");
		System.out.println("list 2:");
		list2.print();
		System.out.println("after merge two list:");
		SingleLinkedList list=new SingleLinkedList();
		SingleLinkedList.mergeList4one(list1,list2,list);
		list.print();
	}
}
