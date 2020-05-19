package com.syw.sparsearray;

import java.io.File;

import com.syw.common.SerializableUtils;

/**
 * 	ϡ������Ӧ��
 * @author Administrator
 *
 */
public class SparseArray {

	public static void main(String[] args) {
		
		/*����һ����ά���飺11*11*/
		/*0�������� 1������  2������*/
		int[][] array=new int[11][11];
		array[1][2]=1;
		array[2][3]=2;
		array[3][4]=4;
		/*
		 * for(int i=0;i<array.length;i++) { for(int j=0;j<array.length;j++) {
		 * System.out.print(array[i][j]+" "); } System.out.println(); }
		 */
		/*ʹ����ǿforѭ����ӡ����*/
		System.out.println("��ӡԭʼ���飺");
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
		/*��ȡϡ������---��һ�м�¼ԭ���� �� -��-��Чֵ���� */
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
		/*����ϡ������*/
		for(int[] temp:sparseArray) {
			for(int data:temp) {
				System.out.print(data+"\t");
			}
			System.out.println();
		}
		/*��ϡ���������л�*/
		System.out.println("Serializable Array...");
		SerializableUtils.writeObject(sparseArray, new File("sparse.data"));
		/*ϡ�����鷴���л�*/
		System.out.println("Reverse Serializable Array..");
		int[][] newSparseArray  = (int[][]) SerializableUtils.readObject(new File("sparse.data"));
		/*ϡ������תΪԭʼ����*/
		int row=newSparseArray[0][0];
		int col=newSparseArray[0][1];
		index=0;
		int k,z;
		int temp;
		int[][] orignalArray=new int[row][col];
		for(int i=1;i<newSparseArray.length;i++) { // i ������  ��д���Ϳ��ԣ��ӵ�һ�п�ʼ
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
