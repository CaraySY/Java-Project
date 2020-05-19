package com.wsy.exam.test;

public class LastWordLen {

	public static void main(String[] args) {
		int len=lastWordLen("ABSIB T");
		System.out.println(len);
	}
	
	public static int lastWordLen(String s) {
		
		String trim = s.trim();
		char[] ps=trim.toCharArray();
		int i=ps.length-1;
		int len=0;
		while(ps[i]!=' ') {
			i--;
			len++;
		}
		return len;
	}
}
