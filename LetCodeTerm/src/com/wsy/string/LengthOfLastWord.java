package com.wsy.string;

public class LengthOfLastWord {

	public static void main(String[] args) {
		
		String str="Hello World";
		int index=lengthOfLastWord2(str);
		System.out.println(index);
	}
	
	/**
	 * 	�Լ�д��ʹ��API
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
	 * 	�ο��𰸣���Java Trim����
	 * @param s
	 * @return
	 */
	public static int lengthOfLastWord2(String s) {
		
		char[] val=s.toCharArray();
		int end=val.length-1;//�Ӻ�����ǰ����
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
	 * 	�Զ��巽����ȥ���ַ�����β�Ŀո�
	 * @param s
	 * @return
	 */
	public static String trim(String s) {
		
		char[] val=s.toCharArray();
		int start=0;
		int end=val.length-1;
		//ȥ���ַ����׵Ŀո�
		while(start < val.length && val[start]==' ') {
			start++;
		}
		while(end >=0 && val[end]==' ') {
			end--;
		}
		return (start > 0 || end < val.length) ? s.substring(start,end+1) : s;
	}
}
