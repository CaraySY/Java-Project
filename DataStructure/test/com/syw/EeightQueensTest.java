package com.syw;

import org.junit.Test;

import com.syw.recursion.EeightQueens;

public class EeightQueensTest {

	@Test
	public void fun1() {
		
		EeightQueens queens=new EeightQueens();
		queens.check(0);
		System.out.println("�˻ʺ���ܹ��ⷨ��"+queens.count());
	}
}
