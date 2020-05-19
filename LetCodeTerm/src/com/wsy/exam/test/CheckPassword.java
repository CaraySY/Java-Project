package com.wsy.exam.test;

import java.util.Scanner;

public class CheckPassword {

	public static void main(String[] args) {
		
		Scanner keyboard=new Scanner(System.in);
		String s;
		while(keyboard.hasNext()) {
			s=keyboard.next();
			if(checkLen(s) && checkKinds(s) && checkRepeatStr(s)) {
				System.out.println("OK");
			}else {
				System.out.println("NG");
			}
		}
		keyboard.close();
	}
	
	public static boolean checkLen(String s) {
		
		if(s==null || s.length() <= 8) {
			return false;
		}
		return true;
	}
	
	public static boolean checkKinds(String s) {
		
		char[] ps=s.toCharArray();
		int lowCase = 0,upperCase=0,digit=0,other=0;
		for(int i=0;i<ps.length;i++) {
			if(ps[i] >= 'a' && ps[i] <= 'z') {
				lowCase=1;
				continue;//如果有直接跳到下一个循环
			}else if(ps[i] >= 'A' && ps[i] <= 'Z') {
				upperCase=1;
				continue;//如果有直接跳到下一个循环
			}else if(ps[i] >= '0' && ps[i] <= '9') {
				digit=1;
				continue;//如果有直接跳到下一个循环
			}else {
				other=1;
				continue;//如果有直接跳到下一个循环
			}
		}
		int sum=lowCase+upperCase+digit+other;
		return sum >= 3 ? true:false;
	}
	
	public static boolean checkRepeatStr(String s) {
		
		//不能有相同长度超2的子串重复
		for(int i=0;i<s.length()-2;i++) {
			String temp=s.substring(i,i+3);//判断相同的长度包含等于三的情况就可以了 
			if(s.substring(i+1).contains(temp)) { //如果i和temp的首地址一致就必然出现重复了,所以i+1
				return false;
			}
		}
		return true;
	}
}
