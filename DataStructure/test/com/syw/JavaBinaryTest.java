package com.syw;

import java.util.Scanner;

import org.junit.Test;

public class JavaBinaryTest {

	private Scanner keyboard=new Scanner(System.in);
	
	@Test
	public void fun1() {
		
		while(true) {
			System.out.println("����ת���� byte����");
			byte a=keyboard.nextByte();
			System.out.println(Integer.toBinaryString((byte)a));
		}
	}
	
	@Test
	public void fun2() {
		
			System.out.println("����ת���� int����");
			int temp=keyboard.nextInt();
			//�����λ����
			temp=temp | 256;
			//ֻ���غ�8λ���ݾͿ���
			String binaryString = Integer.toBinaryString(temp);
			//System.out.println(binaryString.substring(binaryString.length()-8));
			System.out.println(binaryString);
	}
}
