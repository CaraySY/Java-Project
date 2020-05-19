package com.wsy.dp.backpack;

import java.util.Scanner;

/**
 * 	���ر���������ÿ����Ʒ�������޸�
 * @author Administrator
 *
 */
public class Package_Massive {

	private static Scanner keyboard=new Scanner(System.in);
	
	public static void main(String[] args) {

		/*	1 2 3
			2 4 1
			3 4 3
			4 5 2
		int N,V; //��Ʒ�������������
		N=keyboard.nextInt();
		V=keyboard.nextInt();
		int[] v=new int[N]; //��Ʒ�����
		int[] w=new int[N]; //��Ʒ�ļ�ֵ
		int[] s=new int[N]; //��Ʒ������
		for(int i=0;i<N;i++) {
			v[i]=keyboard.nextInt();
			w[i]=keyboard.nextInt();
			s[i]=keyboard.nextInt();
		}
		int res=package_Massive1(v,w,s,N,V);
		*/
		int res=package_Massive2();
		System.out.println(res);
	}
	
	/**
	 * 	���ض��ر�������
	 * @param v
	 * @param w
	 * @param s  
	 * @param N
	 * @param V
	 * @return
	 */
	public static int package_Massive(int[] v, int[] w,int[] s ,int N,int V) {

		int[][] dp=new int[N+1][V+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=V;j++) {
				for(int k=0;k*v[i-1]<=j && k<=s[i-1];k++) { 
					dp[i][j]=dp[i-1][j];//�����뵱ǰ��Ʒ
					dp[i][j]=Math.max(dp[i][j], dp[i-1][j-k*v[i-1]]+k*w[i-1]);
				}
			}
		}
		return dp[N][V];
	}
	
	/**
	 * 	һά�����Ż�
	 * @param v
	 * @param w
	 * @param s
	 * @param N
	 * @param V
	 * @return
	 */
	public static int package_Massive1(int[] v, int[] w,int[] s ,int N,int V) {
		
		int[] dp=new int[V+1];
		for(int i=1;i<=N;i++) {
			for(int j=V;j>=v[i-1];j--) { //���ر�����0-1��������ʹ�� һά�����Ż�ʹ�õ���ѭ��
				for(int k=0;k*v[i-1]<=j && k<=s[i-1];k++) { 
					dp[j]=Math.max(dp[j], dp[j-k*v[i-1]]+k*w[i-1]);
				}
			}
		}
		return dp[V];
	}
	
	/**
	 * 	ʹ�ö������Ż�Ϊ0-1��������
	 * 	�κ���������ת��Ϊ��2^0+2^1+2^2...(1+2+4+8+...+2^k + data(2^k+1 < data < 2^k+2)
	 * @param v
	 * @param w
	 * @param s
	 * @param N
	 * @param V
	 * @return
	 */
	public static int package_Massive2() {
		
		int tot=1;//ʹ�ö������Ż�ʱ����¼�Ż�������±곤��
		int N,V;
		N=keyboard.nextInt();
		V=keyboard.nextInt();
		int[] w=new int[10000]; //��ֵ
		int[] v=new int[10000]; //���
		for(int i=1;i<=N;i++) {
			int a=keyboard.nextInt();//���
			int b=keyboard.nextInt();//��ֵ
			int c=keyboard.nextInt();//����
			for(int k=1;k<=c;k<<=1) {//k=k*2
				v[tot]=a*k;
				w[tot]=b*k;
				c=c-k;
				tot++;
			}
			if(c>0) { //�������cҲһ����
				v[tot]=a*c;
				w[tot]=b*c;
				tot++;
			}
		}
		int[] dp=new int[10000];
		for(int i=1;i<=tot;i++) {
			for(int j=V;j>=v[i];j--) { //����ѭ��
				dp[j]=Math.max(dp[j], dp[j-v[i]]+w[i]);
			}
		}
		return dp[V];
	}
}

