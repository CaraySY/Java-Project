package com.syw.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		
		int[] array= {4,3,2,10,12,1,5,12};
		int[] temp=new int[array.length];//��ʱ����
		mergeSort(array,0,array.length-1,temp);
		System.out.println(Arrays.toString(array));
	}
	
	public static void mergeSort(int[] array,int left,int right,int[] temp) {
		
		if(left >= right) {
			return;
		}
		int mid=(left+right)/2;
		//��ݹ�
		mergeSort(array,left,mid,temp);
		//�ҵݹ�
		mergeSort(array,mid+1,right,temp);
		//�鲢
		merge(array,left,mid,right,temp);
	}
	
	/**
	 * @param array ���ϲ���ԭʼ����
	 * @param left  ��
	 * @param mid   ��
	 * @param right ��
	 * @param temp �м����飬����ϲ��������
	 */
	private static void merge(int[] array,int left,int mid,int right,int[] temp) {
		
		int i=left; //����������еĳ�ʼ����
		int j=mid+1; //�ұ��������г�ʼ������ +1 ����Ϊ���м俪ʼ���֣���Ҫ��1
		int t=0; //��ʱ�����С������
		/*��һ�����Ƚ����������������ݵĴ�С(ʹ��midΪ�ָ��)�����Ƶ���������*/
		while(i <= mid && j<=right) {
			if(array[i] <= array[j]) { //�����������С�ڵ����Ұ��������Ƶ���ʱ����
				temp[t++]=array[i++];
			}else {
				temp[t++]=array[j++]; //�Ұ���������С������������Ƶ���ʱ����
			}
		}
		/*�ڶ���������ʣ���������������ݸ��Ƶ���������*/
		while(i<=mid) {
			temp[t++]=array[i++];
		}
		while(j<=right) {
			temp[t++]=array[j++];
		}
		/*������������ʱ��������ݸ��Ƶ�ԭʼ������*/
		/*������ÿһ�ο������鶼��ԭʼ����Ĵ�С*/
		t=0;
		int tempLeft=left;
		while(tempLeft<=right) { //��һ�� tempLeft=0,right=1 ,�ڶ��� 2,3 ,������0,3
			array[tempLeft++]=temp[t++];
		}
	}
}
