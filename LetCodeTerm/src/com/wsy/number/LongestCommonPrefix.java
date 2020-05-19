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
		String ans=strs[0]; //�ٶ������ǰ׺Ϊ��һ���ַ�
		for(int i=1;i<strs.length;i++) {
			int j=0;
			// j ���ڱȽ�ans�� 
			for(;j<ans.length()&&j<strs[i].length();j++) {
				if(ans.charAt(j)!=strs[i].charAt(j)) {
					break;
				}
			}
			ans=ans.substring(0,j); //��ȡ�ַ���
			if(ans.equals(""))
                return ans;
		}
		return ans;
	}
}
