package com.wsy.dp;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * @author Administrator
 *
 */
public class UniquePaths {

	public static void main(String[] args) {
		
		int paths = uniquePaths(3,2);
		System.out.println(paths);
	}
	
	/**
	 * 	dp[i][j] 为机器人从起始点到 (i,j)不同的路径总和
	 *  dp[i][j]=dp[i-1][j]+dp[i][j-1]
	 *    从左上贴墙直走，左边贴墙直下 都是1种
	 * @param m
	 * @param n
	 * @return
	 */
	public static int uniquePaths(int m,int n) {
		
		int[][] dp=new int[m+1][n+1];
		dp[0][0]=1;
		for(int i=1;i<=m;i++) {
			dp[i][0]=1;
		}
		for(int j=1;j<=n;j++) {
			dp[0][j]=1;
		}
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				dp[i][j]=dp[i-1][j]+dp[i][j-1];
			}
		}
		for(int[] temp:dp) {
			for(int data:temp) {
				System.out.print(data+"\t");
			}
			System.out.println();
		}
		return dp[m-1][n-1];
	}
}
