package com.wsy.dp.backpack;

import java.util.Scanner;

/**
 * 
 * 有N件物品和一个容量为V的背包。（每种物品均只有一件）第i件物品的费用是c[i]，价值是w[i]。
 *  求解将哪些物品装入背包可使价值总和最大。
 *	 	这是最基础的背包问题，特点是：每种物品仅有一件，可以选择放或不放。
 * @author Administrator
 *
 */
public class Package_0_1 {

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
		int res=advance(v,w,N,V);
		System.out.println(res);
	}
	
	/**
	 * 	定义dp[i][j] 为在容量为j的背包中放入前i中物品的最大价值：
	 * 	(当将要放入容量为j的物品重量小于背包容量时，考虑是否放入背包中，即可以放入或者不放入背包时的最大价值取其最大值)
	 *  dp[i][j]=max{dp[i-1][j-w[i]]+v[i],dp[i-1][j]} (w[i] < j)
	 *          = dp[i-1][j] (当将要放入容量为j的物品重量大于背包容量时，不能放入)
	 *  dp[i][0]=0, 当背包容量为0，最大价值必定为0
	 *  dp[0][i]=0 ，当背包容量为i时，由于不能将任一个物品放入背包，其最大价值必定为0
	 * @param w 每种物品的重量
	 * @param v 每种物品的价值
	 * @return 最大价值
	 */
	public static int packages_0_1(int[] v,int[] w,int N,int V) {
		
		int[][] dp=new int[N+1][V+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=V;j++) {
				if(v[i-1]>j) {  //v才是体积
					dp[i][j]=dp[i-1][j];
				}else {
					dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-v[i-1]]+w[i-1]);
				}
			}
		}
		return dp[N][V];
	}
	
	/**
	 * 利用逆序循环-- j直接从背包最大容量开始循环
	 * 	公式f[v]=max{f[v],f[v-c[i]]+w[i]}中等号右边的
	 *  f[v]和f[v-c[i]]+w[i]保存的是f[i-1][v]和f[i -1][v-c[i]]的值。
	 * @param w
	 * @param v
	 * @return
	 */
	public static int advance(int[] v,int[] w,int N,int V) {
		
		int[] dp=new int[V+1];
		for(int i=1;i<=N;i++) {
			//使用逆序打印的方式---当前背包容量J需要大于或者等于当前加入的物品的体积 
			for(int j=V;j>=v[i-1];j--) {
				dp[j]=Math.max(dp[j], dp[j-v[i-1]]+w[i-1]);
			}
		}
		return dp[V];
	}
}
