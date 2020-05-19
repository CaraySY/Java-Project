package com.wsy.exam.test;

import java.util.Scanner;

public class GetIntUpper {

	public static void main(String[] args) {
		
		Scanner keyboard=new Scanner(System.in);
		double data;
		while(keyboard.hasNext()) {
			data=keyboard.nextDouble();
			int res=getUppder(data);
			System.out.println(res);
		}
		keyboard.close();
	}
	
	public static int getUppder(double data) {
		
		int temp=(int) (data+0.5);
		int or=(int)data;
		if(temp > or) {
			return temp;
		}
		return temp;
	}
}
