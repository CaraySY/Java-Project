package com.wsy.number;

public class PalindromeNumber {

	public static void main(String[] args) {
		
		boolean flag=isPalindromeNumber2(12321);
		System.out.println(flag);
	}
	
	/**
	 * 	暴力匹配
	 * @param x
	 * @return
	 */
	public static boolean isPalindromeNumber(int x) {
		
		if(x<0) {
			return false;
		}
		int[] stack=new int[(x+"").length()];
		int index=0;
		while(x!=0) {
			int pop=x%10; //求余数，取出每一位
			stack[index++]=pop;
			x=x/10;
		}
		for(int i=0,j=stack.length-1;i<stack.length && j>=0;i++,j--) {
			if(stack[i]==stack[j]) {
				continue;
			}else {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 	判断一个整数的一半就可以，顺便解决了溢出问题
	 *  0是特殊的回文数
	 *   我们将原始数字除以 10，然后给反转后的数字乘上 10，
	 *   所以，当原始数字小于反转后的数字时，就意味着我们已经处理了一半位数的数字
	 * @param x
	 * @return
	 */
	public static boolean isPalindromeNumber2(int x) {
		
		/**
		 * 	如果最后一位为 0 ，第一位必定为0才能使回文数-->x=0
		 */
		if(x < 0 || (x%10==0 && x!=0)) {
			return false;
		}
		/**
		 * 对于数字 1221，如果执行 1221 % 10，我们将得到最后一位数字 1，
		 * 要得到倒数第二位数字，我们可以先通过除以 10 把最后一位数字从 1221 中移除，1221 / 10 = 122，
		 * 再求出上一步结果除以 10 的余数，122 % 10 = 2，就可以得到倒数第二位数字。如果我们把最后一位数字乘以 10，
		 * 再加上倒数第二位数字，1 * 10 + 2 = 12，
		 * 就得到了我们想要的反转后的数字。如果继续这个过程，我们将得到更多位数的反转数字
		 */
		int revertedNumber=0;
		while(x > revertedNumber) { // 保证前半部数字大于等于后半部
			revertedNumber=revertedNumber*10+x%10;
			x= x /10 ;
		}
		//当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
		return x == revertedNumber || x == revertedNumber/10;
	}
}
