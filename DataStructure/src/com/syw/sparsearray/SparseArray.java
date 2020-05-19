package com.syw.sparsearray;

import java.io.File;

import com.syw.common.SerializableUtils;

/**
 * 	稀疏数组应用
 * @author Administrator
 *
 */
public class SparseArray {

	public static void main(String[] args) {
		
		/*创建一个二维数组：11*11*/
		/*0：空棋子 1：黑子  2：蓝子*/
		int[][] array=new int[11][11];
		array[1][2]=1;
		array[2][3]=2;
		array[3][4]=4;
		/*
		 * for(int i=0;i<array.length;i++) { for(int j=0;j<array.length;j++) {
		 * System.out.print(array[i][j]+" "); } System.out.println(); }
		 */
		/*使用增强for循环打印数组*/
		System.out.println("打印原始数组：");
		for(int[] row:array) {
			for(int data:row) {
				System.out.print(data+" ");
			}
			System.out.println();
		}
		int sum=0;
		for(int[] row:array) {
			for(int data:row) {
				if(data!=0) {
					sum++;
				}
			}
		}
		System.out.println("sum="+sum);
		/*获取稀疏数组---第一行记录原数组 长 -宽-有效值总数 */
		int[][] sparseArray=new int[sum+1][3];
		sparseArray[0][0]=11;
		sparseArray[0][1]=11;
		sparseArray[0][2]=sum;
		int index=0;
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array.length;j++) {
				if(array[i][j]!=0) {
					index++;
					sparseArray[index][0]=i;
					sparseArray[index][1]=j;
					sparseArray[index][2]=array[i][j];
				}
			}
		}
		/*遍历稀疏数组*/
		for(int[] temp:sparseArray) {
			for(int data:temp) {
				System.out.print(data+"\t");
			}
			System.out.println();
		}
		/*将稀疏数组序列化*/
		System.out.println("Serializable Array...");
		SerializableUtils.writeObject(sparseArray, new File("sparse.data"));
		/*稀疏数组反序列化*/
		System.out.println("Reverse Serializable Array..");
		int[][] newSparseArray  = (int[][]) SerializableUtils.readObject(new File("sparse.data"));
		/*稀疏数组转为原始数组*/
		int row=newSparseArray[0][0];
		int col=newSparseArray[0][1];
		index=0;
		int k,z;
		int temp;
		int[][] orignalArray=new int[row][col];
		for(int i=1;i<newSparseArray.length;i++) { // i 控制行  列写死就可以，从第一行开始
				k=newSparseArray[i][0];
				z=newSparseArray[i][1];
				temp=newSparseArray[i][2];//value
				orignalArray[k][z]=temp;
		}
		for(int[] ro:orignalArray) {
			for(int data:ro) {
				System.out.print(data+" ");
			}
			System.out.println();
		}
	}
}
