package com.wsy.dp;

import java.util.Arrays;

public class MaxProfit {

	public static void main(String[] args) {
		
		int[] prices= {7,1,5,3,6,4};
		maxProfit(prices);
	}
	
	/**
	 * 
	 * ������������ǰ��ʱ��������Ʊ  �� i=3 �����ٵ�2��������Ʊ
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
		
		//1������dp[i]�ĺ��壺�ڵ�i�칺���Ʊ����i+1��֮����ܻ�ȡ���������
		int[] dp=new int[prices.length];
		//2�����ƹ�ʽ��dp[i]=max{nums[i+1]-price,dp[i]}; price
		//3����ֵ ����Ϊ0
		int res=0;
		for(int i=0;i<dp.length;i++) {
			dp[i]=0;
			int price=prices[i];
			for(int j=i+1;j<prices.length;j++) {
				dp[i]=Math.max(prices[j]-price, dp[i]);
			}
			res=Math.max(res, dp[i]);
		}
		System.out.println(Arrays.toString(dp));
		return res;
	}
}
