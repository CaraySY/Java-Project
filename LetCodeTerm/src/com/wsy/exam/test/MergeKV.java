package com.wsy.exam.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MergeKV {

	public static void main(String[] args) {
		
		Scanner keyboard=new Scanner(System.in);
		int key;
		int value;
		int n=keyboard.nextInt();
		Map<Integer,Integer> map=new HashMap<>();
		for (int i = 0; i < n; i++) {
			key = keyboard.nextInt();
			value = keyboard.nextInt();
			merge(map, key, value);
		}
		Object[] keys = map.keySet().toArray();
		Arrays.sort(keys);
		for(Object K : keys) {
			System.out.println(K+" "+map.get(K));
		}
		keyboard.close();
	}
	
	public static void merge(Map<Integer,Integer> map,int key,int value) {
		
		if(!map.containsKey(key)) {
			map.put(key, value);
		}else {
			map.put(key, map.get(key)+value);
		}
	}
}
