package com.wsy.dp;

import java.util.Arrays;

/**
 * 	给定不同面额的硬币 coins 和一个总金额 amount。
 * 	编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 	如果没有任何一种硬币组合能组成总金额，返回 -1。
 * @author Administrator
 *
 */
public class CoinChange {

	public static void main(String[] args) {
		
		int[] coins= {1,2,5};
		int res=coinChange(coins, 11);
		System.out.println(res);
	}
	
	/**
	 * 	定义dp[i]为凑出价值为 i所需要的最小硬币数
	 *    (换取价值为i的最少硬币数与给定的币值有关：如dp5=dp4+1 dp5=1+dp0 dp5=dp3+1 即最少数为1)
	 *  dp[i]={dp[i-1]+1,dp[i-2]+1,dp[i-5]+1} =>加一代表所需硬币数加一
	 *  dp[0]=0 => 换取价值为0的最少硬币数为0
	 * @param coins
	 * @param amount
	 * @return
	 */
	public static int coinChange(int[] coins,int amount) {
		
		int[] dp=new int[amount+1];
		Arrays.fill(dp, amount+1); //初始化换取的最少币数量为 需要换取的纸币价值+1
		dp[0]=0;
		for(int i=1;i<=amount;i++) {
			//使用第二层for循环来判断使用哪一种币值来换成零钱
			for(int j=0;j<coins.length;j++) {
				if(i >=coins[j]) {
					dp[i]=Math.min(dp[i], dp[i-coins[j]]+1); //记得加一
				}
			}
		}
		return dp[amount] < (amount+1) ? dp[amount] : -1;
	}
}