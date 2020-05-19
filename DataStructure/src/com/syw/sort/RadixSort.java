package com.syw.sort;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		
		int[] array= {53,3,542,748,14,214};
		radixSort(array);
	}
	
	/**
	 * 	��������(Ͱ����)����˼�룬����10��Ͱ[0-9]��ÿһ��Ͱ������Ӧ��Ϊ����������ĳ��� 
	 * 		����bucket[10][array.length]
	 *  ��������������ִκ�������ĸ����йأ�5λ������5��...etc.
	 *  ���ո����ĸ�λ��ʮλ����λ����Ͱ��[����125����һ�������У������±�Ϊ5��Ͱ���ڶ��ַ����±�Ϊ2��Ͱ,�����ַ����±�Ϊ1��Ͱ]
	 *  	ʹ��һ������һλ�����¼ÿһ��Ͱ�ж��ٸ����� bucketElementCount[size]--->sizeΪͰ�ĸ���
	 *   �ʼ��Ҫ�ҳ�����������������
	 * @param array
	 */
	public static void radixSort(int[] array) {
		
		int bucket[][]=new int[10][array.length]; //����Ͱ
		int[] bucketElementCount=new int[10]; //��¼ÿ��Ͱ�з����Ԫ�صĸ���
		int max=getMax(array);
		//��ȡ���ֵ�λ��
		int length=(max+"").length();
		for(int i=0,n=1;i<length;i++,n*=10) {
			/*��i������*/
			for(int j=0;j<array.length;j++) {
				int digital=array[j] / n % 10;//�����ȡ��λ��
				//����Ͱ��--> ����ǰ�����ݷ����뵱ǰλ����ֵ��ŵ�Ͱ��
				bucket[digital][bucketElementCount[digital]]=array[j]; 
				bucketElementCount[digital]++;//���±��Ͱ��Ԫ�ظ��� ++
			}
			int index=0;//������¼ԭʼ������±�
			//�Ż�ԭʼ��������-->��ÿһ��Ͱ��ȡ�����ݣ������Ͱ��bucketElementCount==0 -->��Ͱ������
			for(int k=0;k<bucketElementCount.length;k++) {
				if(bucketElementCount[k]!=0) { //�ӵ�0��Ͱ��ʼ��������9��Ͱ����
					for(int z=0;z<bucketElementCount[k];z++) { //ȡ���� [k] ��Ͱ�еĵ� [Z] �����ݷ���ԭʼ������ 
						array[index++]=bucket[k][z];
					}
					bucketElementCount[k]=0; //��Ͱ�е������Ѿ����Ƶ�ԭʼ�����У���ո���
				}
			}
			
			System.out.println("��"+(i+1)+"�������"+Arrays.toString(array));
		}
	}
	
	private static int getMax(int[] array) {
		
		int max=array[0];
		for(int i=1;i<array.length;i++) {
			if(array[i] > max) {
				max=array[i];
			}
		}
		return max;
	}
}
