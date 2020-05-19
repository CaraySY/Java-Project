package com.syw.sort;


public class ShellSort {

	private static int count=0;//����ƽϵ�����

	public static void main(String[] args) {
		
		//int[] array= {8,9,1,7,2,3,5,4,6,0};
		/*int[] array=new int[80000];
		for(int i=0;i<array.length;i++) {
			array[i]=(int)(Math.random()*80000);
		}
		long start=System.currentTimeMillis();
		swap_shellSort(array);
		long end=System.currentTimeMillis();
		System.out.println("���ĵ�ʱ��:"+(end-start)/1000+"s");
		System.out.println("count="+count);*/
		int[] array=new int[80000000];
		for(int i=0;i<array.length;i++) {
			array[i]=(int)(Math.random()*80000000);
		}
		long start=System.currentTimeMillis();
		move_shellSort(array);
		long end=System.currentTimeMillis();
		System.out.println("���ĵ�ʱ��:"+(end-start)/1000+"s");
		System.out.println("count="+count);
		//System.out.println(Arrays.toString(array)+" ��������"+count);
	}
	
	/**
	 * 	shell[������]������Ҫ����gap ����[����]
	 * 	gap=array.length/2
	 * 	gap=gap/2
	 * 	gap(����)��Ҫ���ڻ��ߵ���1
	 * 
	 * 	��������shell���򻨷Ѵ���ʱ���ڽ���
	 * @param array
	 */
	public static void swap_shellSort(int[] array) {
		
		int	temp=0;
		for (int gap = array.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < array.length; i++) {
				for (int j = i - gap; j >= 0; j -= gap) {
					if (array[j] > array[j + gap]) {
						temp = array[j];
						array[j] = array[j + gap];
						array[j + gap] = temp;
					}
				}
			}
			count++;
		}
	}
	
	/**
	 * 	ʹ����λ���Ľ� ��������shell����
	 *  ��������
	 * @param array
	 */
	public static void move_shellSort(int[] array) {
		
		int index=-1;//���������ݵ��±�
		int temp=-1;//�����������
		for (int gap = array.length / 2; gap > 0; gap /= 2) {
			for(int i=gap;i<array.length;i++) {
				index=i;
				temp=array[index];
				if(array[index] < array[index-gap]) { //�����������С��ǰ�������
					while(index-gap >= 0 && temp < array[index-gap]) { //ǰ������ݺ���
						array[index]=array[index-gap]; //����
						index=index-gap; // index ���ռ�ȥ�����ı�
					}
				}
				//���뵽array[index]
				array[index]=temp;
			}
			count++;
		}
	}
}
