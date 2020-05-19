package com.wsy.dp.string;

/**
 * 	�����ַ��� s �� t ���ж� s �Ƿ�Ϊ t �������С�
 *  ˫�������⡣��
 * @author Administrator
 *
 */
public class SisSubsequence {

	public static void main(String[] args) {
		
		String s="ace";
		String t="ahbgdce";
		boolean flag=isSubsequence(s,t);
		System.out.println("flag="+flag);
	}
	
	/**
	 * 	1��dp[i][j] Ϊs�� 1->i t��1->j �����������
	 *  2��dp[i][j]=max{dp[i-1][j],dp[i][j-1]} s[i]=t[j]
	 *  		  = dp[i-1][j-1]+1
	 *  3��dp[0][0]=0;
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean isSubsequence(String s, String t) {
		
		int[][] dp=new int[s.length()+1][t.length()+1];
		dp[0][0]=0;
		char[] ps=s.toCharArray();
		char[] pt=t.toCharArray();
		for(int i=1;i<=s.length();i++) {
			for(int j=1;j<=t.length();j++) {
				if(ps[i-1]==pt[j-1]) { //�й�����������
					dp[i][j]=dp[i-1][j-1]+1;
				}else {
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);//û��
				}
			}
		}
		for(int[]temp:dp) {
			for(int data:temp) {
				System.out.print(data+"\t");
			}
			System.out.println();
		}
		boolean flag=dp[s.length()][t.length()] ==s.length() ? true : false;
		return flag;
    }
}
