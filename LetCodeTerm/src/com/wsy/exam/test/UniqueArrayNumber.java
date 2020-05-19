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
		
		//1�����ȶ�ԭʼ��������
		Arrays.sort(nums);
		//1������p qָ��
		int p=0;
		int q=1; //ָ��������������һ�����
		while(p<nums.length && q<nums.length) {
			if(nums[p]==nums[q]) { //��ͬԪ��ֱ������
				q++; //ֻ��qָ���ƶ�
			}else {
				nums[p+1]=nums[q]; //�磺1 1 2 3 ����ʱpָ��1 qָ��2����Ҫ��q���Ƶ�p+1����ָ��ͬʱ���
				p++;
				q++;
			}
		}
		for(int i=0;i<=p;i++) {
			System.out.println(nums[i]);
		}
	}
}
