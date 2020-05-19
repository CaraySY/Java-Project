package com.wsy.array;

public class MaxSubArray {

	public static void main(String[] args) {
		
		int[] nums= {-2,1,-3,4,-1,2,1,-5,4};
		int max=maxSubArray(nums);
		System.out.println("max="+max);
	}
	
	/**
	 * 	找出最大子序列的和 dp[i] 表示以 num[i]为结尾的连续最大子序列
	 * 		dp[i]=max{dp[i-1]+num[i],num[i]};
	 * @param nums
	 * @return
	 */
	public static int maxSubArray(int[] nums) {
		
		int[] dp=new int[nums.length];
		dp[0]=nums[0];
		int res=nums[0];
		for(int i=1;i<dp.length;i++) {
			dp[i]=Math.max(dp[i-1]+nums[i], nums[i]);
			res=Math.max(res,dp[i]);
		}
		/*
		 * int res=dp[0]; for(int i=0;i<dp.length;i++) { res=Math.max(res, dp[i]); }
		 */
		return res;
	}
	
	public static int maxSub(int[] nums) {
		int n = nums.length, maxSum = nums[0];
	    for(int i = 1; i < n; ++i) {
	      if (nums[i - 1] > 0) nums[i] += nums[i - 1];
	      maxSum = Math.max(nums[i], maxSum);
	    }
	    return maxSum;
	}
}
