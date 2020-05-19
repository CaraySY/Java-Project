package com.wsy.exam.test;

import java.util.Scanner;

public class CountChar {

	public static void main(String[] args) {
		
		Scanner keyboard=new Scanner(System.in);
		while(keyboard.hasNext()) {
			String s=keyboard.nextLine();
			char x=keyboard.nextLine().charAt(0);
			int res=get(s,x);
			System.out.println("res="+res);
		}
		keyboard.close();
	}
	
	public static int get(String s,char x) {
		
		int count=0;
		char[] ps=s.toLowerCase().toCharArray();
		if(x>=65 && x<=90) {
			x=(char) (x+32);
		}
		for(int i=0;i<ps.length;i++) {
			if(ps[i]==x) {
				count++;
			}
		}
		return count;
	}
}
