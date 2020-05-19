package com.wsy.exam.test;

import java.util.Scanner;

public class PurchaseList {

	private static int[][] dp;
	private static int N,m;//N��Ǯ����mϣ���������Ʒ����
	private static Scanner keyboard=new Scanner(System.in);
	
	// N<32000 m<60 һ������ֻ�ܶ�Ӧ0,1,2���Ӽ�
	public static void main(String[] args) {

		N=keyboard.nextInt();
		m=keyboard.nextInt();
		dp=new int[m+1][N+1];
		/*�������Ӽ���value��һ����ά����,���������Ӽ��ļ۸�*/
		int[][] value=new int[m+1][3];
		/*important��һ����ά���飬���������Ӽ�����Ҫ��*/
		int[][] important=new int[m+1][3];
		/*��������*/
		init(value,important);
		int res = list(value,important);
		System.out.println(res);
		keyboard.close();
	}
	
	/**
	 * 	��ʼ����Ʒ�ļ۸���Ҫ�ȵ�����
	 * @param value ��Ʒ�۸� [0,1,2]�����������Ӽ�1���Ӽ�2
	 * @param important ��Ҫ��
	 */
	public static void init(int[][] value, int[][] important) {
		
		int q,p,v;// p��ʾ��Ʒ��Ҫ�ȣ�q����������/����,v�Ǽ۸�
		//q=0������Ʒ������ ����� q>0 ����ʾ����ƷΪ������ q �����������ı�ţ�---�Ӽ�ͬ�������
		// ��ʼ����Ʒ
		for (int i = 1; i < m + 1; i++) { // �ӱ��1��ʼ����Ϊq=0������
			v = keyboard.nextInt(); // ��Ʒ�۸�
			p = keyboard.nextInt(); // ��Ҫ��
			q = keyboard.nextInt(); // q�ж����Ӽ�,q���������ı��
			if (q == 0) {
				// ���q����0��i���������ı��
				value[i][0] = v;
				important[i][0] = p;
			} else {
				//�����Ų�Ϊ0����ô��ʱq������ǸôӼ��������ı��
				if (value[q][1] == 0) { //�ж��Ƿ��Ѿ����˵�һ���Ӽ�
					value[q][1] = v;//����������Ÿ�ֵ���Ӽ�
					important[q][1] = p;
				} else {
					value[q][2] = v;
					important[q][2] = p;
				}
			}
		}
	}
	
	/**
	 * 	���������ѡ���Ӽ�����ѡ������������+1�ŴӼ�������+2�ŴӼ�������+1/2�ŴӼ�
	 *  dp[i,j] ������Ǯ��Ϊ j������£���ǰi����Ʒ�й�����Ʒ�����۸�
	 * @param value
	 * @param important
	 * @return
	 */
	public static int list(int[][] value,int[][] important) {
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<N+1;j++) {
				
				dp[i][j]=dp[i-1][j];
				//ѡ����������+1�ŴӼ�������+2�ŴӼ�������+1/2�ŴӼ�
				if(j-value[i][0]>=0) {
					dp[i][j]=Math.max(dp[i][j], 
							dp[i-1][j-value[i][0]]+
							value[i][0]*important[i][0]);
				}
				if(j-value[i][0]-value[i][1]>=0) { //�� ��1
					dp[i][j]=Math.max(dp[i][j], 
							dp[i-1][j-value[i][0]-value[i][1]]+
							value[i][0]*important[i][0]+
							value[i][1]*important[i][1]);
				}
				if(j-value[i][0]-value[i][2]>=0) { //����2
					dp[i][j]=Math.max(dp[i][j], 
							dp[i-1][j-value[i][0]-value[i][2]]+
							value[i][0]*important[i][0]+
							value[i][2]*important[i][2]);
				}
				if(j-value[i][0]-value[i][1]-value[i][2]>=0) { //����1 2
					dp[i][j]=Math.max(dp[i][j], 
							dp[i-1][j-value[i][0]-value[i][1]-value[i][2]]+
							value[i][0]*important[i][0]+
							value[i][1]*important[i][1]+
					        value[i][2]*important[i][2]);
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}
}
