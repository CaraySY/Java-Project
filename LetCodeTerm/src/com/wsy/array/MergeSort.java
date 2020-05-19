package com.wsy.array;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		
		int[] array= {4,3,2,10,12,1,5,12};
		int[] temp=new int[array.length];//临时数组
		mergeSort(array,0,array.length-1,temp);
		System.out.println(Arrays.toString(array));
	}
	
	public static void mergeSort(int[] nums,int left,int right,int[] temp) {
		if(left >= right) {
			return;
		}
		int mid=(left+right)/2;
		//左递归
		mergeSort(nums,left,mid,temp);
		//右递归
		mergeSort(nums,mid+1,right,temp);
		//合并
		merge(nums,left,mid,right,temp);
	}
	
	/**
	 * 	归并排序的核心是归并
	 * @param nums 原始数组
	 * @param left 左指针
	 * @param mid 
	 * @param right 右指针
	 * @param temp 中间数组,大小和nums一样
	 */
	private static void merge(int[] nums,int left,int mid,int right,int[] temp) {
		
		int i=left;
		int j=mid+1;
		//比较初始数组的左右，并复制到temp中
		//
		int t=0;//指向temp数组
		while(i<=mid && j<=right) {
			if(nums[i]<nums[j]) {
				temp[t++]=nums[i++];
			}else {
				temp[t++]=nums[j++];
			}
		}
		/*复制前后数组剩余部分到temp中*/
		while(i<=mid) {
			temp[t++]=nums[i++];
		}
		while(j<=right) {
			temp[t++]=nums[j++];
		}
		//将temp的数据复制到原始数组中
		t=0;//指针归零
		//刚开始，temp只有 0 1-- 2 3 --- 0-3 个数据，不会影响原始数组的数据
		int real=left; //原始数组下标0-1 2-3 0-3根据递归不断变化
		while(real<=right) {
			nums[real++]=temp[t++];
		}
	}
}
