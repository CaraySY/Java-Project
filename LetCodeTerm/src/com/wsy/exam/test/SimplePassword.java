package com.wsy.exam.test;

import java.util.Scanner;

public class SimplePassword {

	public static void main(String[] args) {
		
		Scanner keyboard=new Scanner(System.in);
		String s;
		while(keyboard.hasNext()) {
			s=keyboard.nextLine();
			password(s);
		}
		keyboard.close();
	}
	
	public static void password(String s) {
		
		char[] ps=s.toCharArray();
		int index=0;
		while(index < ps.length) {
			if(ps[index]>=65 && ps[index]<=90) {
				ps[index]=getNext(ps[index]);
				index++;
			}else if(ps[index]>=97 && ps[index]<=122){
				ps[index]=getReal(ps[index]);
				index++;
			}else{
				index++;
			}
		}
		System.out.println(new String(ps));
	}
	
	private static char getNext(char c) {
		
		switch (c) {
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'F':
		case 'G':
		case 'H':
		case 'I':
		case 'J':
		case 'K':
		case 'L':
		case 'M':
		case 'N':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
		case 'T':
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
			return (char) ((c+32)+1);
		case 'Z':
			return 'a';
		default:
			return c;
		}
	}
	
	private static char getReal(char c) {
		
		switch (c) {
		case '1':
			return '1';
		case 'a':
		case 'b':
		case 'c':
			return '2';
		case 'd':
		case 'e':
		case 'f':
			return '3';
		case 'g':
		case 'h':
		case 'i':
			return '4';
		case 'j':
		case 'k':
		case 'l':
			return '5';
		case 'm':
		case 'n':
		case 'o':
			return '6';
		case 'p':
		case 'q':
		case 'r':
		case 's':
			return '7';
		case 't':
		case 'u':
		case 'v':
			return '8';
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			return '9';
		case '0':
			return '0';
		default:
			return c;
		}
	}
}
