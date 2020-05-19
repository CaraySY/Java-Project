package com.wsy.dp.backpack;

import java.util.Scanner;

/**
 * 	多重背包问题是每种物品都有有限个
 * @author Administrator
 *
 */
public class Package_Massive {

	private static Scanner keyboard=new Scanner(System.in);
	
	public static void main(String[] args) {

		/*	1 2 3
			2 4 1
			3 4 3
			4 5 2
		int N,V; //物品数量，背包体积
		N=keyboard.nextInt();
		V=keyboard.nextInt();
		int[] v=new int[N]; //物品的体积
		int[] w=new int[N]; //物品的价值
		int[] s=new int[N]; //物品的数量
		for(int i=0;i<N;i++) {
			v[i]=keyboard.nextInt();
			w[i]=keyboard.nextInt();
			s[i]=keyboard.nextInt();
		}
		int res=package_Massive1(v,w,s,N,V);
		*/
		int res=package_Massive2();
		System.out.println(res);
	}
	
	/**
	 * 	朴素多重背包问题
	 * @param v
	 * @param w
	 * @param s  
	 * @param N
	 * @param V
	 * @return
	 */
	public static int package_Massive(int[] v, int[] w,int[] s ,int N,int V) {

		int[][] dp=new int[N+1][V+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=V;j++) {
				for(int k=0;k*v[i-1]<=j && k<=s[i-1];k++) { 
					dp[i][j]=dp[i-1][j];//不加入当前物品
					dp[i][j]=Math.max(dp[i][j], dp[i-1][j-k*v[i-1]]+k*w[i-1]);
				}
			}
		}
		return dp[N][V];
	}
	
	/**
	 * 	一维数组优化
	 * @param v
	 * @param w
	 * @param s
	 * @param N
	 * @param V
	 * @return
	 */
	public static int package_Massive1(int[] v, int[] w,int[] s ,int N,int V) {
		
		int[] dp=new int[V+1];
		for(int i=1;i<=N;i++) {
			for(int j=V;j>=v[i-1];j--) { //多重背包，0-1背包可以使用 一维数组优化使用倒序循环
				for(int k=0;k*v[i-1]<=j && k<=s[i-1];k++) { 
					dp[j]=Math.max(dp[j], dp[j-k*v[i-1]]+k*w[i-1]);
				}
			}
		}
		return dp[V];
	}
	
	/**
	 * 	使用二进制优化为0-1背包问题
	 * 	任何数都可以转换为：2^0+2^1+2^2...(1+2+4+8+...+2^k + data(2^k+1 < data < 2^k+2)
	 * @param v
	 * @param w
	 * @param s
	 * @param N
	 * @param V
	 * @return
	 */
	public static int package_Massive2() {
		
		int tot=1;//使用二进制优化时，记录优化过后的下标长度
		int N,V;
		N=keyboard.nextInt();
		V=keyboard.nextInt();
		int[] w=new int[10000]; //价值
		int[] v=new int[10000]; //体积
		for(int i=1;i<=N;i++) {
			int a=keyboard.nextInt();//体积
			int b=keyboard.nextInt();//价值
			int c=keyboard.nextInt();//数量
			for(int k=1;k<=c;k<<=1) {//k=k*2
				v[tot]=a*k;
				w[tot]=b*k;
				c=c-k;
				tot++;
			}
			if(c>0) { //多出来的c也一起打包
				v[tot]=a*c;
				w[tot]=b*c;
				tot++;
			}
		}
		int[] dp=new int[10000];
		for(int i=1;i<=tot;i++) {
			for(int j=V;j>=v[i];j--) { //倒序循环
				dp[j]=Math.max(dp[j], dp[j-v[i]]+w[i]);
			}
		}
		return dp[V];
	}
}

