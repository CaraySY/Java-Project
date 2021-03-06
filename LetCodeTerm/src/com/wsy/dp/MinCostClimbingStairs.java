package com.wsy.dp;

/**
 * 	多做一些经典的问题我觉得其实就可以了，
 * 第 5 题、第 53 题、第 300 题、第 72 题、第 1143 题、
 * 第 62 题、第 63 题、背包问题（第 416 题，第 494 题）、
 * 硬币问题（第 322 题、第 518 题）、打家劫舍问题（做头两题即可）、
 * 股票问题、第 96 题、第 139 题、第 10 题、第 91 题、
 * 第 221 题。这些都是比较经典的问题，思路都可以--自底向上
 * @author Administrator
 *
 */
public class MinCostClimbingStairs {

	public static void main(String[] args) {

		int[] cost= {10,15,20};
		int res=minCostClimbingStairs(cost);
		System.out.println("res="+res);
	}

	/**
	 * 	1、定义dp[i]为当前到达的楼层的最小花费
	 *  2、递推公式：
	 *  	dp[i]=min{dp[i-1],dp[i-2]}+nums[i]
	 *  --参考了别人的，优化
	 * @param cost
	 * @return
	 */
	public static int minCostClimbingStairs(int[] cost) {

		return 0;
	}
}
