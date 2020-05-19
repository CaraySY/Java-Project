package com.wsy.dp;

/**
 * һ�������İ�Ħʦ���յ�ԴԴ���ϵ�ԤԼ����ÿ��ԤԼ������ѡ��ӻ򲻽ӡ�
 * ��ÿ��ԤԼ����֮��Ҫ����Ϣʱ�䣬��������ܽ������ڵ�ԤԼ��
 * ����һ��ԤԼ�������У��水Ħʦ�ҵ����ŵ�ԤԼ���ϣ���ԤԼʱ������������ܵķ�������
 * @author Administrator
 *
 */
public class Massage {

	public static void main(String[] args) {
		
		int[] nums= {2,7,9,3,1};
		int res=massage(nums);
		System.out.println(res);
	}
	
	/**
	 * 	1.��Ϊ�� dp[i]���� �򲻽��ܣ��ƻ��˶�̬�滮���޺�Ч�ԡ���Ҫ����һ��[flag]->flag=0/1������ܡ�������
	 *  2.���ƹ�ʽ��dp[i][1]->����i��λ�ý���ת��Ϊ dp[i-1][0]+nums[i]
	 *  	�����ܣ�dp[i][0]=Max{dp[i-1][0],dp[i-1][1]}--ת��Ϊ��һ�������״̬���ܻ򲻿��ܽ������ֵ����ֵ
	 * @param nums
	 * @return
	 */
	public static int massage(int[] nums) {
		
		int[][] dp=new int[nums.length+1][2];// 0-1��Ҫ��λ
		for(int i=1;i<=nums.length;i++) {
			dp[i][1]=dp[i-1][0]+nums[i-1]; // ��Ϊi��1��ʼ nums��Ҫ��0��ʼ���ԣ�i-1
			dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
		}
		return Math.max(dp[nums.length][1],dp[nums.length][0]);
	}
}
