package com.syw.sort;


public class QuickSort {

	public static void main(String[] args) {
		
		//int[] array= {4,3,12,10,12,1,5,12};
		//quickSort(array,0,array.length-1);
		int[] array=new int[80000000];
		for(int i=0;i<array.length;i++) {
			array[i]=(int)(Math.random()*80000000);
		}
		long start=System.currentTimeMillis();
		quickSort(array,0,array.length-1);
		long end=System.currentTimeMillis();
		System.out.println("���ĵ�ʱ��:"+(end-start)/1000+"s");
		//System.out.println(Arrays.toString(array));
	}
	
	/*ʹ���ڿӷ��Ŀ������򣬵�low��highָ���غϣ���pivot���������һ������Ƚ�*/
	public static void quickSort(int[] array,int left,int right) {
		
		/*�ݹ��������*/
		if(left >= right) {
			return;
		}
		int low=left; // ��λָ��
		int high=right; // ��λָ��
		int pivot=array[low]; // �ؼ���
		while(low < high) {
			while (low < high && array[high] >= pivot) {
				high--;
			}
			/* highָ���ҵ�һ����pivot С����������������array[low]�� lowָ����� */
			if(low < high) { //��֤low < high�����������
				array[low++] = array[high];
			}
			while (low < high && array[low] <= pivot) {
				low++;
			}
			/* lowָ���ҵ�һ����pivot �����������������array[high]����highָ��ǰ�� */
			if(low < high) { //��֤low < high�����������
				array[high--] = array[low];
			}
		}
		/*low��highָ���غϣ���pivot�������*/
		array[low]=pivot;
		//��ݹ�
		quickSort(array,left,low-1);
		//�ҵݹ�
		quickSort(array,low+1,right);
	}
}
