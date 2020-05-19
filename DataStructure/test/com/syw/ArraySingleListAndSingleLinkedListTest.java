package com.syw;

import org.junit.Test;

import com.syw.list.SingleLinkedList;
import com.syw.queue.ArrayQueue;
import com.syw.queue.CircleArrayQueue;

public class ArraySingleListAndSingleLinkedListTest {

	/**
	 * 	@author Administrator
	 * 	�����������
	 */
	@Test
	public void fun1() {
		
		ArrayQueue queue=new ArrayQueue(5);
		for(int i=0;i<3;i++) {
			queue.addQueue(i*i);
		}
		queue.printQueue();
		System.out.println("������...");
		queue.getQueue();
		queue.getQueue();
		queue.printQueue();
		System.out.println("������...");
		queue.addQueue(6*6);
		queue.addQueue(7*7);
		queue.printQueue();
	}
	
	/**
	 * 	@author Administrator
	 * 	���������ѭ������
	 */
	@Test
	public void fun2() {
		
		CircleArrayQueue queue=new CircleArrayQueue(4);//ֻ�ܴ�����
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
	 * 	���Ե�������롢����
	 */
	@Test
	public void fun3() {
		
		SingleLinkedList list=new SingleLinkedList();
		list.add(0, "�ν�", "��ʱ��");
		list.add(1, "����", "�Ƕ���");
		list.add(2, "����", "С���");
		list.add(3, "¬����", "������");
		list.print();
		list.update(2, "����", "С���~");
	}
	
	/**
	 * 	���Ե�������롢����
	 */
	@Test
	public void fun4() {
		
		SingleLinkedList list=new SingleLinkedList();
		list.addByOrder(3, "¬����", "������");
		list.addByOrder(0, "�ν�", "��ʱ��");
		list.addByOrder(2, "����", "С���");
		list.addByOrder(1, "����", "�Ƕ���");
		list.addByOrder(1, "����", "�Ƕ���");
		list.addByOrder(2, "����", "С���");
		System.out.println("����ǰ������...");
		System.out.println("LinkedList length:"+list.size());
		list.print();
		list.update(3, "¬����", "СС������");
		list.update(10, "da", "dafl");
		System.out.println("���º������...");
		list.print();
		list.remove(0);
		System.out.println("ɾ���������...");
		System.out.println("LinkedList length:"+list.size());
		list.print();
		System.out.println("��ѯ������...");
		list.get(3);
		list.get(44);
		System.out.println("LinkedList length:"+list.size());
	}
	
	/**
	 * 	��ȡ������K��Ԫ��
	 */
	@Test
	public void fun5() {
		
		SingleLinkedList list=new SingleLinkedList();
		list.addByOrder(3, "¬����", "������");
		list.addByOrder(0, "�ν�", "��ʱ��");
		list.addByOrder(2, "����", "С���");
		list.addByOrder(1, "����", "�Ƕ���");
		list.print();
		list.findLastIndexHeroNode(list.getHead(), 4);
		/*��ת������*/
		System.out.println("/*��ת������*/");
		list.reverse();
		list.print();
	}
	
	@Test
	public void fun6() {
		
		SingleLinkedList list1=new SingleLinkedList();
		list1.addByOrder(3, "¬����", "������");
		list1.addByOrder(6, "��С��", "����̫��");
		list1.addByOrder(2, "����", "С���");
		list1.addByOrder(7, "�", "�콭��");
		System.out.println("list 1:");
		list1.print();
		SingleLinkedList list2=new SingleLinkedList();
		list2.addByOrder(4, "����", "����");
		list2.addByOrder(1, "����", "�Ƕ���");
		list2.addByOrder(5, "����", "�෢��");
		list2.addByOrder(0, "�ν�", "��ʱ��");
		System.out.println("list 2:");
		list2.print();
		System.out.println("after merge two list:");
		SingleLinkedList list=new SingleLinkedList();
		SingleLinkedList.mergeList4one(list1,list2,list);
		list.print();
	}
}
