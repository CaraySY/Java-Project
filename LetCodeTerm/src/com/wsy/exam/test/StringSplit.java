package com.wsy.exam.test;

import java.util.Arrays;
import java.util.Scanner;

public class StringSplit {

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
		
		char[] temp=new char[8];
		Arrays.fill(temp, '0');
		for(int i=0;i<s.length();i+=8) {
			if(i<s.length() && (s.length()-i) < 8) {
				String str=s.substring(i);
				for(int j=0;j<str.length();j++) {
					temp[j]=str.charAt(j);
				}
				System.out.println(temp);
			}else if(i%8==0) {
				temp=s.substring(i, i+8).toCharArray();
				System.out.println(temp);
			}
			Arrays.fill(temp, '0'); //ÇåÁã
		}
	}
}
