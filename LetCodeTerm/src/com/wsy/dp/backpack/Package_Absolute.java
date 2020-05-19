package com.wsy.dp.backpack;

import java.util.Scanner;

public class Package_Absolute {

private static Scanner keyboard=new Scanner(System.in);
	
	public static void main(String[] args) {

		int N,V; //��Ʒ�������������
		N=keyboard.nextInt();
		V=keyboard.nextInt();
		int[] v=new int[N]; //��Ʒ�����
		int[] w=new int[N]; //��Ʒ�ļ�ֵ
		for(int i=0;i<N;i++) {
			v[i]=keyboard.nextInt();
			w[i]=keyboard.nextInt();
		}
		int res=advance_2(v,w,N,V);
		System.out.println(res);
	}

	/**
	 * 	��ȫ�������⣬ÿ����Ʒ���Է�������������޸�[�����㷨]---�Ż�:��ȫ��������ѭ����0-1����������ѭ��
	 * @param v
	 * @param w
	 * @return
	 */
	//�����㷨
	public static int package_Absolute(int[] v,int[] w,int N,int V) {
		
		int[][] dp=new int[N+1][V+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=V;j++) {
				for(int k=0;k*v[i-1]<=j;k++) { //�������ص��㷨
					if(j<v[i-1]) {
						dp[i][j]=dp[i-1][j];
					}else {
						dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-k*v[i-1]]+k*w[i-1]);
					}
				}
			}
		}
		return dp[N][V];
	}
	
	/*�Ż��㷨1������K*/	
	public static int advance_1(int[] v,int[] w,int N,int V) {
		
		int[][] dp=new int[N+1][V+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=V;j++) { 
				if(j<v[i-1]) {
					dp[i][j]=dp[i-1][j];
				}else {
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-v[i-1]]+w[i-1]);
				}
			}
		}
		return dp[N][V];
	}
	
	/**
	 * �Ż�2��ʹ��һά���飬����ѭ��
	 * @param v
	 * @param w
	 * @param N
	 * @param V
	 * @return
	 */
	public static int advance_2(int[] v,int[] w,int N,int V) {
		
		int[] dp=new int[V+1];
		for(int i=1;i<=N;i++) {
			for(int j=v[i-1];j<=V;j++) { //j���������ֱ�Ӵ�v[i]��ʼ
				dp[j]=Math.max(dp[j],dp[j-v[i-1]]+w[i-1]);
			}
		}
		return dp[V];
	}
}
