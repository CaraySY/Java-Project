package com.wsy.dp;

import java.util.Arrays;

public class MaxProfit {

	public static void main(String[] args) {
		
		int[] prices= {7,1,5,3,6,4};
		maxProfit(prices);
	}
	
	/**
	 * 
	 * 不能再买入后的前面时间卖出股票  如 i=3 不能再第2天卖出股票
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
		
		//1、定义dp[i]的含义：在第i天购入股票，在i+1到之后或能获取的最大利润
		int[] dp=new int[prices.length];
		//2、递推公式：dp[i]=max{nums[i+1]-price,dp[i]}; price
		//3、初值 利润为0
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
