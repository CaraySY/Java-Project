package com.wsy;

public class TestEqualsAnd_ {

	public static void main(String[] args) {
		
		int a=123;
		int b=123;
		System.out.println(a==b);
		String s1="123";
		String s2="123";
		System.out.println(s1==s2);
		String s3=new String("123");
		System.out.println(s1==s3);
	}
}
