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
	
	//ð��
	public static void bubbleSort(int[] array) {
		
		boolean flag=false;
		int temp=-1; // ��ʱ����
		for(int i=0;i<array.length-1;i++) {
			for(int j=0;j<array.length-i-1;j++) {
				if(array[j]>array[j+1]) {
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
					flag=true; //�й�����
				}
			}
			// ���һ�˺�û�б�־λ�仯
			if(!flag) {
				break;
			}else {
				flag=false;
			}
		}
	}
	
	//����
	public static void quickSort(int[] array,int left,int right) {
		
		//�ݹ����
		if(left >= right){
			return;
		}
		int low=left;
		int high=right;
		int pivot=array[low];
		while(low < high) {
			//���ұ߿�ʼɨ��
			while(low < high && array[high] >= pivot) {
				high--;
			}
			// �ڿ�
			if(low < high) {
				array[low++]=array[high];
			}
			//����߿�ʼɨ��
			while(low < high && array[low] <= pivot) {
				low++;
			}
			// �ڿ�
			if(low < high) {
				array[high--]=array[low];
			}
		}
		//���
		array[low]=pivot;// ��ʱ low==high
		//��ݹ�
		quickSort(array,left , low-1);
		//�ҵݹ�
		quickSort(array,low+1 , right);
	}
}
