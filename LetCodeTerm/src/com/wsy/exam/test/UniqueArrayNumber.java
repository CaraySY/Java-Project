package com.wsy.exam.test;

import java.util.Arrays;
import java.util.Scanner;

public class UniqueArrayNumber {

	public static void main(String[] args) {
	
		Scanner keyboard=new Scanner(System.in);
		int n=0;
		int[] nums;
		while(keyboard.hasNext()) {
			n=keyboard.nextInt();
			nums=new int[n];
			for(int i=0;i<n;i++) {
				nums[i]=keyboard.nextInt();
			}
			unique(nums);
		}
		keyboard.close();
	}
	
	public static void unique(int[] nums) {
		
		//1、首先对原始数组排序
		Arrays.sort(nums);
		//1、定义p q指针
		int p=0;
		int q=1; //指向有序数组至少一个间隔
		while(p<nums.length && q<nums.length) {
			if(nums[p]==nums[q]) { //相同元素直接跳过
				q++; //只有q指针移动
			}else {
				nums[p+1]=nums[q]; //如：1 1 2 3 ：此时p指向1 q指向2，需要将q复制到p+1处，指针同时相加
				p++;
				q++;
			}
		}
		for(int i=0;i<=p;i++) {
			System.out.println(nums[i]);
		}
	}
}
