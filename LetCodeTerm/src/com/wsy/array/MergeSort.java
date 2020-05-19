package com.wsy.array;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		
		int[] array= {4,3,2,10,12,1,5,12};
		int[] temp=new int[array.length];//��ʱ����
		mergeSort(array,0,array.length-1,temp);
		System.out.println(Arrays.toString(array));
	}
	
	public static void mergeSort(int[] nums,int left,int right,int[] temp) {
		if(left >= right) {
			return;
		}
		int mid=(left+right)/2;
		//��ݹ�
		mergeSort(nums,left,mid,temp);
		//�ҵݹ�
		mergeSort(nums,mid+1,right,temp);
		//�ϲ�
		merge(nums,left,mid,right,temp);
	}
	
	/**
	 * 	�鲢����ĺ����ǹ鲢
	 * @param nums ԭʼ����
	 * @param left ��ָ��
	 * @param mid 
	 * @param right ��ָ��
	 * @param temp �м�����,��С��numsһ��
	 */
	private static void merge(int[] nums,int left,int mid,int right,int[] temp) {
		
		int i=left;
		int j=mid+1;
		//�Ƚϳ�ʼ��������ң������Ƶ�temp��
		//
		int t=0;//ָ��temp����
		while(i<=mid && j<=right) {
			if(nums[i]<nums[j]) {
				temp[t++]=nums[i++];
			}else {
				temp[t++]=nums[j++];
			}
		}
		/*����ǰ������ʣ�ಿ�ֵ�temp��*/
		while(i<=mid) {
			temp[t++]=nums[i++];
		}
		while(j<=right) {
			temp[t++]=nums[j++];
		}
		//��temp�����ݸ��Ƶ�ԭʼ������
		t=0;//ָ�����
		//�տ�ʼ��tempֻ�� 0 1-- 2 3 --- 0-3 �����ݣ�����Ӱ��ԭʼ���������
		int real=left; //ԭʼ�����±�0-1 2-3 0-3���ݵݹ鲻�ϱ仯
		while(real<=right) {
			nums[real++]=temp[t++];
		}
	}
}
