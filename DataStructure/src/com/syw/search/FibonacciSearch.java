package com.syw.search;

import java.util.Arrays;

/**
 * 	쳲��������� Fn = F��n-1�� + F(n-2) [ n >= 2]
 *  	1,1,2,3,5,8,13..
 *  �����µĲ�������arrNewԪ�ظ�����m = F(n)-1�������� m ���ڵ��� n����F(n)-1 >= n
 *  ȡF(k)-1��ԭ��F(k)-1= F(k-1)-1 + F(k-2)-1 + һ��������
 * ��Ϊ���ȣ�f(n-1)-1��f(n-2)-1
 *   |<-               f(n)-1          ->|
 *  low                   (mid)           high (������midֵ)
 *   [----------------------*------------]
 *   |<-     f(n-1)-1     ->|<-f(n-2)-1->|  
 *  ����ʽ�����Ƴ��� ֻҪ˳���ĳ��� Ϊ->Fn - 1 
 *  	-->[ �����±���㿪ʼ ]
 *  		 -->F(n)=F(n-1)+F(n-2)
 *  			  -->F(n)-1=[F(n-1)-1]+[F(n-2)-1] + 1[λ������mid]
 *  						(F(n)-2=[F(n-1)-1]+[F(n-2)-1]) ʵ�ָ�ʽ�ϵ�ͬһ
 *  				  --> mid= low + F(n-1)-1
 * @author Administrator
 *
 */
public class FibonacciSearch {

	private static int maxSize=20;
	
	public static void main(String[] args) {
		
		int[] array= {1,8,10,89,1000,1234};
		int index=fibSearch(array,1234);
		System.out.println(index);
	}
	
	/**
	 * 	����ĳ��ȱ��뱣֤Ϊ  <= f(k)-1
	 * @param array
	 */
	public static int fibSearch(int[] array,int findVal) {
		
		int low=0;
		int high=array.length-1;
		int k=0;//쳲��������е��±�
		int f[]=fib();
		while(array.length > f[k]-1) {
			k++;
		}
		//���Ƶ��������У���֤������ҵ����鳤�� <= fk -1
		int[] temp=Arrays.copyOf(array, f[k]);  //����Ļ��Զ���� 0
		/*ʵ�ʲ�����ҵ�����Ҳ��Ҫʱ����ģ������ ����β��Ӧ��ͬ���һλ��ͬ*/
		for(int i=high+1;i<temp.length;i++) {
			temp[i]=array[high];
		}
		/*��ʼ����*/
		while(low <= high) {
			//��ȡmid�±�
			int mid=low+f[k-1]-1;
			if(temp[mid] > findVal) { //Ӧ����ǰ���� (ǰ�벿����Ϊ f[k-1]-1)
				high=mid-1;
				k--;  //���� f[k-1]=f[k-1-_1_]+f[k-2-_1_] ����֪����k����1
			}else if(temp[mid] < findVal) { //Ӧ��������  (��벿����Ϊ f[k-2]-1)
				low=mid+1;
				k-=2; //���� f[k-2]=f[k-1-_2_]+f[k-2-_2_] ����֪����k����2
			}else {
				if(mid <=high) { //��Ϊ���ص�ʵ���������������±꣬�������ҵ��±�������Ҫ�ж� 
					return mid;
				}else {
					return high;
				}
			}
		}
		return -1;//�Ҳ�������
	}
	
	private static int[] fib() {
		
		int[] array=new int[maxSize];
		array[0]=1;
		array[1]=1;
		for(int i=2;i<array.length;i++) {
			array[i]=array[i-1]+array[i-2];
		}
		return array;
	}
	
}
