package com.syw.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Greedy {

	public static void main(String[] args) {
		
		init();
	}
	
	public static void init() {
		
		Map<String,HashSet<String>> broadcase=new HashMap<>();
		HashSet<String> b1=new HashSet<>();
		b1.addAll(Arrays.asList("����","�Ϻ�","���"));
		HashSet<String> b2=new HashSet<>();
		b2.addAll(Arrays.asList("����","����","����"));
		HashSet<String> b3=new HashSet<>();
		b3.addAll(Arrays.asList("�ɶ�","�Ϻ�","����"));
		HashSet<String> b4=new HashSet<>();
		b4.addAll(Arrays.asList("�Ϻ�","���"));
		HashSet<String> b5=new HashSet<>();
		b5.addAll(Arrays.asList("����","����"));
		broadcase.put("key1", b1);
		broadcase.put("key2", b2);
		broadcase.put("key3", b3);
		broadcase.put("key4", b4);
		broadcase.put("key5", b5);
		HashSet<String> allAreas=new HashSet<>();
		for(String temp : b1) {
			allAreas.add(temp);
		}
		for(String temp : b2) {
			allAreas.add(temp);
		}
		for(String temp : b3) {
			allAreas.add(temp);
		}
		for(String temp : b4) {
			allAreas.add(temp);
		}
		for(String temp : b5) {
			allAreas.add(temp);
		}
	}
}
