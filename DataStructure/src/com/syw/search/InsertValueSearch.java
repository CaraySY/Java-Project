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
	 * @param left ��ָ��
	 * @param right ��ָ��
	 * @param findVal �����ҵ���
	 * @return �ҵ��±�
	 */
	public static int insertValueSearch(int[] array,int left,int right,int findVal) {
		
		/*�ݹ�����������������Ż��㷨����ֹ�����ҵ������󣬵������������Ӧ�±��쳣*/
		if(left > right || findVal < array[0] || findVal > array[array.length-1]) {
			return -1;
		}
		/*����Ӧ�±�*/
		//��ֵ���Һ��Ĺ�ʽ
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
