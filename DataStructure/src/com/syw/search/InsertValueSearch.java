package com.syw.search;

public class InsertValueSearch {

	public static void main(String[] args) {
		
		int[] array= {1,3,50,88,269,888,1000,7400};
		int index = insertValueSearch(array,0,array.length-1,7400);
		if(index!=-1) {
			System.out.println("index:"+index);
		}else {
			System.out.println("NoFoundException...");
		}
	}
	
	/**
	 * 	
	 * @param array
	 * @param left 左指针
	 * @param right 右指针
	 * @param findVal 待查找的数
	 * @return 找的下标
	 */
	public static int insertValueSearch(int[] array,int left,int right,int findVal) {
		
		/*递归结束条件不仅仅是优化算法，防止待查找的数过大，导致算出的自适应下标异常*/
		if(left > right || findVal < array[0] || findVal > array[array.length-1]) {
			return -1;
		}
		/*自适应下标*/
		//插值查找核心公式
		int mid=left+(right-left)*(findVal-array[left])/(array[right]-array[left]);
		int midVal=array[mid];
		if(findVal > midVal) {
			return insertValueSearch(array,mid+1,right,findVal);
		}else if(findVal < midVal) {
			return insertValueSearch(array,mid+1,right,findVal);
		}else {
			return mid;
		}
	}
}
