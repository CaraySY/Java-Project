package com.syw.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 	二分查找法，待查询的数组必须是有序的
 * @author Administrator
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		/*需要查找出所有数据为 8 的下标*/
		int[] array= {1,3,5,8,8,8,9,74};
		List<Integer> list= binarySearch(array,0,array.length-1,8);
		if(list.size()>0) {
			System.out.println("查到到的下标:"+list.toString());
		}else {
			System.out.println("找不到该数据。。。");
		}
	}
	
	/**
	 * 	
	 * @param array 从该数组查到--> data
	 * @param left low指针
	 * @param right high指针
	 * @param data 查找的数组
	 * @return 返回 找的数组下标，找不到返回-1
	 */
	public static List<Integer> binarySearch(int[] array,int left,int right,int data) {
		
		if(left > right) {
			return new ArrayList<Integer>();//可以left=right--->到达数组最后一个位置
		}
		int midIndex=(left+right)/2;
		int midVal=array[midIndex];
		if(data>midVal) { //右递归
			return binarySearch(array,midIndex+1,right,data);
		}else if(data < midVal) {
			return  binarySearch(array,left,midIndex-1,data);
		}else {
			
			List<Integer> list= getReapeatIndex(midIndex,array,data);
			return list;
		}
	}
	
	/**
	 * 	
	 * @param midIndex 查找到一第一个数的下标
	 * @param array
	 * @return 返回所有需要查找的数的下标
	 */
	private static List<Integer> getReapeatIndex(int midIndex,int[] array,int data){
		
		List<Integer> list=new ArrayList<>();
		list.add(midIndex);
		//向左查找
		int tempIndex=midIndex-1;
		while(true) {
			if(tempIndex < 0 || array[tempIndex]!=data) {
				break;
			}
			list.add(tempIndex);
			tempIndex--;
		}
		//向右查找
		tempIndex=midIndex+1;
		while(true) {
			if(tempIndex > array.length-1 || array[tempIndex]!=data) {
				break;
			}
			list.add(tempIndex);
			tempIndex++;
		}
		return list;
	}
}
