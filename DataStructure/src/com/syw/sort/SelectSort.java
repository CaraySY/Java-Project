package com.syw.sort;


/**
 * 	选择排序一共有 array.length-1 次排序
 * 	每轮排序都是一个xunhuan
 * 	首先假定当前数是最小数
 * 	然后和后面的每个数进行比较，如果发现有比当前数更小的数，
 * 就重新确定最小数，并得到最小数下标
 * 	当遍历到数组最后，就得到本轮最小数和下标
 * 	
 * @author Administrator
 *
 */
public class SelectSort {

	public static void main(String[] args) {
		
		//int[] array={3,9,-1,10,20};
	/*
	 * int[] array={1,2,3,4,5}; System.out.println("排序前："+Arrays.toString(array));
	 * selectSort(array); }
	 */
		
		int[] array=new int[80000];
		for(int i=0;i<array.length;i++) {
			array[i]=(int)(Math.random()*80000);
		}
		long start=System.currentTimeMillis();
		selectSort(array);
		long end=System.currentTimeMillis();
		System.out.println("消耗的时间:"+(end-start)/1000+"s");
	}
	public static void selectSort(int[] array) {
		
		for(int i=0;i<array.length-1;i++) {
			
			int min=array[i];//假定最小数是当前数
			int minIndex=i;//最小数下标是当前数小标
			for(int j=i+1;j<array.length;j++) { //假定的当前最小数和当前最小数的下一个数比较[直到最后一个数]
				if(min > array[j]) {
					min=array[j];
					minIndex=j;
				}
			}
			if(minIndex!=i) { //如果最小数下标没有改变，不需要交换
				array[minIndex]=array[i]; //将array[i]和minIndex小标的值交换
				array[i]=min;
			}
		}
	}
}
