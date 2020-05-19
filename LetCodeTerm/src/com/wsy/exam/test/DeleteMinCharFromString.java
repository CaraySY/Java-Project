package com.wsy.exam.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DeleteMinCharFromString {

	public static void main(String[] args) {
		
		Scanner keyboard=new Scanner(System.in);
		String s;
		while(keyboard.hasNext()) {
			s=keyboard.nextLine();
			delete(s);
		}
		keyboard.close();
	}
	
	public static void delete(String s) {
		
		int[] next=new int[26];
		char[] ps=s.toCharArray();
		int index=0;
		StringBuilder builder=new StringBuilder();
		while(index < ps.length) {
			next[ps[index]-'a']++; // ps[index]-'a' -> 获取每个字母对应的下标，并统计
			index++;
		}
		List<Character> list=new ArrayList<>();
		List<Integer> minList=new ArrayList<>();
		for(int i=0;i<next.length;i++) {
			if(next[i]>0) {
				minList.add(next[i]);
			}
		}
		int min=Collections.min(minList);
		for(int i=0;i<next.length;i++) {
			if(next[i]==min) {
				list.add((char) (i+'a'));
			}
		}
		//删除开始--从next数组删除
		for(int i=0;i<ps.length;i++) {
			if(!list.contains(ps[i])) {
				builder.append(ps[i]);
			}
		}
		System.out.println(builder.toString());
	}
}
