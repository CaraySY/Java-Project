package com.wsy.exam.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Coordinate {

	public static void main(String[] args) {
		
		Scanner keyboard=new Scanner(System.in);
		String s;
		while(keyboard.hasNext()) {
			s=keyboard.next();
			List<String> list=getInstruction(s);
			getCoordinate(list);
		}
		keyboard.close();
	}
	
	public static void getCoordinate(List<String> list) {

		int x=0,y=0;//¶¨Òå×ø±ê
		for(int i=0;i<list.size();i++) {
			char oper=list.get(i).charAt(0);
			int sign=getSign(oper);
			String s=list.get(i).substring(1);
			int operNum=Integer.parseInt(s);
			switch (oper) {
			case 'A':
			case 'D':
				x=x+sign*operNum;
				break;
			case 'W':
			case 'S':
				y=y+sign*operNum;
				break;
			default:
				break;
			}
		}
		System.out.printf("(%d,%d)\n",x,y);
	}
	
	private static int getSign(char c) {

		switch (c) {
		case 'A':
		case 'S':
			return -1;
		case 'W':
		case 'D':
			return 1;
		default:
			return 0;
		}
	}

	public static List<String> getInstruction(String s){
		
		String[] splits = s.split(";");
		List<String> list=new ArrayList<>();
		for(int i=0;i<splits.length;i++) {
			char[] temp=splits[i].toCharArray();
			int index=1;
			boolean flag=false;
			if(temp.length <= 0 || temp.length > 3) {
				continue;
			}
			if(temp[0]=='A'||temp[0]=='S'||temp[0]=='D'||temp[0]=='W') {
				while(index < temp.length) {
					if(temp[index] >=48 && temp[index] <=57) {
						index++;
						flag=true;
					}else {
						flag=false;
						break;
					}
				}
				if(flag) {
					list.add(splits[i]);
				}
			}
		}
		return list;
	}
}

