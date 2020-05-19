package com.wsy.dp;

public class SearchNumArray {

	private static int[] nums= {-2, 0, 3, -5, 2, -1};
	
	public static void main(String[] args) {
		
		int res=sumRange(2,5);
		System.out.println("res="+res);
	}
	
	/**
	 * 	1.����dp[j]�ĺ���Ϊ����i��j��Ԫ��֮��
	 *  2.���ƹ�ʽ��
	 *  	dp[j]=dp[j-1]+nums[j] j>=1����Ч
	 *  3.��ʼֵ:i=0-->dp[j]=dp[i]=nums[0]
	 * @param i
	 * @param j
	 * @return
	 */
	public static int sumRange(int i,int j) {
		
		int[] dp=new int[j+1];//����j
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
