package com.wsy.exam.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoRepeatedString {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// ע�⣬��������Ƕ��������������ͨ��whileѭ����������������
            String s=in.next();
            String res=deleteRepeatedChar(s);
            System.out.println(res);
        }
        in.close();
	}
	
	public static String deleteRepeatedChar(String s) {
		
		char[] ps = s.toCharArray();
		StringBuilder builder=new StringBuilder();
		List<Character> list=new ArrayList<>();
		int index=0;
		while(index<ps.length) {
			if(!list.contains(ps[index])) {
				list.add(ps[index]);
				index++;
			}else {
				index++;
			}
		}
		for(int i=0;i<list.size();i++) {
			builder.append(list.get(i));
		}
		return builder.toString();
	}
}
