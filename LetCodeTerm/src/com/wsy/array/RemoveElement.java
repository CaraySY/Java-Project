package com.wsy.array;

public class RemoveElement {

	public static void main(String[] args) {
		
		int[] nums={3,2,2,3};
		int count=removeElement(nums, 3);
		System.out.println(count);
	}
	
	/**
	 * 	 
	 * @param nums 原始数组
	 * @param val 需要移除的数字
	 * @return 数组的长度
	 */
	public static int removeElement(int[] nums,int val) {
		
		if(nums==null || nums.length==0) {
			return 0;
		}
		int index=0;//每次遍历取出一个数字，同时设置一个下标 ans，不相同就复制拷贝
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=val) {
				nums[index++]=nums[i]; //相当于两个数组，index操作另一个，出现val和数组相同的
				//将数字复制到index指向的数组。。
			}
		}
		return index;
	}
}
