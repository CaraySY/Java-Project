package com.syw.tree;

/**
 * 	  
 * 
 *  �󶥶ѣ�
 *  ÿһ���ڵ����/�����������ӽڵ㣬�����ӽڵ�Ĵ�С�޹�
 *  С���ѣ��෴
 *   *
 *  *  *
 * * * * *
 + + + 
 * @author Administrator
 *
 */
public class HeapSort {
	
	public void heapSort(int[] array) {
		
		int temp=0;
		/*�����ѣ�ʹ������󶥶ѵĶ���:--->��������һ��ķ�Ҷ��[������������/������]��ʼ����--�ҵ���ǰ������ŵ��Ѷ�*/
		for(int i=array.length/2-1;i>=0;i--) {
			adjustHeap(array, i, array.length);
		}
		/*�õ�һ������󶥶������˳������������Ѷ�Ԫ���ƶ���������󣬲��ٴε�����[length--]*/
		for(int j=array.length-1;j>=0;j--) {
			/*����*/
			temp=array[0];
			array[0]=array[j];
			array[j]=temp;
			/*�ѳ��� -1 ���������ѣ�ʹ������󶥶ѵĶ���*/
			//�ӶѶ���ʼ����
			adjustHeap(array,0,j);
		}
	}

	/**
	 * 	�����ѣ���֤�����ѵĵ�ǰ�ڵ���������ӽڵ�[ �󶥶�   ]
	 * @param array ������������
	 * @param i �±�
	 * @param length ����Ĵ�С
	 */
	private static void adjustHeap(int[] array,int i,int length) {
		
		int temp=array[i];
		/*��������һ��ķ�Ҷ�ӽڵ�����ӽڵ㿪ʼ�Ƚ�*/
		for(int k=2*i+1;k<length;k=2*k+1) {
			//��֤ k+1û��Խ��
			if(k+1 < length && array[k] < array[k+1]) { //�����ǰ��ڵ��ֵС���ҽڵ��ֵ���ƶ�ָ��ָ���ҽڵ�
				k++;
			}
			if(array[k] > temp) { //ָ��ָ��Ľڵ�����丸�׽ڵ㣬��Ҫ����
				array[i]=array[k]; //�ӽڵ���ڸ��ڵ㣬����
				i=k; //���¼���������
			}else {
				break;
			}
		}
		/*ѭ�������� ��   �±�Ϊi�ĸ��ڵ���������ֵ�������˵�ǰλ�õĶѶ�*/
		array[i]=temp;
	}
}
