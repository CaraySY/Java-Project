package com.syw.sort;


public class ShellSort {

	private static int count=0;//计算计较的躺数

	public static void main(String[] args) {
		
		//int[] array= {8,9,1,7,2,3,5,4,6,0};
		/*int[] array=new int[80000];
		for(int i=0;i<array.length;i++) {
			array[i]=(int)(Math.random()*80000);
		}
		long start=System.currentTimeMillis();
		swap_shellSort(array);
		long end=System.currentTimeMillis();
		System.out.println("消耗的时间:"+(end-start)/1000+"s");
		System.out.println("count="+count);*/
		int[] array=new int[80000000];
		for(int i=0;i<array.length;i++) {
			array[i]=(int)(Math.random()*80000000);
		}
		long start=System.currentTimeMillis();
		move_shellSort(array);
		long end=System.currentTimeMillis();
		System.out.println("消耗的时间:"+(end-start)/1000+"s");
		System.out.println("count="+count);
		//System.out.println(Arrays.toString(array)+" 总趟数："+count);
	}
	
	/**
	 * 	shell[交换法]排序需要计算gap 步长[组数]
	 * 	gap=array.length/2
	 * 	gap=gap/2
	 * 	gap(步长)需要大于或者等于1
	 * 
	 * 	交换法的shell排序花费大量时间在交换
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
	 * 	使用移位法改进 交换法的shell排序
	 *  增量排序法
	 * @param array
	 */
	public static void move_shellSort(int[] array) {
		
		int index=-1;//待插入数据的下标
		int temp=-1;//待插入的数据
		for (int gap = array.length / 2; gap > 0; gap /= 2) {
			for(int i=gap;i<array.length;i++) {
				index=i;
				temp=array[index];
				if(array[index] < array[index-gap]) { //待插入的数据小于前面的数据
					while(index-gap >= 0 && temp < array[index-gap]) { //前面的数据后移
						array[index]=array[index-gap]; //后移
						index=index-gap; // index 按照减去步长改变
					}
				}
				//插入到array[index]
				array[index]=temp;
			}
			count++;
		}
	}
}
