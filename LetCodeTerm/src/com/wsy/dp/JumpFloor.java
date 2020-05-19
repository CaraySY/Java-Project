package com.wsy.dp;

/**
 * 
 * 	��̬�滮�㷨(Dynamic Programma Algorithm[DP]) [������dp�㷨��һ�ָ�Ч��ö���㷨]
 *  ���ⲽ���Ϊ5����
 *  	1���ж������Ƿ������Ž�
 *  	2�������µ��·������ֽ������⣬�����⻹���Լ����ֽ�
 *  	3�����ϵ��·�������Ĺ������ҳ�״̬ת�Ʒ���
 *  	4�����Ǳ߽����
 *  	5�����ʵ������
 *  eg��������¥������
 *   ÿ��ֻ����һ�׻��߶���
 * @author Administrator
 *
 */
public class JumpFloor {

	public static void main(String[] args) {
		
		System.out.println(waysToStep(61));
	}
	
	/**
	 * eg������Ҫ����6�ף����ж�����������
	 *  ���һ���������������Ρ���һ�� -> f(6)=f(4)+f(5) [�ӿ�ʼ�����Ľ��������� + �ӿ�ʼ�����������������]
	 *  	-> f(5)=f(4)+f(3)=8��
	 *  	-> f(4)=f(3)+f(2)=5��
	 *  	-> f(3)=f(2)+f(1)=3��
	 *  	-> f(2)=f(1)+f(0)=2�֡���
	 *  	-> f(1)=1��
	 *  n>=3��  fn = fn-1 + fn-2;
	 *  
	 *  n ������
	 * @return
	 */
	public static int jump(int n) {
		
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
		if(n==3) {
			return 4;
		}
		int[] ans=new int[n+1]; //������
		ans[0]=0;
		ans[1]=1;
		ans[2]=2;//��������
		for(int i=3;i<=n;i++) { // i ֻ�� n-1������Ҫ����
			ans[i]=ans[i-1]+ans[i-2];
		}
		return ans[n];
	}
	
	public static int waysToStep(int n) {
		
		long[] dp=new long[n+1];
		dp[0]=0;//���0�ַ�ʽ
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		for(int i=4;i<=n;i++) {
			dp[i]=(dp[i-1]+dp[i-2]+dp[i-3])%1000000007;
		}
		return (int)dp[n];
	}
}
