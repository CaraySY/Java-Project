package com.wsy.dp;

public class Fib {

	public static void main(String[] args) {
		
		int res=fib(9);
		System.out.println("res="+res);
	}
	
	/**
	 * 	可以应用动态规划的思路 n>=2时 递推公式： fn=fn-1+fn-2
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
		ans[0]=1; //第一个
		ans[1]=1; // 第二个
		for(int i=2;i<ans.length;i++) {
			ans[i]=ans[i-1]+ans[i-2];
		}
		return ans[n-1];  // ans[0] 开始
	}
}
