package com.wsy.dp;

public class SearchNumArray {

	private static int[] nums= {-2, 0, 3, -5, 2, -1};
	
	public static void main(String[] args) {
		
		int res=sumRange(2,5);
		System.out.println("res="+res);
	}
	
	/**
	 * 	1.定义dp[j]的含义为，从i到j的元素之和
	 *  2.递推公式：
	 *  	dp[j]=dp[j-1]+nums[j] j>=1才有效
	 *  3.初始值:i=0-->dp[j]=dp[i]=nums[0]
	 * @param i
	 * @param j
	 * @return
	 */
	public static int sumRange(int i,int j) {
		
		int[] dp=new int[j+1];//包括j
		if(i<=0) {
			int sum=0;
			for(int k=0;k<=j;k++) {
				sum+=nums[k];
			}
			return sum;
		}
		for(int k=i;k<dp.length;k++) {
			dp[k]=dp[k-1]+nums[k];
		}
		return dp[dp.length-1];
	}
}
