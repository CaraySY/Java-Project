package com.wsy.dp;

public class MaxSubArray {

	public static void main(String[] args) {
		
		int[] nums= {-2,-1};
		int res=maxSubArray(nums);
		System.out.println(res);
	}
	
	/**
	 * 	1、定义dp[i] 为前i个连续子序列的最大值
	 *  -- 如： 2 4 5 假定当前dp[i]=5 ，两种情况，
                                1.转化为  dp[i]=d[i-1]+nums[i]
	 *  --                      2.转化为 dp[i]=nums[i]的问题 当前值大于前面之和
	 *  2、递推公式：dp[i]=max{dp[i-1]+nums[i],nums[i]} 
	 *  3、确定初始值：i=0,dp[i]=nums[0]
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
