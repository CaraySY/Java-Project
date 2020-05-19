package com.wsy.number;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		
		String[] strs={"flower","flow","flight"};
		String prefix = longestCommonPrefix(strs);
		System.out.println("prefix="+prefix);
	}
	
	
	
	public static String longestCommonPrefix(String[] strs) {
		
		if(strs.length==0) {
			return "";
		}
		String ans=strs[0]; //假定最长公共前缀为第一个字符
		for(int i=1;i<strs.length;i++) {
			int j=0;
			// j 用于比较ans和 
			for(;j<ans.length()&&j<strs[i].length();j++) {
				if(ans.charAt(j)!=strs[i].charAt(j)) {
					break;
				}
			}
			ans=ans.substring(0,j); //截取字符串
			if(ans.equals(""))
                return ans;
		}
		return ans;
	}
}
