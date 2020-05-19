package com.wsy.dp;

/**
 * 	不相邻子元素的和的最大值
 * @author Administrator
 *
 */
public class Rob {

	public static void main(String[] args) {
		
		int[] array= {0};
		int res=rob(array);
		System.out.println("res="+res);
	}
	
	/**
	 * 	1、定义dp[i] 为小偷当前或能够获取的最大利益
	 *  -- 如： 2 4 5 假定当前dp[i]=5 ，两种情况，选：则num[i-1]不能选，转化为  dp[i]=dp[i-2]到 nums[i]的问题
	 *  --                             不选：则num[i-1]可以选，转化为 dp[i]=dp[i-1]的问题
	 *  2、递推公式：dp[i]=max{dp[i-2]+nums[i],dp[i-1]} 
	 *  3、确定初始值：i=0,dp[i]=nums[0] i=2,dp[i]=max(num[0],num[1])
	 * @param nums
	 * @return
	 */
	public static int rob(int[] nums) {
		
		if(nums==null || nums.length==0) {
			return 0;
		}
		if(nums.length==1) {
			return nums[0];
		}
		if(nums.length==2) {
			return Math.max(nums[0], nums[1]);
		}
		int[] dp=new int[nums.length];
		dp[0]=nums[0];
		dp[1]=Math.max(nums[0], nums[1]);
		int res=0;
		for(int i=2;i<nums.length;i++) {
			dp[i]=Math.max(dp[i-2]+nums[i], dp[i-1]);
			res=Math.max(res, dp[i]);
		}
		return res;
	}
}
