package com.wsy.exam.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SortStringByDictionary {

	/**
	 * 	使用Collection的sort方法
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner keyboard=new Scanner(System.in);
		String s;
		int n=0;
		n=keyboard.nextInt();
		List<String> list=new ArrayList<>();
		while(keyboard.hasNext()) {
			for(int i=0;i<n;i++) {
				s=keyboard.next();
				list.add(s);
			}
		Collections.sort(list,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				char[] os1=o1.toCharArray();
				char[] os2=o2.toCharArray();
				
				int i=0;
				while(i<os1.length && i<os2.length) {
					if(os1[i] > os2[i]) {
						return 1;
					}else if(os1[i] < os2[i]) {
						return -1;
					}else {
						i++;
					}
				}
				if(i==os1.length) { //说明os1小于os2
					return -1;
				}
				if(i==os2.length) {//说明os1大于os2
					return 1;
				}
				return 0;
			}
		});
		for(String temp:list) {
			System.out.print(temp+" ");
		}
		}
		keyboard.close();
	}
}
