package com.wsy.exam.test;

import java.util.Scanner;

public class TwoNumberSum {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// ע�⣬��������Ƕ��������������ͨ��whileѭ����������������
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(sum(a,b));
        }
        in.close();
	}
	
	public static int sum(int a,int b) {
		
		return a+b;
	}
}
