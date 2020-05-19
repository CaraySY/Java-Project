package com.syw.sort;

import java.util.Arrays;

public class SortAlgorithm{
	

	public static void main(String[] args) {
		
		int[] array=new int[10];
		for(int i=0;i<array.length;i++) {
			array[i]=(int)(Math.random()*100);
		}
		System.out.println(Arrays.toString(array));
		//bubbleSort(array);
		quickSort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}
	
	//冒泡
	public static void bubbleSort(int[] array) {
		
		boolean flag=false;
		int temp=-1; // 临时变量
		for(int i=0;i<array.length-1;i++) {
			for(int j=0;j<array.length-i-1;j++) {
				if(array[j]>array[j+1]) {
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
					flag=true; //有过排序
				}
			}
			// 如果一趟后没有标志位变化
			if(!flag) {
				break;
			}else {
				flag=false;
			}
		}
	}
	
	//快排
	public static void quickSort(int[] array,int left,int right) {
		
		//递归结束
		if(left >= right){
			return;
		}
		int low=left;
		int high=right;
		int pivot=array[low];
		while(low < high) {
			//最右边开始扫描
			while(low < high && array[high] >= pivot) {
				high--;
			}
			// 挖坑
			if(low < high) {
				array[low++]=array[high];
			}
			//最左边开始扫描
			while(low < high && array[low] <= pivot) {
				low++;
			}
			// 挖坑
			if(low < high) {
				array[high--]=array[low];
			}
		}
		//填坑
		array[low]=pivot;// 此时 low==high
		//左递归
		quickSort(array,left , low-1);
		//右递归
		quickSort(array,low+1 , right);
	}
}
