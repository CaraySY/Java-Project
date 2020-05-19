package com.wsy.dp;

public class MaxSubArray {

	public static void main(String[] args) {
		
		int[] nums= {-2,-1};
		int res=maxSubArray(nums);
		System.out.println(res);
	}
	
	/**
	 * 	1������dp[i] Ϊǰi�����������е����ֵ
	 *  -- �磺 2 4 5 �ٶ���ǰdp[i]=5 �����������
                                1.ת��Ϊ  dp[i]=d[i-1]+nums[i]
	 *  --                      2.ת��Ϊ dp[i]=nums[i]������ ��ǰֵ����ǰ��֮��
	 *  2�����ƹ�ʽ��dp[i]=max{dp[i-1]+nums[i],nums[i]} 
	 *  3��ȷ����ʼֵ��i=0,dp[i]=nums[0]
	 * @param nums
	 * @return
	 */
    public static int maxSubArray(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int[] dp=new int[nums.length];
        dp[0]=nums[0];

        for(int i=1;i<dp.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int res=dp[0];
        for(int i=0;i<dp.length;i++){
            res=Math.max(res,dp[i]);
        }
        return res;
    }
    
}
