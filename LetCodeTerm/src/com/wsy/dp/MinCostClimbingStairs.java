package com.wsy.dp;

/**
 * 	����һЩ����������Ҿ�����ʵ�Ϳ����ˣ�
 * �� 5 �⡢�� 53 �⡢�� 300 �⡢�� 72 �⡢�� 1143 �⡢
 * �� 62 �⡢�� 63 �⡢�������⣨�� 416 �⣬�� 494 �⣩��
 * Ӳ�����⣨�� 322 �⡢�� 518 �⣩����ҽ������⣨��ͷ���⼴�ɣ���
 * ��Ʊ���⡢�� 96 �⡢�� 139 �⡢�� 10 �⡢�� 91 �⡢
 * �� 221 �⡣��Щ���ǱȽϾ�������⣬˼·������--�Ե�����
 * @author Administrator
 *
 */
public class MinCostClimbingStairs {

	public static void main(String[] args) {

		int[] cost= {10,15,20};
		int res=minCostClimbingStairs(cost);
		System.out.println("res="+res);
	}

	/**
	 * 	1������dp[i]Ϊ��ǰ�����¥�����С����
	 *  2�����ƹ�ʽ��
	 *  	dp[i]=min{dp[i-1],dp[i-2]}+nums[i]
	 *  --�ο��˱��˵ģ��Ż�
	 * @param cost
	 * @return
	 */
	public static int minCostClimbingStairs(int[] cost) {

		return 0;
	}
}
