package com.wsy.dp;

/**
 * 
 * 	动态规划算法(Dynamic Programma Algorithm[DP]) [本质上dp算法是一种高效的枚举算法]
 *  解题步骤分为5步：
 *  	1、判断问题是否找最优解
 *  	2、从上下到下分析，分解子问题，子问题还可以继续分解
 *  	3、从上到下分析问题的关联，找出状态转移方程
 *  	4、考虑边界情况
 *  	5、解决实际问题
 *  eg：青蛙跳楼梯问题
 *   每次只能跳一阶或者二阶
 * @author Administrator
 *
 */
public class JumpFloor {

	public static void main(String[] args) {
		
		System.out.println(waysToStep(61));
	}
	
	/**
	 * eg：青蛙要跳到6阶，共有多少种跳法，
	 *  最后一次跳可以是跳两次、或一次 -> f(6)=f(4)+f(5) [从开始到第四阶跳的总数 + 从开始到第五阶跳的总数和]
	 *  	-> f(5)=f(4)+f(3)=8种
	 *  	-> f(4)=f(3)+f(2)=5种
	 *  	-> f(3)=f(2)+f(1)=3种
	 *  	-> f(2)=f(1)+f(0)=2种。。
	 *  	-> f(1)=1种
	 *  n>=3有  fn = fn-1 + fn-2;
	 *  
	 *  n 阶梯数
	 * @return
	 */
	public static int jump(int n) {
		
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
		if(n==3) {
			return 4;
		}
		int[] ans=new int[n+1]; //保存结果
		ans[0]=0;
		ans[1]=1;
		ans[2]=2;//两阶两种
		for(int i=3;i<=n;i++) { // i 只到 n-1处，需要扩容
			ans[i]=ans[i-1]+ans[i-2];
		}
		return ans[n];
	}
	
	public static int waysToStep(int n) {
		
		long[] dp=new long[n+1];
		dp[0]=0;//零阶0种方式
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		for(int i=4;i<=n;i++) {
			dp[i]=(dp[i-1]+dp[i-2]+dp[i-3])%1000000007;
		}
		return (int)dp[n];
	}
}
