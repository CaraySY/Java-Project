package com.wsy.array;

public class RemoveElement {

	public static void main(String[] args) {
		
		int[] nums={3,2,2,3};
		int count=removeElement(nums, 3);
		System.out.println(count);
	}
	
	/**
	 * 	 
	 * @param nums ԭʼ����
	 * @param val ��Ҫ�Ƴ�������
	 * @return ����ĳ���
	 */
	public static int removeElement(int[] nums,int val) {
		
		if(nums==null || nums.length==0) {
			return 0;
		}
		int index=0;//ÿ�α���ȡ��һ�����֣�ͬʱ����һ���±� ans������ͬ�͸��ƿ���
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=val) {
				nums[index++]=nums[i]; //�൱���������飬index������һ��������val��������ͬ��
				//�����ָ��Ƶ�indexָ������顣��
			}
		}
		return index;
	}
}
