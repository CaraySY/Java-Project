package com.syw.search;

import java.util.Arrays;

/**
 * 	斐波那契数列 Fn = F（n-1） + F(n-2) [ n >= 2]
 *  	1,1,2,3,5,8,13..
 *  构建新的查找序列arrNew元素个数：m = F(n)-1，需满足 m 大于等于 n，即F(n)-1 >= n
 *  取F(k)-1的原因：F(k)-1= F(k-1)-1 + F(k-2)-1 + 一个查找数
 * 分为长度：f(n-1)-1和f(n-2)-1
 *   |<-               f(n)-1          ->|
 *  low                   (mid)           high (不包括mid值)
 *   [----------------------*------------]
 *   |<-     f(n-1)-1     ->|<-f(n-2)-1->|  
 *  由上式可以推出： 只要顺序表的长度 为->Fn - 1 
 *  	-->[ 数组下标从零开始 ]
 *  		 -->F(n)=F(n-1)+F(n-2)
 *  			  -->F(n)-1=[F(n-1)-1]+[F(n-2)-1] + 1[位置留给mid]
 *  						(F(n)-2=[F(n-1)-1]+[F(n-2)-1]) 实现格式上的同一
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
	 * 	数组的长度必须保证为  <= f(k)-1
	 * @param array
	 */
	public static int fibSearch(int[] array,int findVal) {
		
		int low=0;
		int high=array.length-1;
		int k=0;//斐波那契数列的下标
		int f[]=fib();
		while(array.length > f[k]-1) {
			k++;
		}
		//复制到新数组中，保证参与查找的数组长度 <= fk -1
		int[] temp=Arrays.copyOf(array, f[k]);  //多余的会自动填充 0
		/*实际参与查找的数组也需要时有序的，多余的 数在尾部应该同最后一位相同*/
		for(int i=high+1;i<temp.length;i++) {
			temp[i]=array[high];
		}
		/*开始查找*/
		while(low <= high) {
			//获取mid下标
			int mid=low+f[k-1]-1;
			if(temp[mid] > findVal) { //应该向前查找 (前半部长度为 f[k-1]-1)
				high=mid-1;
				k--;  //根据 f[k-1]=f[k-1-_1_]+f[k-2-_1_] 可以知道，k减少1
			}else if(temp[mid] < findVal) { //应该向后查找  (后半部长度为 f[k-2]-1)
				low=mid+1;
				k-=2; //根据 f[k-2]=f[k-1-_2_]+f[k-2-_2_] 可以知道，k减少2
			}else {
				if(mid <=high) { //因为返回的实际是扩充后的数组下标，返回最右的下标会出错，需要判断 
					return mid;
				}else {
					return high;
				}
			}
		}
		return -1;//找不到数据
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
