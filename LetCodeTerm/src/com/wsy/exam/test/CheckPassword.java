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
				continue;//�����ֱ��������һ��ѭ��
			}else if(ps[i] >= 'A' && ps[i] <= 'Z') {
				upperCase=1;
				continue;//�����ֱ��������һ��ѭ��
			}else if(ps[i] >= '0' && ps[i] <= '9') {
				digit=1;
				continue;//�����ֱ��������һ��ѭ��
			}else {
				other=1;
				continue;//�����ֱ��������һ��ѭ��
			}
		}
		int sum=lowCase+upperCase+digit+other;
		return sum >= 3 ? true:false;
	}
	
	public static boolean checkRepeatStr(String s) {
		
		//��������ͬ���ȳ�2���Ӵ��ظ�
		for(int i=0;i<s.length()-2;i++) {
			String temp=s.substring(i,i+3);//�ж���ͬ�ĳ��Ȱ���������������Ϳ����� 
			if(s.substring(i+1).contains(temp)) { //���i��temp���׵�ַһ�¾ͱ�Ȼ�����ظ���,����i+1
				return false;
			}
		}
		return true;
	}
}
