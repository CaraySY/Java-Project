package com.wsy.dp.string;

import java.util.Arrays;

public class LengthOfLIS {

	public static void main(String[] args) {
		
		int[] nums= {10,9,2,5,3,7,101,18};
		int res=lengthOfLIS(nums);
		System.out.println(res);
	}
	
	public static int lengthOfLIS(int[] nums) {
		
		//1、定义dp[i] 表示以 nums[i] 结尾的“最长上升子序列”的长度,j的范围从0-i
		//2、dp[i]=max{dp[i],dp[j]+1} dp[j]+1代表前一个数最为以j为结尾的最长递增数长度
		//3、初始化dp[i]=1，因为自己就是 一个最长上升子序列
		int[] dp=new int[nums.length];
		Arrays.fill(dp,1);
		for(int i=1;i<dp.length;i++) {
			for(int j=0;j<i;j++) {
				if(nums[i]>nums[j]) {
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
		}
		 int res = 0;
	        for (int i = 0; i < dp.length; i++) {
	            res = Math.max(res, dp[i]);
	        }
	        return res;
	}
}
