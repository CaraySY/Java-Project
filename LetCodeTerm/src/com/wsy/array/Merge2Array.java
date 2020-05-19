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
	 * 	�����������飬��B��˳����뵽A��A�㹻��
	 * @param A
	 * @param m A����
	 * @param B
	 * @param n B����
	 */
	 public static void merge(int[] A, int m, int[] B, int n) {

		 int[] temp=new int[m];
		 int i=0; //ָ��A
		 int j=0; //ָ��B
		 int t=0; //ָ��temp
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
		 // Aʣ�ิ�Ƶ�temp
		 while(i<m) {
			 A[t++]=temp[i++];
		 }
		 // Bʣ�ิ�Ƶ�temp
		 while(j<n) {
			 A[t++]=B[j++];
		 }
	 }
}
