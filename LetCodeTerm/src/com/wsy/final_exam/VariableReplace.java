package com.wsy.final_exam;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VariableReplace {

	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
		Map<String,String> map=new LinkedHashMap<>();
		while (in.hasNext()) {
			int n=in.nextInt();
			for(int i=0;i<n;i++) {
				String input=in.next();
				String[] split = input.split("=");
				map.put(split[0],split[1]);
			}
			replace(map);
		}
		in.close();
	}
	
	public static void replace(Map<String,String> map) {
		
		List<String> right=new ArrayList<>();
		List<String> keys=new ArrayList<>();
		
		for(Map.Entry<String, String> entry:map.entrySet()) {
			if(entry.getValue().contains("$")) {
				keys.add(entry.getKey());
				right.add(entry.getValue());
			}
		}
		String test;
		String[] temp;
		StringBuilder key=new StringBuilder();
		StringBuilder res=new StringBuilder();
		for(int i=0;i<right.size();i++) {
			test=right.get(i);
			String mapKey=keys.get(i);
			temp = test.split("/");
			for(int j=0;j<temp.length;j++) {
				if(temp[j].contains("$")) {
					char[] ps = temp[j].toCharArray();
					int index=0;
					while(index<ps.length) {
						if(ps[index] >='a' && ps[index] <='z') {
							key=key.append(ps[index++]);
						}else {
							index++;
						}
					}
					String left = map.get(key.toString());//www
					temp[j]=left;
					key.delete(0, key.length());
				}
			}
			/**
			 * 
			 * 4
xxx=/lyf/${ttt}/test
ttt=www
yyy=seeyou
aa=/a/aaa/${xxx}/bbb/${yyy}/ccc

			 */
			
			if(test.charAt(0)=='/') {
				res.append("/");
			}
			for(int k=0;k<temp.length;k++) {
				
				if(temp[k].toString().equals("")) {
					continue;
				}
				res.append(temp[k]);
				if(k!=temp.length-1) {
					res.append("/");
				}
			}
			right.set(i, res.toString());
			map.put(mapKey, res.toString());
			res=res.delete(0, res.length());
		}
		System.out.println(right.get(right.size()-1));
	}
}
