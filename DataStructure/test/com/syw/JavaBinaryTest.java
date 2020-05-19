package com.syw;

import java.util.Scanner;

import org.junit.Test;

public class JavaBinaryTest {

	private Scanner keyboard=new Scanner(System.in);
	
	@Test
	public void fun1() {
		
		while(true) {
			System.out.println("输入转换的 byte数：");
			byte a=keyboard.nextByte();
			System.out.println(Integer.toBinaryString((byte)a));
		}
	}
	
	@Test
	public void fun2() {
		
			System.out.println("输入转换的 int数：");
			int temp=keyboard.nextInt();
			//补充高位数据
			temp=temp | 256;
			//只返回后8位数据就可以
			String binaryString = Integer.toBinaryString(temp);
			//System.out.println(binaryString.substring(binaryString.length()-8));
			System.out.println(binaryString);
	}
}
