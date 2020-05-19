package com.syw.binary_search_no_recur;

public class BinarySearchNoRecur {

	public static void main(String[] args) {
		
		int[] array= {1,2,4,5,6,7,8};
		int index=binarySearchNoRecur(array,55);
		System.out.println(index);
	}
	
	/**
	 * @param array 原始数组
	 * @param target 查找的对象
	 * @return 返回查找的下标，找不到为 -1
	 */
	public static int binarySearchNoRecur(int[] array,int target) {
		
		int left=0;
		int right=array.length-1;
		int mid=-1;
		while(left <= right) { //左 <= 右，循环执行
			mid=(left + right) / 2;
			if(target==array[mid]) {
				return mid;
			}else if(target > array[mid]) {
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		return -1;
	}
}
