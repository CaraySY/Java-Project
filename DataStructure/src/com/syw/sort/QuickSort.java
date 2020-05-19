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
		System.out.println("消耗的时间:"+(end-start)/1000+"s");
		//System.out.println(Arrays.toString(array));
	}
	
	/*使用挖坑法的快速排序，当low、high指针重合，将pivot填入坑里，完成一次排序比较*/
	public static void quickSort(int[] array,int left,int right) {
		
		/*递归结束条件*/
		if(left >= right) {
			return;
		}
		int low=left; // 低位指针
		int high=right; // 高位指针
		int pivot=array[low]; // 关键字
		while(low < high) {
			while (low < high && array[high] >= pivot) {
				high--;
			}
			/* high指针找到一个比pivot 小的数，将该数填入array[low]处 low指针后移 */
			if(low < high) { //保证low < high才能填入坑中
				array[low++] = array[high];
			}
			while (low < high && array[low] <= pivot) {
				low++;
			}
			/* low指针找到一个比pivot 大的数，将该数填入array[high]处，high指针前移 */
			if(low < high) { //保证low < high才能填入坑中
				array[high--] = array[low];
			}
		}
		/*low、high指针重合，将pivot填入坑中*/
		array[low]=pivot;
		//左递归
		quickSort(array,left,low-1);
		//右递归
		quickSort(array,low+1,right);
	}
}
