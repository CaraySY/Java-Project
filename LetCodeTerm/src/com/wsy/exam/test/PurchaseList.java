package com.wsy.exam.test;

import java.util.Scanner;

public class PurchaseList {

	private static int[][] dp;
	private static int N,m;//N总钱数，m希望购物的物品个数
	private static Scanner keyboard=new Scanner(System.in);
	
	// N<32000 m<60 一个主件只能对应0,1,2个从件
	public static void main(String[] args) {

		N=keyboard.nextInt();
		m=keyboard.nextInt();
		dp=new int[m+1][N+1];
		/*保存主从件的value是一个二维数组,保存了主从件的价格*/
		int[][] value=new int[m+1][3];
		/*important是一个二维数组，保存了主从件的重要度*/
		int[][] important=new int[m+1][3];
		/*输入数据*/
		init(value,important);
		int res = list(value,important);
		System.out.println(res);
		keyboard.close();
	}
	
	/**
	 * 	初始化物品的价格，重要度的数据
	 * @param value 物品价格 [0,1,2]代表主件，从件1，从件2
	 * @param important 重要度
	 */
	public static void init(int[][] value, int[][] important) {
		
		int q,p,v;// p表示物品重要度，q表明是主件/附件,v是价格
		//q=0，该物品是主件 ，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）---从件同主件编号
		// 初始化物品
		for (int i = 1; i < m + 1; i++) { // 从编号1开始，因为q=0是主件
			v = keyboard.nextInt(); // 物品价格
			p = keyboard.nextInt(); // 重要度
			q = keyboard.nextInt(); // q判定主从件,q还是主件的编号
			if (q == 0) {
				// 如果q等于0，i代表主件的编号
				value[i][0] = v;
				important[i][0] = p;
			} else {
				//如果编号不为0，那么此时q代表的是该从件的主件的编号
				if (value[q][1] == 0) { //判断是否已经有了第一个从件
					value[q][1] = v;//根据主件编号赋值给从件
					important[q][1] = p;
				} else {
					value[q][2] = v;
					important[q][2] = p;
				}
			}
		}
	}
	
	/**
	 * 	四种情况，选主从件都不选、主件、主件+1号从件、主件+2号从件、主件+1/2号从件
	 *  dp[i,j] 代表在钱数为 j的情况下，从前i个物品中购买物品的最大价格
	 * @param value
	 * @param important
	 * @return
	 */
	public static int list(int[][] value,int[][] important) {
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<N+1;j++) {
				
				dp[i][j]=dp[i-1][j];
				//选主件、主件+1号从件、主件+2号从件、主件+1/2号从件
				if(j-value[i][0]>=0) {
					dp[i][j]=Math.max(dp[i][j], 
							dp[i-1][j-value[i][0]]+
							value[i][0]*important[i][0]);
				}
				if(j-value[i][0]-value[i][1]>=0) { //主 加1
					dp[i][j]=Math.max(dp[i][j], 
							dp[i-1][j-value[i][0]-value[i][1]]+
							value[i][0]*important[i][0]+
							value[i][1]*important[i][1]);
				}
				if(j-value[i][0]-value[i][2]>=0) { //主加2
					dp[i][j]=Math.max(dp[i][j], 
							dp[i-1][j-value[i][0]-value[i][2]]+
							value[i][0]*important[i][0]+
							value[i][2]*important[i][2]);
				}
				if(j-value[i][0]-value[i][1]-value[i][2]>=0) { //主加1 2
					dp[i][j]=Math.max(dp[i][j], 
							dp[i-1][j-value[i][0]-value[i][1]-value[i][2]]+
							value[i][0]*important[i][0]+
							value[i][1]*important[i][1]+
					        value[i][2]*important[i][2]);
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}
}
