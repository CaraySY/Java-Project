package com.wsy.dp.string;

/**
 * 	����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ��� s ����󳤶�Ϊ 1000��
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
	 * 	����ƥ��ʱ�临�Ӷ�O(N^3)
	 * @param s
	 * @return
	 */
	public static String longestPalindrome1(String s) {

		if(s.length() < 2) {
			return s; // ����С�ڵ���1 �ض��ǻ��Ĵ�
		}
		int maxLen=1;//��ʼ��Ϊ1�� 2���ַ����ض����ڳ���Ϊ1�Ļ��Ĵ�
		String res="";
		for(int i=0;i<s.length()-1;i++) {     //  i j(jλ��i����һ��λ�ñȽ�)
			for(int j=i+1;j<s.length();j++) { //a b c d e
				if(j-i+1 > maxLen && isPalindrome(s, i, j)) {
					maxLen=j-i+1; //������Ҫ��һ
					res=s.substring(i,j+1);
				}
			}
		}
		return res; //��ȡ����Ĵ�
    }
	
	/**
	 * 	��̬�滮�㷨
	 * @param s
	 * @return
	 */
	public static String longestPalindrome2(String s) {
		
		if(s.length() < 2) {
			return s; // ����С�ڵ���1 �ض��ǻ��Ĵ�
		}
		char[] ps=s.toCharArray();
		int len=s.length();
		boolean[][] dp=new boolean[len][len];//����dp[i,j]Ϊ�±��i-j���Ӵ��Ƿ�Ϊ���Ĵ�
		for(int i=0;i<len;i++) {
			dp[i][i]=true;
		}
		int maxLen=1;
		int start=0;
		//����һ���ַ�����������ڲ��ǻ��Ĵ�:s[i+1,j-1]�ǻ��Ĵ��������� ch[i]==ch[j] -->�ض��и��ַ����ǻ��Ĵ�
		//����� �� ch[i]==ch[j] -> dp[i,j]=dp[i+1,j-1]
		//�ٽ�ֵ��[j-1-(i+1) + 1 ] < 2 (j-1-i-1+1<2 => j-i<3)�����Ӵ�����С�ڵ���1(�Ӵ�Ϊ�մ����ߵ�һ�ַ������ض��ǻ��Ĵ�)
		// �Խ��ߵ��ַ��ض��ǻ���(��һ�ַ�)
		for(int j=1;j<len;j++) {
			for(int i=0;i<j;i++) {
				if(ps[i]==ps[j]) {
					if(j-i<3) { //��ʱs[i,j]Ϊ��һ�ַ���մ���ֱ��Ϊ���Ĵ�true
						dp[i][j]=true;
					}else {
						dp[i][j]=dp[i+1][j-1];//�����Ӵ��ж���s[i,j]�Ƿ���Ĵ�
					}
				}else {
					dp[i][j]=false; //ch[i]!=ch[j]  ->�ض����ǻ��Ĵ�
				}
				if(dp[i][j]) { //���s[i,j]�ǻ��Ĵ�����¼���±�
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
