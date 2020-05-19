package com.syw;

import org.junit.Test;

import com.syw.list.DoubleLinkedList;

public class DoubleLinkedListTest {

	@Test
	public void fun1() {
		
		DoubleLinkedList list=new DoubleLinkedList();
		list.add(0, "宋江", "及时雨");
		list.add(1, "吴用", "智多星");
		list.add(2, "花荣", "小李广");
		list.add(3, "卢俊义", "玉麒麟");
		list.print();
		list.update(3, "花荣", "小李广~");
		list.print();
		list.remove(3);
		list.print();
	}
	
	@Test
	public void fun2() {
		
		DoubleLinkedList list=new DoubleLinkedList();
		list.addByOrder(2, "花荣", "小李广");
		list.addByOrder(3, "卢俊义", "玉麒麟");
		list.addByOrder(0, "宋江", "及时雨");
		list.addByOrder(1, "吴用", "智多星");
		list.print();
	}
}
