package com.syw.sort;

import java.util.Arrays;

/**
 * 	�����鿴��һ�����������һ����������
 * 	��һ��ʱ������һ�����������������У�ͬ�������������Ƚϣ�Ȼ����뵽���ʵ�λ��
 * 	��Ҫ�Ƚ�n-1��
 * @author Administrator
 *
 */
public class InsertSort {

	public static void main(String[] args) {
		
		int[] array= {4,3,2,10,12,1,5,6};
		insertSort(array);
	}
	
	public static void insertSort(int[] array) {
		
		for(int i=1;i<array.length;i++) { //�±��1��ʼ��length-1���޷��Ƚ����һ��������
			
			/*����������ȡ��һ����ͬǰ�����������Ƚ�*/
			int insertValue=array[i];
			int insertIndex=i-1; // --->����������ĺ���ǰɨ��͵�ǰ����������ݱȽ�
			/*�����������ĵ�ǰֵ���ڴ���������ݲ��Ҵ������±���ڻ��� ����0*/
			while(insertIndex >= 0 && array[insertIndex] > insertValue) { 
				array[insertIndex+1]=array[insertIndex]; //�����ݺ���
				insertIndex--;
			}
			/*�ҵ���ǰ�������鲻�����ƶ�������������������*/
			array[insertIndex+1]=insertValue;
			System.out.println("��"+i+"�������"+Arrays.toString(array));
		}
	}
}
