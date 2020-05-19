package com.wsy.exam.test;

import java.util.Scanner;

public class CountANumberBinaryOfOne {

	public static void main(String[] args) {
		
		Scanner keyboard=new Scanner(System.in);
		int s;
		while(keyboard.hasNext()) {
			s=keyboard.nextInt();
			int res=octToBin(s);
			System.out.println(res);
		}
		keyboard.close();
	}
	
	public static int octToBin(int data) {
		
		int len=0;
		while(data > 0) {
			int pop=data%2;
			if(pop==1) {
				len++;
			}
			data=data/2;
		}
		return len;
	}
}
