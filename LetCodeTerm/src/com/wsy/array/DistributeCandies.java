package com.wsy.array;

import java.util.Arrays;

public class DistributeCandies {

	public static void main(String[] args) {
		
		int candies=60;
		int num_people=4;
		int[] res=distributeCandies2(candies,num_people);
		System.out.println(Arrays.toString(res));
	}
	
	//ʹ����ģ�������ʵ��ѭ���������� 0->n->0
	public static int[] distributeCandies(int candies, int num_people) {
		
		int[] ans=new int[num_people];
		int i=0; //�����±�
		int n=1; //�ǹ�����
		while(sum(ans,i) < candies){
			ans[i]=ans[i]+n;
			candies=candies-n; //�ǹ�������
			n++;
			i=(++i)%num_people;
		}
		//���ʣ�ĸ������һ��-->���ͣ����λ�ò�ȷ������Ҫ��ģ����
		ans[i%num_people]=ans[i%num_people]+candies;
		return ans;
	}
	
	
	public static int[] distributeCandies2(int candies, int num_people) {
		
		int[] ans=new int[num_people];
		int i=0;
		while(candies!=0) {
			ans[i%num_people]+=Math.min(candies, i+1);
			candies-=Math.min(candies, i+1);
			i++;
		}
		return ans;
	}
	
	public static int sum(int[] ans,int n) {
		
		int sum=0;
		for(int i=0;i<n;i++) {
			sum+=ans[i];
		}
		return sum;
	}
}
