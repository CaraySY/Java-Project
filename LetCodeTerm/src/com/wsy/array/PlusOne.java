package com.wsy.array;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		int[] array= {9,9,9};
		System.out.println(Integer.MAX_VALUE);
		int[] temp=plusOne2(array);
		System.out.println(Arrays.toString(temp));
	}
	
	public static int[] plusOne(int[] digits) {
		
		int num=0;
		int len=digits.length-1;
		/*��ת��Ϊ������+1��ָ������*/
		for(int i=len,n=1;i>=0;i--,n*=10) {
			num=num+digits[i]*n;
		}
		num++;
		while(num!=0 && len >= 0) { // ������� 999+1 �������鳤�ȣ�������Ҫ�ж������±�
			int pop=num % 10;
			digits[len--]=pop;
			num/=10;
		}
		if(num!=0) {
			int[] temp=new int[digits.length+1];
			temp[0]=1;
			int j=0;
			while((j+1)<digits.length  && j<temp.length) {
				temp[j+1]=digits[j];
				j++;
			}
			return temp;
		}
		return digits;
	}
	
	public static int[] plusOne2(int[] digits) {
		
		for(int i=digits.length-1;i>=0;i--) { //ʹ��ѭ���жϸ�ʮ��λ������Ƿ�Ϊ0,
			digits[i]++;
			digits[i]=digits[i]%10;
			//ֻ��0����10���� 0
			if(digits[i]!=0) {
				return digits;
			}
		}
		digits=new int[digits.length+1];
		digits[0]=1;
		return digits;
	}
}
