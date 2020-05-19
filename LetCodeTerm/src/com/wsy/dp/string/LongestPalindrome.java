package com.wsy.dp.string;

/**
 * 	给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * @author Administrator
 *
 *
 *
 */
public class LongestPalindrome {

	public static void main(String[] args) {
		
		String res="";
		res=longestPalindrome2("ac");
		System.out.println(res);
	}
	
	/**
	 * 	暴力匹配时间复杂度O(N^3)
	 * @param s
	 * @return
	 */
	public static String longestPalindrome1(String s) {

		if(s.length() < 2) {
			return s; // 长度小于等于1 必定是回文串
		}
		int maxLen=1;//初始化为1， 2个字符，必定存在长度为1的回文串
		String res="";
		for(int i=0;i<s.length()-1;i++) {     //  i j(j位于i的下一个位置比较)
			for(int j=i+1;j<s.length();j++) { //a b c d e
				if(j-i+1 > maxLen && isPalindrome(s, i, j)) {
					maxLen=j-i+1; //长度需要加一
					res=s.substring(i,j+1);
				}
			}
		}
		return res; //截取最长回文串
    }
	
	/**
	 * 	动态规划算法
	 * @param s
	 * @return
	 */
	public static String longestPalindrome2(String s) {
		
		if(s.length() < 2) {
			return s; // 长度小于等于1 必定是回文串
		}
		char[] ps=s.toCharArray();
		int len=s.length();
		boolean[][] dp=new boolean[len][len];//定义dp[i,j]为下标从i-j的子串是否为回文串
		for(int i=0;i<len;i++) {
			dp[i][i]=true;
		}
		int maxLen=1;
		int start=0;
		//对于一个字符串如果他的内部是回文串:s[i+1,j-1]是回文串，并且有 ch[i]==ch[j] -->必定有该字符串是回文串
		//如果有 ： ch[i]==ch[j] -> dp[i,j]=dp[i+1,j-1]
		//临界值：[j-1-(i+1) + 1 ] < 2 (j-1-i-1+1<2 => j-i<3)代表子串长度小于等于1(子串为空串或者单一字符串，必定是回文串)
		// 对角线的字符必定是回文(单一字符)
		for(int j=1;j<len;j++) {
			for(int i=0;i<j;i++) {
				if(ps[i]==ps[j]) {
					if(j-i<3) { //此时s[i,j]为单一字符或空串，直接为回文串true
						dp[i][j]=true;
					}else {
						dp[i][j]=dp[i+1][j-1];//根据子串判定该s[i,j]是否回文串
					}
				}else {
					dp[i][j]=false; //ch[i]!=ch[j]  ->必定不是回文串
				}
				if(dp[i][j]) { //如果s[i,j]是回文串，记录其下标
					int length=(j-i+1);
					if(length > maxLen) {
						start=i;
						maxLen=length;
					}
				}
			}
		}
		for(boolean  [] temp:dp) {
			for(boolean data: temp) {
				System.out.print(data+"\t");
			}
			System.out.println();
		}
		return s.substring(start, maxLen);
	}
	
	public static boolean isPalindrome(String s,int i,int j) {
		
		char[] ps=s.toCharArray();
		while(i<j) {
			if(ps[i]!=ps[j]) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
