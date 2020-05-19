package com.syw.sort;

//import java.util.Arrays;

/**
 * [只需要进行 n-1次排序]
 * 	冒泡排序，第一趟将最大的数排在最后面 需要进行 n-1-0次排序
 * 		        第X趟需要进行 n-1-(X-1)次
 * 	每一趟排序都会确定一个当前数组的最大数放到后面，即减少一次交换的过程
 * @author Administrator
 *
 */
public class BubbleSort {

	//private static int[] array= {3,9,-1,10,-2};
	//private static int[] array= {3,9,-1,10,20};
	
	
	public static void bubbleSort(int[] array) {
		
		int temp=-1;//临时变量
		/*优化冒泡排序，当一排序后没有发生交换，即数组已经有序，无需进行后面的交换*/
		boolean flag=false;
		for(int i=0;i<array.length-1;i++) {
			for(int j=0;j<array.length-1-i;j++) {
				if(array[j]>array[j+1]) {
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
					flag=true;//代表数组没有排序完毕
				}
			}
			//System.out.printf("第  %d 次排序过后：\n",(i+1));
			//System.out.println(Arrays.toString(array));
			if(!flag) { //在一趟排序过后，已经排序好，不需要进行后面的排序过程
				break;
			}else {
				flag=false; //进行下次判断
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
		System.out.println("消耗的时间:"+(end-start)/1000+"s");
	}
}
