package com.syw.tree;

/**
 * 	  
 * 
 *  大顶堆：
 *  每一个节点大于/等于其左右子节点，左右子节点的大小无关
 *  小顶堆：相反
 *   *
 *  *  *
 * * * * *
 + + + 
 * @author Administrator
 *
 */
public class HeapSort {
	
	public void heapSort(int[] array) {
		
		int temp=0;
		/*调整堆，使其满足大顶堆的定义:--->从最下面一层的非叶子[可能是左子树/右子树]开始调整--找到当前最大数放到堆顶*/
		for(int i=array.length/2-1;i>=0;i--) {
			adjustHeap(array, i, array.length);
		}
		/*得到一个满足大顶堆需求的顺序二叉树，将堆顶元素移动到数组最后，并再次调整堆[length--]*/
		for(int j=array.length-1;j>=0;j--) {
			/*交换*/
			temp=array[0];
			array[0]=array[j];
			array[j]=temp;
			/*堆长度 -1 继续调整堆，使其满足大顶堆的定义*/
			//从堆顶开始调整
			adjustHeap(array,0,j);
		}
	}

	/**
	 * 	调整堆，保证整个堆的当前节点大于左右子节点[ 大顶堆   ]
	 * @param array 待调整的数组
	 * @param i 下标
	 * @param length 数组的大小
	 */
	private static void adjustHeap(int[] array,int i,int length) {
		
		int temp=array[i];
		/*从最下面一层的非叶子节点的左子节点开始比较*/
		for(int k=2*i+1;k<length;k=2*k+1) {
			//保证 k+1没有越界
			if(k+1 < length && array[k] < array[k+1]) { //如果当前左节点的值小于右节点的值，移动指针指向右节点
				k++;
			}
			if(array[k] > temp) { //指针指向的节点大于其父亲节点，需要交换
				array[i]=array[k]; //子节点大于父节点，交换
				i=k; //向下继续调整堆
			}else {
				break;
			}
		}
		/*循环结束后， 将   下标为i的父节点的数的最大值，放在了当前位置的堆顶*/
		array[i]=temp;
	}
}
