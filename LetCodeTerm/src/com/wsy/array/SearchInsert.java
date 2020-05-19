package com.wsy.array;

import java.util.Arrays;

public class SearchInsert {

	public static void main(String[] args) {
		
		int[] array= {1,3,5,6};
		int index=searchInsert(array,0);
		System.out.println(index);
		int[] nums= {9,2,5,14,-7,-5};
		quickSort(nums, 0, nums.length-1);
		System.out.println(Arrays.toString(nums));
	}
	
	public static int searchInsert(int[] nums, int target) {

		int left=0;
		int right=nums.length-1;
		while(left<=right) {
			int mid=(left+right)/2;
			if(nums[mid]==target) {
				return mid;
			}else if(nums[mid] > target) {
				right=mid-1;
			}else {
				left=mid+1;
			}
		}
		int index=0;
		int j=0;
		while(j<nums.length) {
			if(nums[j] < target) {
				j++;
			}
			if(j<nums.length && nums[j] > target) {
				break;
			}
		}
		index=j;
		return index;
    }
	
	public static void quickSort(int[] nums,int left,int right) {
		
		if(left >  right) { //left 大于 right 递归返回
			return;
		}
		int low=left;
		int high=right;
		int pivot=nums[low];//取第一个
		while(low < high) {
			
			while(low < high && nums[high] >= pivot) {
				high--;
			}
			if(low < high) {
				nums[low]=nums[high];
				low++;//指针移动
			}
			while(low < high && nums[low] <= pivot) {
				low++;
			}
			if(low < high) {
				nums[high]=nums[low];
				high--;
			}
		}
		nums[low]=pivot;
		//左递归
		quickSort(nums,left,low-1);
		//右递归
		quickSort(nums,low+1,high);
	}
}
