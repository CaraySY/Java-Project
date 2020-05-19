package com.wsy.dp;

/**
 * 	��������Ԫ�صĺ͵����ֵ
 * @author Administrator
 *
 */
public class Rob {

	public static void main(String[] args) {
		
		int[] array= {0};
		int res=rob(array);
		System.out.println("res="+res);
	}
	
	/**
	 * 	1������dp[i] ΪС͵��ǰ���ܹ���ȡ���������
	 *  -- �磺 2 4 5 �ٶ���ǰdp[i]=5 �����������ѡ����num[i-1]����ѡ��ת��Ϊ  dp[i]=dp[i-2]�� nums[i]������
	 *  --                             ��ѡ����num[i-1]����ѡ��ת��Ϊ dp[i]=dp[i-1]������
	 *  2�����ƹ�ʽ��dp[i]=max{dp[i-2]+nums[i],dp[i-1]} 
	 *  3��ȷ����ʼֵ��i=0,dp[i]=nums[0] i=2,dp[i]=max(num[0],num[1])
	 * @param nums
	 * @return
	 */
	public static int rob(int[] nums) {
		
		if(nums==null || nums.length==0) {
			return 0;
		}
		if(nums.length==1) {
			return nums[0];
		}
		if(nums.length==2) {
			return Math.max(nums[0], nums[1]);
		}
		int[] dp=new int[nums.length];
		dp[0]=nums[0];
		dp[1]=Math.max(nums[0], nums[1]);
		int res=0;
		for(int i=2;i<nums.length;i++) {
			dp[i]=Math.max(dp[i-2]+nums[i], dp[i-1]);
			res=Math.max(res, dp[i]);
		}
		return res;
	}
}
