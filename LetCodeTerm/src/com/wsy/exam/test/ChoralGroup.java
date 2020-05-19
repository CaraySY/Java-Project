package com.wsy.exam.test;

import java.util.Arrays;
import java.util.Scanner;

public class ChoralGroup {

	public static void main(String[] args) {
		
		Scanner keyboard=new Scanner(System.in);
		int s;
		int[] nums;
		while(keyboard.hasNext()) {
			s=keyboard.nextInt();
			nums=new int[s];
			for(int i=0;i<nums.length;i++) {
				nums[i]=keyboard.nextInt();
			}
			longestUpperSequence(nums);
		}
		keyboard.close();
	}
	
	/**
	 * 	两遍最长递增子序列，从前->后 后->前，相加减一，前后遍历时自己和 自己重复，减 1
	 * @param nums
	 * @return
	 */
	public static void longestUpperSequence(int[] nums) {
		
		//1、定义dp[i]为以 nums i  为结尾最长递增数
		//2、if:nums[i]>nums[j] (0<=j<i) max(dp[i],dp[j]+1)
		//3、nums[x]=1
		int[] left_dp=new int[nums.length];
		Arrays.fill(left_dp, 1);
		for(int i=1;i<left_dp.length;i++) {
			for(int j=0;j<i;j++) {
				if(nums[i]>nums[j]) { //
					left_dp[i]=Math.max(left_dp[i], left_dp[j]+1);
				}
			}
		}
		int[] right_dp=new int[nums.length];
		Arrays.fill(right_dp , 1);
		for(int i=nums.length-2;i>=0;i--) {
			for(int j=nums.length-1;j>i;j--) {
				if(nums[i]>nums[j]) { //
					right_dp[i]=Math.max(right_dp[i], right_dp[j]+1);
				}
			}
		}
		int max=-1;
		int sum=0;
		for(int i=0;i<left_dp.length;i++) {
			sum=left_dp[i]+right_dp[i];
			if(sum>max) {
				max=sum;
			}
		}
		System.out.println(nums.length-max+1);
	}
}
