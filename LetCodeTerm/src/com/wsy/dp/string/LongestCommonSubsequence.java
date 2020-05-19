package com.wsy.dp.string;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		
		String s1="abcde";
		String s2="ace";
		int res=longestCommonSubsequence(s1, s2);
		System.out.println(res);
	}
	
	/**
	 * 	给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static int longestCommonSubsequence(String s1,String s2) {
		
		//1、定义dp[i,j]表示 S1 的前 i个字符与 S2 的前 j个字符最长公共子序列的长度所拥有的最长公共子序列
		//2、dp[i,j]=dp[i-1,j-1]+1 si==sj
		// si!=sj dp[i,j]=dp[i-1,j],dp[i,j-1]
		char[] ps1=s1.toCharArray();
		char[] ps2 = s2.toCharArray();
		int[][] dp=new int[s1.length()+1][s2.length()+1];
		//dp[0][0]=0;//代表s1的前0个字符与s2的前零个字符的最长公共子序列为0
		for(int i=1;i<=s1.length();i++) {
			for(int j=1;j<=s2.length();j++) {
				if(ps1[i-1]==ps2[j-1]) { //字符串的字符应该从下标为0开始
					dp[i][j]=dp[i-1][j-1]+1;
				}else {
					dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		return dp[ps1.length][ps2.length];
	}
}
