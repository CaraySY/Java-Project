package com.wsy.array;

public class RemoveDuplicates {

	public static void main(String[] args) {
		
		int[] nums= {0,0,1,1,2};
		removeDuplicates2(nums);
	}
	
	/**
	 * 	��һ�Σ�set�������   2 2 3 5
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
	 * 	˫ָ�뷨�� ����ע������������ģ���ô�ظ���Ԫ��һ�������ڡ�
		Ҫ��ɾ���ظ�Ԫ�أ�ʵ���Ͼ��ǽ����ظ���Ԫ���Ƶ��������ࡣ
		������ 2 ��ָ�룬һ����ǰ���� p��һ���ں���� q���㷨�������£�
		1.�Ƚ� p �� q λ�õ�Ԫ���Ƿ���ȡ�
		�����ȣ�q ���� 1 λ
		�������ȣ��� q λ�õ�Ԫ�ظ��Ƶ� p+1 λ���ϣ�p ����һλ��q ���� 1 λ
		�ظ��������̣�ֱ�� q �������鳤�ȡ�
		���� p + 1����Ϊ�����鳤�ȡ�
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates2(int[] nums) {
		
		if(nums==null || nums.length==0) {
			return 0;
		}
		int p=0; // p��ǰ
		int q=1; //q�ں�
		while(q<nums.length) {
			//��� p��qָ����ֲ���ͬ�����֣���qָ�븴�Ƶ�p+1λ�ô� p|qͬʱ�ƶ�ָ��
			if(nums[p]!=nums[q]) {
				nums[p+1]=nums[q];
				p++;
				q++;
			}else { //������ͬ������ ��qָ����ƣ�pָ�벻��
				q++;
			}
		}
		return p+1;//pָ�����±꣬����Ҫ��һ
	}
}
