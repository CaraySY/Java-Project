package com.wsy.exam.test;

import java.util.Scanner;

public class HEX2OCT {

	public static void main(String[] args) {
		
		Scanner keyboard=new Scanner(System.in);
		String s;
		while(keyboard.hasNext()) {
			s=keyboard.nextLine();
			int res=change(s);
			System.out.println(res);
		}
		keyboard.close();
	}
	
	public static int change(String s) {
		
		String[] splits=s.split("0x");
		char[] data=splits[1].toCharArray();
		int sum=0;
		int i=0;
		while(i<data.length) {
			int pop=getOct(data[i]);
			sum=sum*16+pop;
			i++;
		}
		return sum;
	}
	
	private static int getOct(char data) {
		
		switch (data) {
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			return data-'0';
		case 'A':
			return 10;
		case 'B':
			return 11;
		case 'C':
			return 12;
		case 'D':
			return 13;
		case 'E':
			return 14;
		case 'F':
			return 15;
		default:
			return 0;
		}
	}
}
