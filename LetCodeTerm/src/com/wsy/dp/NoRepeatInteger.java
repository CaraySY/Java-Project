package com.wsy.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoRepeatInteger {

	public static void main(String[] args) {
		
		Scanner keyboard=new Scanner(System.in);
		int data;
		int res;
		while(keyboard.hasNext()) {
			data=keyboard.nextInt();
			res=start(data);
			System.out.println(res);
		}
		keyboard.close();
	}
	
	public static int start(int data) {
		
		List<Integer> list=new ArrayList<>();
		while(data>0) {
			int pop=data%10;
			if(!list.contains(pop)) {
				list.add(pop);
			}
			data=data/10;
		}
		int res=0;
		for(int i=0;i<list.size();i++) {
			res=res*10+list.get(i);
		}
		list.clear();
		return res;
		
	}
}
