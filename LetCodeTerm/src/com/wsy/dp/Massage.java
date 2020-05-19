package com.wsy.dp;

/**
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
 * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 * @author Administrator
 *
 */
public class Massage {

	public static void main(String[] args) {
		
		int[] nums= {2,7,9,3,1};
		int res=massage(nums);
		System.out.println(res);
	}
	
	/**
	 * 	1.因为当 dp[i]接受 或不接受，破坏了动态规划的无后效性。需要增加一个[flag]->flag=0/1代表接受、不接受
	 *  2.递推公式：dp[i][1]->当第i个位置接受转化为 dp[i-1][0]+nums[i]
	 *  	不接受：dp[i][0]=Max{dp[i-1][0],dp[i-1][1]}--转化为上一个间隔的状态可能或不可能接受两种的最大值
	 * @param nums
	 * @return
	 */
	public static int massage(int[] nums) {
		
		int[][] dp=new int[nums.length+1][2];// 0-1需要两位
		for(int i=1;i<=nums.length;i++) {
			dp[i][1]=dp[i-1][0]+nums[i-1]; // 因为i从1开始 nums需要从0开始所以，i-1
			dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
		}
		return Math.max(dp[nums.length][1],dp[nums.length][0]);
	}
}
