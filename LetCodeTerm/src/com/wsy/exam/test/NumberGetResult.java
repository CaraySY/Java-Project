package com.wsy.exam.test;

import java.util.Scanner;

/**
 * 	任何正整数都可以分解为其质因数的乘积，1不是质因数，1*x=x 质数是不能分解的
 * @author Administrator
 *
 */
public class NumberGetResult {

	public static void main(String[] args) {
		
		Scanner keyboard=new Scanner(System.in);
		long data;
		while(keyboard.hasNext()) {
			data=keyboard.nextLong();
			String res=getResult(data);
			System.out.println(res);
		}
		keyboard.close();
	}
	
	public static String getResult(long data) {
		
		StringBuilder builder=new StringBuilder();
		int k=2;
		while(k<=data) {
			if(data%k==0) {
				data=data/k;
				builder.append(k).append(" ");
			}else {
				k++;
			}
		}
		return builder.toString();
	}
}
