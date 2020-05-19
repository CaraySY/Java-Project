package com.wsy.string;

public class LengthOfLastWord {

	public static void main(String[] args) {
		
		String str="Hello World";
		int index=lengthOfLastWord2(str);
		System.out.println(index);
	}
	
	/**
	 * 	自己写，使用API
	 * @param s
	 * @return
	 */
	public static int lengthOfLastWord(String s) {
		
		s=s.trim();
		if(s.equals("") || s=="") {
			return 0;
		}
		String[] splits=s.split(" ");
		String res = splits[splits.length-1];
		return res.length();
	}
	
	/**
	 * 	参考答案，和Java Trim方法
	 * @param s
	 * @return
	 */
	public static int lengthOfLastWord2(String s) {
		
		char[] val=s.toCharArray();
		int end=val.length-1;//从后面向前遍历
		while(end >=  0 && val[end]==' ') {
			end--;
		}
		int start=end;
		while(start >= 0 && val[start]!=' ') {
			start--;
		}
		String str=s.substring(start+1,end+1);
		return str.length();
	}
	
	/**
	 * 	自定义方法，去除字符串首尾的空格
	 * @param s
	 * @return
	 */
	public static String trim(String s) {
		
		char[] val=s.toCharArray();
		int start=0;
		int end=val.length-1;
		//去除字符串首的空格
		while(start < val.length && val[start]==' ') {
			start++;
		}
		while(end >=0 && val[end]==' ') {
			end--;
		}
		return (start > 0 || end < val.length) ? s.substring(start,end+1) : s;
	}
}
