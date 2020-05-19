package com.wsy.exam.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ErrorRecode {

	//使用有序的LinkedHashMap存储信息
    private static Map<String,Integer> map = new LinkedHashMap<String,Integer>();
	
	public static void main(String[] args) {
		
		Scanner keyboard=new Scanner(System.in);
		String path;
		String row;
		String error;
		while(keyboard.hasNext()) {
			path=keyboard.next();
			row=keyboard.next();
			path=path.substring(path.lastIndexOf("\\")+1);//获取最后的
			if(path.length()>16) { //长度大于16
				path=path.substring(path.length()-16);
			}
			error=path+" "+row;
			if(map.containsKey(error)) {
				map.put(error, map.get(error)+1);
			}else {
				map.put(error,1);
			}
		}
		//遍历
		int count=0;
		for(String info:map.keySet()) {
			count++;
			if(count > (map.keySet().size()-8)) { //从后8个开始遍历
				System.out.println(info+" "+map.get(info));
			}
		}
		keyboard.close();
	}
}
