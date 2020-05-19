package com.wsy.dp;

public class Fib {

	public static void main(String[] args) {
		
		int res=fib(9);
		System.out.println("res="+res);
	}
	
	/**
	 * 	����Ӧ�ö�̬�滮��˼· n>=2ʱ ���ƹ�ʽ�� fn=fn-1+fn-2
	 * @param n
	 * @return
	 */
	public static int fib(int n) {
		
		if(n <= 0) {
			return 0;
		}
		if(n==1 || n==2) {
			return 1;
		}
		int[] ans=new int[n];
		ans[0]=1; //��һ��
		ans[1]=1; // �ڶ���
		for(int i=2;i<ans.length;i++) {
			ans[i]=ans[i-1]+ans[i-2];
		}
		return ans[n-1];  // ans[0] ��ʼ
	}
}
