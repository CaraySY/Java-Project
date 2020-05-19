package com.wsy.array;

import java.util.Arrays;

public class DistributeCandies {

	public static void main(String[] args) {
		
		int candies=60;
		int num_people=4;
		int[] res=distributeCandies2(candies,num_people);
		System.out.println(Arrays.toString(res));
	}
	
	//使用求模运算可以实现循环遍历数组 0->n->0
	public static int[] distributeCandies(int candies, int num_people) {
		
		int[] ans=new int[num_people];
		int i=0; //控制下标
		int n=1; //糖果个数
		while(sum(ans,i) < candies){
			ans[i]=ans[i]+n;
			candies=candies-n; //糖果树减少
			n++;
			i=(++i)%num_people;
		}
		//最后剩的给予最后一个-->最后停留的位置不确定，需要求模运算
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
