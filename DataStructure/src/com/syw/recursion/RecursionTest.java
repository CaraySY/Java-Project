package com.syw.recursion;

/**
 * 	�ݹ���ù���
 * 	1��������ִ�е�һ�������ǣ��Ὺ��һ�������Ŀռ�
 *  2��ÿ���ռ������(�ֲ�����)���Ƕ����Ĺ�ϵ
 * @author Administrator
 *
 */
public class RecursionTest {

	public static void main(String[] args) {
		
		test(4);
		System.out.println("�׳˵���..."+factorial(4));
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


