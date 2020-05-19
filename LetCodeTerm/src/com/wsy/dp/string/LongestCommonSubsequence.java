package com.wsy.dp.string;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		
		String s1="abcde";
		String s2="ace";
		int res=longestCommonSubsequence(s1, s2);
		System.out.println(res);
	}
	
	/**
	 * 	���������ַ��� text1 �� text2�������������ַ����������������
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static int longestCommonSubsequence(String s1,String s2) {
		
		//1������dp[i,j]��ʾ S1 ��ǰ i���ַ��� S2 ��ǰ j���ַ�����������еĳ�����ӵ�е������������
		//2��dp[i,j]=dp[i-1,j-1]+1 si==sj
		// si!=sj dp[i,j]=dp[i-1,j],dp[i,j-1]
		char[] ps1=s1.toCharArray();
		char[] ps2 = s2.toCharArray();
		int[][] dp=new int[s1.length()+1][s2.length()+1];
		//dp[0][0]=0;//����s1��ǰ0���ַ���s2��ǰ����ַ��������������Ϊ0
		for(int i=1;i<=s1.length();i++) {
			for(int j=1;j<=s2.length();j++) {
				if(ps1[i-1]==ps2[j-1]) { //�ַ������ַ�Ӧ�ô��±�Ϊ0��ʼ
					dp[i][j]=dp[i-1][j-1]+1;
				}else {
					dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		return dp[ps1.length][ps2.length];
	}
}
