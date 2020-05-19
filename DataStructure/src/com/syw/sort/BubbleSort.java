package com.syw.sort;

//import java.util.Arrays;

/**
 * [ֻ��Ҫ���� n-1������]
 * 	ð�����򣬵�һ�˽���������������� ��Ҫ���� n-1-0������
 * 		        ��X����Ҫ���� n-1-(X-1)��
 * 	ÿһ�����򶼻�ȷ��һ����ǰ�����������ŵ����棬������һ�ν����Ĺ���
 * @author Administrator
 *
 */
public class BubbleSort {

	//private static int[] array= {3,9,-1,10,-2};
	//private static int[] array= {3,9,-1,10,20};
	
	
	public static void bubbleSort(int[] array) {
		
		int temp=-1;//��ʱ����
		/*�Ż�ð�����򣬵�һ�����û�з����������������Ѿ�����������к���Ľ���*/
		boolean flag=false;
		for(int i=0;i<array.length-1;i++) {
			for(int j=0;j<array.length-1-i;j++) {
				if(array[j]>array[j+1]) {
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
					flag=true;//��������û���������
				}
			}
			//System.out.printf("��  %d ���������\n",(i+1));
			//System.out.println(Arrays.toString(array));
			if(!flag) { //��һ����������Ѿ�����ã�����Ҫ���к�����������
				break;
			}else {
				flag=false; //�����´��ж�
			}
		}
	}
	
	public static void main(String[] args) {
		
		int[] array=new int[80000];
		for(int i=0;i<array.length;i++) {
			array[i]=(int)(Math.random()*80000);
		}
		long start=System.currentTimeMillis();
		bubbleSort(array);
		long end=System.currentTimeMillis();
		System.out.println("���ĵ�ʱ��:"+(end-start)/1000+"s");
	}
}
