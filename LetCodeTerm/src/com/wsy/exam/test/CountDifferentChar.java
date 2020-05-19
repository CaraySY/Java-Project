package com.wsy.exam.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CountDifferentChar {

	public static void main(String[] args) {
		
		Scanner keyboard=new Scanner(System.in);
		String data;
		while(keyboard.hasNext()) {
			data=keyboard.nextLine();
			int res=get(data);
			System.out.println(res);
		}
		keyboard.close();
	}
	
	public static int get(String s) {
		
		char[] ps=s.toCharArray();
		List<Character> list=new ArrayList<>();
		int index=0;
		while(index < ps.length) {
			if(ps[index] >=0 && ps[index] <=127) {
				list.add(ps[index]);
			}
			index++;
		}
		Object[] array = list.toArray();
		Arrays.sort(array);
		int i=0;
		int j=1;
		while(i<array.length && j<array.length) {
			if(array[i]==array[j]) {
				j++;
			}else {
				array[i+1]=array[j];
				i++;
				j++;
			}
		}
		return i+1;
	}
}
