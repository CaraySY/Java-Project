package com.syw.binary_search_no_recur;

public class BinarySearchNoRecur {

	public static void main(String[] args) {
		
		int[] array= {1,2,4,5,6,7,8};
		int index=binarySearchNoRecur(array,55);
		System.out.println(index);
	}
	
	/**
	 * @param array ԭʼ����
	 * @param target ���ҵĶ���
	 * @return ���ز��ҵ��±꣬�Ҳ���Ϊ -1
	 */
	public static int binarySearchNoRecur(int[] array,int target) {
		
		int left=0;
		int right=array.length-1;
		int mid=-1;
		while(left <= right) { //�� <= �ң�ѭ��ִ��
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
