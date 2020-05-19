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
		b1.addAll(Arrays.asList("北京","上海","天津"));
		HashSet<String> b2=new HashSet<>();
		b2.addAll(Arrays.asList("广州","北京","深圳"));
		HashSet<String> b3=new HashSet<>();
		b3.addAll(Arrays.asList("成都","上海","杭州"));
		HashSet<String> b4=new HashSet<>();
		b4.addAll(Arrays.asList("上海","天津"));
		HashSet<String> b5=new HashSet<>();
		b5.addAll(Arrays.asList("杭州","大连"));
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
