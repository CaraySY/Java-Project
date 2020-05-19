package com.wsy.number;

import java.util.HashMap;
import java.util.Map;

/**
 * 	
 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
 * @author Administrator
 *
 */
public class TwoNumberSum {

	public static void main(String[] args) {
		
		int[] nums= {2,7,11,15};
		//System.out.println(Arrays.toString(twoSum(nums,9)));
		twoSum2(nums,9);
	}
	
	/**
	 * 	暴力匹配(自己写)
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] nums,int target) {
		
		//修改--(参考答案)
		for (int i = 0; i < nums.length; i++) {
				for (int j = i+1; j < nums.length; j++) {
					if(nums[j]==target-nums[i]) {
						return new int[] {i,j};
				}
			}
		}
		throw new RuntimeException("No two sum solution...");
		//修改前--自写
/*		int[] res=null;
		boolean flag = false;
		for (int i = 0; i < nums.length; i++) {
			if (flag) {
				break;
			} else {
				for (int j = 0; j < nums.length; j++) {
					if (i == j) {
						continue;
					} else {
						if (nums[i] + nums[j] == target) {
							res=new int[] {i,j};
							flag = true;
							break;
						}
					}
				}
			}
		}
		return res;
*/
	}
	//使用hashMap，hash能快速查找数组是否包含该target
	public static int[] twoSum2(int[] nums,int target) {
		
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			map.put(nums[i],i); //将nums的元素作为key放入HashMap中
		}
		for(int i=0;i<nums.length;i++) {
			int complement=target-nums[i]; //HashMap的另一个数
			//map.get(complement)-->保证不重复使用同一个数--> 获取nums数组里的数据
			if(map.containsKey(complement) && map.get(complement)!=i) {
				return new int[] {i,map.get(complement)};
			}
		}
		throw new RuntimeException("No two sum solution...");
	}
	
	
	
	
	
	
}
