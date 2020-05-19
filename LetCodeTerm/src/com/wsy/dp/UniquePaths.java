package com.wsy.dp;

/**
 * һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ��Start�� ����
 * ������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ��Finish������
 * ���ܹ��ж�������ͬ��·����
 * @author Administrator
 *
 */
public class UniquePaths {

	public static void main(String[] args) {
		
		int paths = uniquePaths(3,2);
		System.out.println(paths);
	}
	
	/**
	 * 	dp[i][j] Ϊ�����˴���ʼ�㵽 (i,j)��ͬ��·���ܺ�
	 *  dp[i][j]=dp[i-1][j]+dp[i][j-1]
	 *    ��������ǽֱ�ߣ������ǽֱ�� ����1��
	 * @param m
	 * @param n
	 * @return
	 */
	public static int uniquePaths(int m,int n) {
		
		int[][] dp=new int[m+1][n+1];
		dp[0][0]=1;
		for(int i=1;i<=m;i++) {
			dp[i][0]=1;
		}
		for(int j=1;j<=n;j++) {
			dp[0][j]=1;
		}
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				dp[i][j]=dp[i-1][j]+dp[i][j-1];
			}
		}
		for(int[] temp:dp) {
			for(int data:temp) {
				System.out.print(data+"\t");
			}
			System.out.println();
		}
		return dp[m-1][n-1];
	}
}
