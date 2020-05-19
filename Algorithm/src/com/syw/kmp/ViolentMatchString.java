package com.syw.kmp;

/**
 * 	暴力匹配字符串算法
 * @author Administrator
 *
 */
public class ViolentMatchString {

	public static void main(String[] args) {
		
		int index=violentMatchString();
		System.out.println(index);
	}
	
	/**
	 *  @return
	 * 	返回第一次匹配到字符串的下标，否则返回-1
	 */
	public static int violentMatchString() {
		
		String str1="I love ChinaI love China I love ChinaChina";
		String str2="I love ChinaChina";
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		int i=0; //指向str1
		int j=0; //指向str2
		
		while(i<s1.length && j<s2.length) {
			
			if(s1[i]==s2[j]) {
				i++;
				j++; //如果匹配到相同的字符，同时移动指针 i,j到下一个字符
			}else {
				i=i-j+1; //原字符串指针回溯到子字符串指针  i 匹配的下一个字符
				j=0;//子字符串指针清零
			}
		}
		//判断是否匹配成功  j指针等于 s2字符串的长度
		if(j==s2.length) {
			return i-j; //返回第一次子字符串出现的位置
		}
		return -1;
	}
}
