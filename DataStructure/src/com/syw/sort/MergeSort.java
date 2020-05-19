package com.syw.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		
		int[] array= {4,3,2,10,12,1,5,12};
		int[] temp=new int[array.length];//临时数组
		mergeSort(array,0,array.length-1,temp);
		System.out.println(Arrays.toString(array));
	}
	
	public static void mergeSort(int[] array,int left,int right,int[] temp) {
		
		if(left >= right) {
			return;
		}
		int mid=(left+right)/2;
		//左递归
		mergeSort(array,left,mid,temp);
		//右递归
		mergeSort(array,mid+1,right,temp);
		//归并
		merge(array,left,mid,right,temp);
	}
	
	/**
	 * @param array 待合并的原始数组
	 * @param left  左
	 * @param mid   中
	 * @param right 右
	 * @param temp 中间数组，保存合并后的数组
	 */
	private static void merge(int[] array,int left,int mid,int right,int[] temp) {
		
		int i=left; //左边有序序列的初始索引
		int j=mid+1; //右边有序序列初始化索引 +1 是因为从中间开始划分，需要加1
		int t=0; //临时数组的小标索引
		/*第一步：比较左右两个有序数据的大小(使用mid为分割符)，复制到新数组中*/
		while(i <= mid && j<=right) {
			if(array[i] <= array[j]) { //左半区的数据小于等于右半区，复制到临时数组
				temp[t++]=array[i++];
			}else {
				temp[t++]=array[j++]; //右半区的数据小于左半区，复制到临时数组
			}
		}
		/*第二步：将有剩余的左右数组的数据复制到新数组中*/
		while(i<=mid) {
			temp[t++]=array[i++];
		}
		while(j<=right) {
			temp[t++]=array[j++];
		}
		/*第三步：将临时数组的数据复制到原始数组中*/
		/*并不是每一次拷贝数组都是原始数组的大小*/
		t=0;
		int tempLeft=left;
		while(tempLeft<=right) { //第一次 tempLeft=0,right=1 ,第二次 2,3 ,第三次0,3
			array[tempLeft++]=temp[t++];
		}
	}
}
