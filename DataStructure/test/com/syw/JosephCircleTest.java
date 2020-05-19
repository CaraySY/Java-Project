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
		System.out.println("Լɪ�򻷵ı���...");
		list.print();
		System.out.println("Լɪ�򻷽��...");
		list.solveJosephCircle(1, 2, 5);
	}
	
	@Test
	public void fun2() {
		
		LinkedQueue queue=new LinkedQueue();
		queue.addQueue(0, "�ν�", "��ʱ��");
		queue.addQueue(1, "����", "�Ƕ���");
		queue.addQueue(2, "����", "С���");
		queue.addQueue(3, "¬����", "������");
		queue.print();
		System.out.println("���еĳ���:"+queue.size());
		queue.popQueue();
		queue.popQueue();
		queue.popQueue();
		queue.popQueue();
		queue.print();
		queue.popQueue();
		queue.popQueue();
	}
}
