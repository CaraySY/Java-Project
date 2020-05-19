package com.syw.knapsack_problem;

public class KnapsackProblem {

	public static void main(String[] args) {
		
		knapsackProblem();
	}
	
	public static void knapsackProblem() {
		
		int[] w= {1,4,3}; //物品的重量
		int[] val= {1500,3000,2000};
		int m=4; //背包的容量
		int n=w.length; //物品的个数
		// v[i][j] --> 表示将前i个物品装入容量为j的背包的最大价值
		int[][] v=new int [n+1][m+1]; // 第一行和第一列全为：0
		//定义二维数组记录放商品的情况
		int[][] path=new int [n+1][m+1];
		//第一行全零
		/*
		 * for(int i=0;i<v.length;i++) { for(int j=0;j<v[i].length;j++) { v[0][j]=0; } }
		 */
		//第一列全零
		/*
		 * for(int i=0;i<v.length;i++) { for(int j=0;j<v[i].length;j++) { v[i][0]=0; } }
		 */
		/*第一行第一列都为 0 ，下标从 1 开始*/
		for(int i=1;i<v.length;i++) {
			for(int j=1;j<v[i].length;j++) {
				//如果 W[i] > j 即，准备加入的物品容量大于当前剩余容量
				if(w[i-1] > j) { // i从1开始，所以 w[i-1]
					v[i][j]=v[i-1][j]; //当前i个物品装入容量为j的背包的最大价值为前i-1个物品装入背包的价值
				}else{ //如果 W[i] <= j 即，准备加入的物品容小于等于于当前剩余容量
					
					//val[i]+v[i-1][j-w[i]] 
					//	-> 将问题转化为前 i-1个物品在背包容量为 j-w[i] 加上准备加入的第 i个物品的价值之和
					if(v[i-1][j] > val[i-1]+v[i-1][j-w[i-1]]) {
						v[i][j]=v[i-1][j];
					}else {
						v[i][j]=val[i-1]+v[i-1][j-w[i-1]];
						path[i][j]=1 ;//记录最优解的情况
					}
				}
					//记录商品存放到背包的情况，使用if-else
					
			}
		}
		printArray(v);
		//逆序输出放到背包的记录
		int i=path.length-1;
		int j=path[0].length-1;
		while(i>0 && j>0) {
			if(path[i][j] == 1) {
				System.out.printf("第%d个商品放入背包\n",i);
				j=j-w[i-1];
			}
			i--;
		}
		
	}
	
	public static void printArray(int[][] array) {
		
		for(int[] temp : array) {
			for(int data : temp) {
				System.out.print(data+"\t");
			}
			System.out.println("\n");
		}
	}
}


