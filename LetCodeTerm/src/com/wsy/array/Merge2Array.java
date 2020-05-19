package com.wsy.array;

import java.util.Arrays;

public class Merge2Array {

	public static void main(String[] args) {
		
		int[] A= {1,2,3,0,0,0};
		int[] B= {2,5,6};
		int m=3,n=3;
		merge(A,m,B,n);
		System.out.println("A="+Arrays.toString(A));		
		
	}
	
	/**
	 * 	两个排序数组，将B按顺序插入到A，A足够大
	 * @param A
	 * @param m A个数
	 * @param B
	 * @param n B个数
	 */
	 public static void merge(int[] A, int m, int[] B, int n) {

		 int[] temp=new int[m];
		 int i=0; //指向A
		 int j=0; //指向B
		 int t=0; //指向temp
		 for(int k=0;k<m;k++) {
			 temp[k]=A[k];
		 }
		 while(i<m && j<n) {
			 if(temp[i] > B[j]) {
				 A[t++]=B[j++];
			 }else {
				 A[t++]=temp[i++];
			 }
		 }
		 // A剩余复制到temp
		 while(i<m) {
			 A[t++]=temp[i++];
		 }
		 // B剩余复制到temp
		 while(j<n) {
			 A[t++]=B[j++];
		 }
	 }
}
