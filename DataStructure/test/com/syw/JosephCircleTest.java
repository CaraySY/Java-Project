package com.syw;

import org.junit.Test;

import com.syw.list.SingleCircleLinkedList;
import com.syw.queue.LinkedQueue;

public class JosephCircleTest {

	/**
	 * @param startNo	1
	 * @param countNum	2
	 * @param nums	5
	 * @Result 2->4->1->5->3
	 */
	@Test
	public void fun1() {
		
		SingleCircleLinkedList  list=new SingleCircleLinkedList();
		list.addBoy(5);
		System.out.println("约瑟夫环的遍历...");
		list.print();
		System.out.println("约瑟夫环解决...");
		list.solveJosephCircle(1, 2, 5);
	}
	
	@Test
	public void fun2() {
		
		LinkedQueue queue=new LinkedQueue();
		queue.addQueue(0, "宋江", "及时雨");
		queue.addQueue(1, "吴用", "智多星");
		queue.addQueue(2, "花荣", "小李广");
		queue.addQueue(3, "卢俊义", "玉麒麟");
		queue.print();
		System.out.println("队列的长度:"+queue.size());
		queue.popQueue();
		queue.popQueue();
		queue.popQueue();
		queue.popQueue();
		queue.print();
		queue.popQueue();
		queue.popQueue();
	}
}
