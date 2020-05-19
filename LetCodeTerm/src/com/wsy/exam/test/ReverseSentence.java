package com.wsy.exam.test;

import java.util.Scanner;

public class ReverseSentence {

	public static void main(String[] args) {
		
		Scanner keyboard=new Scanner(System.in);
		String s;
		while(keyboard.hasNext()) {
			s=keyboard.nextLine();
			split(s);
		}
		keyboard.close();
	}
	
	public static void split(String s) {
		
		String[] strs = s.split(" ");
		for(int i=strs.length-1;i>=0;i--) {
			System.out.print(strs[i]+" ");
		}
	}
}
