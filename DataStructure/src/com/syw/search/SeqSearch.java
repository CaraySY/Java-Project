package com.syw.search;

public class SeqSearch {

	public static void main(String[] args) {

		int[] array= {1,3,9,5,8,6,74};
		int index = seqSearch(5,array);
		if(index!=-1) {
			System.out.println("查到到的下标:"+index+",data is:"+array[index]);
		}
	}
	
	public static int seqSearch(int data,int[] array) {
		
		int index=-1;// 返回的下标
		for(int i=0;i<array.length;i++) {
			if(array[i]==data) {
				index=i;
				break;
			}
		}
		return index;
	}
}
