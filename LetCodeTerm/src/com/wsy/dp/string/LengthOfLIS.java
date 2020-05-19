package com.wsy.dp.string;

import java.util.Arrays;

public class LengthOfLIS {

	public static void main(String[] args) {
		
		int[] nums= {10,9,2,5,3,7,101,18};
		int res=lengthOfLIS(nums);
		System.out.println(res);
	}
	
	public static int lengthOfLIS(int[] nums) {
		
		//1������dp[i] ��ʾ�� nums[i] ��β�ġ�����������С��ĳ���,j�ķ�Χ��0-i
		//2��dp[i]=max{dp[i],dp[j]+1} dp[j]+1����ǰһ������Ϊ��jΪ��β�������������
		//3����ʼ��dp[i]=1����Ϊ�Լ����� һ�������������
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
