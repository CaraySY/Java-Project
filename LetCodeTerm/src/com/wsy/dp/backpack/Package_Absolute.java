package com.wsy.dp.backpack;

import java.util.Scanner;

public class Package_Absolute {

private static Scanner keyboard=new Scanner(System.in);
	
	public static void main(String[] args) {

		int N,V; //物品数量，背包体积
		N=keyboard.nextInt();
		V=keyboard.nextInt();
		int[] v=new int[N]; //物品的体积
		int[] w=new int[N]; //物品的价值
		for(int i=0;i<N;i++) {
			v[i]=keyboard.nextInt();
			w[i]=keyboard.nextInt();
		}
		int res=advance_2(v,w,N,V);
		System.out.println(res);
	}

	/**
	 * 	完全背包问题，每种物品可以放入的数量是无限个[朴素算法]---优化:完全背包正序循环，0-1背包，倒序循环
	 * @param v
	 * @param w
	 * @return
	 */
	//朴素算法
	public static int package_Absolute(int[] v,int[] w,int N,int V) {
		
		int[][] dp=new int[N+1][V+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=V;j++) {
				for(int k=0;k*v[i-1]<=j;k++) { //最最朴素的算法
					if(j<v[i-1]) {
						dp[i][j]=dp[i-1][j];
					}else {
						dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-k*v[i-1]]+k*w[i-1]);
					}
				}
			}
		}
		return dp[N][V];
	}
	
	/*优化算法1，消除K*/	
	public static int advance_1(int[] v,int[] w,int N,int V) {
		
		int[][] dp=new int[N+1][V+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=V;j++) { 
				if(j<v[i-1]) {
					dp[i][j]=dp[i-1][j];
				}else {
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-v[i-1]]+w[i-1]);
				}
			}
		}
		return dp[N][V];
	}
	
	/**
	 * 优化2，使用一维数组，正序循环
	 * @param v
	 * @param w
	 * @param N
	 * @param V
	 * @return
	 */
	public static int advance_2(int[] v,int[] w,int N,int V) {
		
		int[] dp=new int[V+1];
		for(int i=1;i<=N;i++) {
			for(int j=v[i-1];j<=V;j++) { //j背包体积，直接从v[i]开始
				dp[j]=Math.max(dp[j],dp[j-v[i-1]]+w[i-1]);
			}
		}
		return dp[V];
	}
}
