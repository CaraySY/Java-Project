package com.syw.sort;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		
		int[] array= {53,3,542,748,14,214};
		radixSort(array);
	}
	
	/**
	 * 	基数排序(桶排序)核心思想，创建10个桶[0-9]，每一个桶的容量应该为待排序数组的长度 
	 * 		即：bucket[10][array.length]
	 *  基数排序的排序轮次和最大数的个数有关：5位数，排5轮...etc.
	 *  按照给数的个位、十位、百位放入桶中[例：125，第一轮排序中，放入下标为5的桶，第二轮放入下标为2的桶,第三轮放入下标为1的桶]
	 *  	使用一个辅助一位数组记录每一个桶有多少个数据 bucketElementCount[size]--->size为桶的个数
	 *   最开始需要找出待排序数组的最大数
	 * @param array
	 */
	public static void radixSort(int[] array) {
		
		int bucket[][]=new int[10][array.length]; //定义桶
		int[] bucketElementCount=new int[10]; //记录每个桶中放入的元素的个数
		int max=getMax(array);
		//获取数字的位数
		int length=(max+"").length();
		for(int i=0,n=1;i<length;i++,n*=10) {
			/*第i轮排序*/
			for(int j=0;j<array.length;j++) {
				int digital=array[j] / n % 10;//求余获取个位数
				//放入桶中--> 将当前的数据放入与当前位数的值标号的桶中
				bucket[digital][bucketElementCount[digital]]=array[j]; 
				bucketElementCount[digital]++;//该下标的桶中元素个数 ++
			}
			int index=0;//用来记录原始数组的下标
			//放回原始的数组中-->从每一个桶中取出数据，如果该桶的bucketElementCount==0 -->该桶无数据
			for(int k=0;k<bucketElementCount.length;k++) {
				if(bucketElementCount[k]!=0) { //从第0个桶开始遍历到第9个桶结束
					for(int z=0;z<bucketElementCount[k];z++) { //取出第 [k] 个桶中的第 [Z] 个数据放入原始数组中 
						array[index++]=bucket[k][z];
					}
					bucketElementCount[k]=0; //该桶中的数据已经复制到原始数组中，清空个数
				}
			}
			
			System.out.println("第"+(i+1)+"轮排序后："+Arrays.toString(array));
		}
	}
	
	private static int getMax(int[] array) {
		
		int max=array[0];
		for(int i=1;i<array.length;i++) {
			if(array[i] > max) {
				max=array[i];
			}
		}
		return max;
	}
}
