package com.wsy.exam.test;

import java.util.Scanner;

public class TwoNumberSum {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
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
