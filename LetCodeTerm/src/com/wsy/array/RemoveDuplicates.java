package com.wsy.array;

public class RemoveDuplicates {

	public static void main(String[] args) {
		
		int[] nums= {0,0,1,1,2};
		removeDuplicates2(nums);
	}
	
	/**
	 * 	第一次：set是无序的   2 2 3 5
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates(int[] nums) {
		
		/*
		 * Set<Integer> set=new HashSet<>(); for(int temp : nums) { set.add(temp); } int
		 * index=0; for(int data:set) { nums[index++]=data; } return set.size();
		 */
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]==nums[j]) {
					nums[j]=nums[j+1];
				}
			}
		}
		return 0;
	}
	
	/**
	 * 	双指针法， 首先注意数组是有序的，那么重复的元素一定会相邻。
		要求删除重复元素，实际上就是将不重复的元素移到数组的左侧。
		考虑用 2 个指针，一个在前记作 p，一个在后记作 q，算法流程如下：
		1.比较 p 和 q 位置的元素是否相等。
		如果相等，q 后移 1 位
		如果不相等，将 q 位置的元素复制到 p+1 位置上，p 后移一位，q 后移 1 位
		重复上述过程，直到 q 等于数组长度。
		返回 p + 1，即为新数组长度。
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates2(int[] nums) {
		
		if(nums==null || nums.length==0) {
			return 0;
		}
		int p=0; // p在前
		int q=1; //q在后
		while(q<nums.length) {
			//如果 p、q指针出现不相同的数字，将q指针复制到p+1位置处 p|q同时移动指针
			if(nums[p]!=nums[q]) {
				nums[p+1]=nums[q];
				p++;
				q++;
			}else { //出现相同的数字 ，q指针后移，p指针不动
				q++;
			}
		}
		return p+1;//p指针是下标，个数要加一
	}
}
