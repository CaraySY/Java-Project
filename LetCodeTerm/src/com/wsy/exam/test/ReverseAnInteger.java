package com.wsy.exam.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseAnInteger {

	public static void main(String[] args) {
		
		Scanner keyboard=new Scanner(System.in);
		//int data;
		String s;
		while(keyboard.hasNext()) {
			//data=keyboard.nextInt();
			//reverse(data);
			s=keyboard.nextLine();
			reverse2(s);
		}
		keyboard.close();
	}
	
	public static void reverse(int data) {
		
		List<Integer> list=new ArrayList<>();
		while(data > 0) {
			int pop=data%10;
			list.add(pop);
			data=data/10;
		}
		for(int temp:list) {
			System.out.print(temp);
		}
		System.out.println();
	}
	
	public static void reverse2(String s) {
		
		char[] ps=s.toCharArray();
		for(int i=ps.length-1;i>=0;i--) {
			System.out.print(ps[i]);
		}
		System.out.println();
	}
}
