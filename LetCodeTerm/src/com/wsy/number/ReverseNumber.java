package com.wsy.number;

public class ReverseNumber {

	public static void main(String[] args) {
		
		int res=reverse2(12345);
		System.out.println(res);
	}
	
	/**
	 * 	不知道怎么判断反转后的整型是否已经溢出
	 * @param x
	 * @return
	 */
	public static int reverse(int x) {
		
		int res = 0;
		if(x > 0) {
			int strLen=(x+"").length();
			int[] ress=new int[strLen];
			for(int i=0,n=1;i<strLen;i++,n*=10) {
				ress[i]=x/n%10;
				if(ress[i] > Integer.MAX_VALUE / 10 || ress[i] == Integer.MAX_VALUE / 10 && ress[i] > 7) {
					return 0;
				}
			}
			for(int i=ress.length-1,n=1;i>=0;i--,n*=10) {
				res=res+ress[i]*n;
			}
			return res;
		}else {
			int strLen=(x+"").length()-1;
			int[] ress=new int[strLen];
			for(int i=0,n=1;i<strLen;i++,n*=10) {
				ress[i]=x/n%10;
				if(ress[i] < Integer.MIN_VALUE / 10 || ress[i] == Integer.MIN_VALUE / 10 && ress[i] < -8) {
					return 0;
				}
			}
			for(int i=ress.length-1,n=1;i>=0;i--,n*=10) {
				res=res+ress[i]*n;
			}
			return res;
		}
	}
	
	/**
	 * 	参考了答案，精简代码
	 * @param x
	 * @return
	 */
	public static int reverse2(int x) {

		int res = 0;
		while (x != 0) {
			int pop = x % 10;
			x = x / 10;
			if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7))
				return 0;
			if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8))
				return 0;
			res = res * 10 + pop;
		}
		return res;
	}
}
