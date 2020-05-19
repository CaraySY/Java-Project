package com.syw.sort;

import java.util.Arrays;

/**
 * 	将数组看成一个有序数组和一个无序数组
 * 	第一轮时，将第一个数放在有序数组中，同后面的无序数组比较，然后插入到合适的位置
 * 	需要比较n-1轮
 * @author Administrator
 *
 */
public class InsertSort {

	public static void main(String[] args) {
		
		int[] array= {4,3,2,10,12,1,5,6};
		insertSort(array);
	}
	
	public static void insertSort(int[] array) {
		
		for(int i=1;i<array.length;i++) { //下标从1开始，length-1就无法比较最后一个数据了
			
			/*从无序数组取出一个数同前面的有序数组比较*/
			int insertValue=array[i];
			int insertIndex=i-1; // --->从有序数组的后部向前扫描和当前待插入的数据比较
			/*如果有序数组的当前值大于代插入的数据并且代插入下标大于或者 等于0*/
			while(insertIndex >= 0 && array[insertIndex] > insertValue) { 
				array[insertIndex+1]=array[insertIndex]; //将数据后移
				insertIndex--;
			}
			/*找到当前有序数组不满足移动条件后，在其后插入数据*/
			array[insertIndex+1]=insertValue;
			System.out.println("第"+i+"趟排序后："+Arrays.toString(array));
		}
	}
}
