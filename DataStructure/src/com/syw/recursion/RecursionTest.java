package com.syw.recursion;

/**
 * 	递归调用规则：
 * 	1、当程序执行到一个方法是，会开辟一个独立的空间
 *  2、每个空间的数据(局部变量)，是独立的关系
 * @author Administrator
 *
 */
public class RecursionTest {

	public static void main(String[] args) {
		
		test(4);
		System.out.println("阶乘调用..."+factorial(4));
	}
	
	public static void test(int n) {
		
		if(n > 2) {
			test(n-1);
		}
		System.out.println("n="+n);
	}
	
	public static int factorial (int n) {
		
		if(n==1 || n==0) {
			
			System.out.println();
			return 1;
		}else {
			System.out.printf("factorial(%d-1)->",n);
			return factorial(n-1)*n;
		}
	}
}


