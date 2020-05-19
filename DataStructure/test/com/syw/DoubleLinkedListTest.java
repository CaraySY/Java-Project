package com.syw;

import org.junit.Test;

import com.syw.list.DoubleLinkedList;

public class DoubleLinkedListTest {

	@Test
	public void fun1() {
		
		DoubleLinkedList list=new DoubleLinkedList();
		list.add(0, "�ν�", "��ʱ��");
		list.add(1, "����", "�Ƕ���");
		list.add(2, "����", "С���");
		list.add(3, "¬����", "������");
		list.print();
		list.update(3, "����", "С���~");
		list.print();
		list.remove(3);
		list.print();
	}
	
	@Test
	public void fun2() {
		
		DoubleLinkedList list=new DoubleLinkedList();
		list.addByOrder(2, "����", "С���");
		list.addByOrder(3, "¬����", "������");
		list.addByOrder(0, "�ν�", "��ʱ��");
		list.addByOrder(1, "����", "�Ƕ���");
		list.print();
	}
}
