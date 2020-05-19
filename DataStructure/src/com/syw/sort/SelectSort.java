package com.syw.sort;


/**
 * 	ѡ������һ���� array.length-1 ������
 * 	ÿ��������һ��xunhuan
 * 	���ȼٶ���ǰ������С��
 * 	Ȼ��ͺ����ÿ�������бȽϣ���������бȵ�ǰ����С������
 * ������ȷ����С�������õ���С���±�
 * 	��������������󣬾͵õ�������С�����±�
 * 	
 * @author Administrator
 *
 */
public class SelectSort {

	public static void main(String[] args) {
		
		//int[] array={3,9,-1,10,20};
	/*
	 * int[] array={1,2,3,4,5}; System.out.println("����ǰ��"+Arrays.toString(array));
	 * selectSort(array); }
	 */
		
		int[] array=new int[80000];
		for(int i=0;i<array.length;i++) {
			array[i]=(int)(Math.random()*80000);
		}
		long start=System.currentTimeMillis();
		selectSort(array);
		long end=System.currentTimeMillis();
		System.out.println("���ĵ�ʱ��:"+(end-start)/1000+"s");
	}
	public static void selectSort(int[] array) {
		
		for(int i=0;i<array.length-1;i++) {
			
			int min=array[i];//�ٶ���С���ǵ�ǰ��
			int minIndex=i;//��С���±��ǵ�ǰ��С��
			for(int j=i+1;j<array.length;j++) { //�ٶ��ĵ�ǰ��С���͵�ǰ��С������һ�����Ƚ�[ֱ�����һ����]
				if(min > array[j]) {
					min=array[j];
					minIndex=j;
				}
			}
			if(minIndex!=i) { //�����С���±�û�иı䣬����Ҫ����
				array[minIndex]=array[i]; //��array[i]��minIndexС���ֵ����
				array[i]=min;
			}
		}
	}
}
