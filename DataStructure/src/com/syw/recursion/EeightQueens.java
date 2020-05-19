package com.syw.recursion;

/**
 * 	使用一位数组来解决八皇后问题，数组下标表示放在第几行，数组的value表示放在第几列
 * @author Administrator
 *
 */
public class EeightQueens {

	private final int MAX=8;//表示皇后的个数
	
	private static int count=0;//八皇后的解法
	
	private int[] array=new int[MAX];
	
	/**
	 * 	check是每一次递归是，进入到check中 都有一个 for循环
	 * @param n 表示第 n 个皇后
	 */
	public void check(int n) {
		
		if(n==MAX) { // n==8 表示已经放置了8个皇后，应该输出结果
			print();
			return;
		}
		
		/*依次放入皇后，并且判断是否冲突*/
		for(int i=0;i<MAX;i++) {
			//先将当前的皇后n[ n同时控制着行数 ]放到改行的第i列
			array[n]=i;
			if(judge(n)) {
				check(n+1); //如果没有冲突，放置下一个皇后
			}
			/*如果有冲突，放到该行的下一列*/
		}
	}
	
	public int count() {
		
		return count;
	}
	
	/**
	 * 	A、数组下标表示放在第几行
	 * 	B、数组的value表示放在第几列
	 * @param n 表示第几个皇后放在棋盘上[不需要判断是否放在同一行] n已经控制行数，不会出现放置在同一行
	 * @return
	 */
	private boolean judge(int n) {
		
		for(int i=0;i<n;i++) {
			
			/*	array[i]==array[n] 表示第N的皇后和前面第i个皇后在同一列上 
			 * 
			 *  Math.abs(n-i)==Math.abs(array[n]-array[i]) 表示第N的皇后和前面第i个皇后在同一个斜线上
			 *  计算斜率的公式，k=(y1-y2)/(x1-x2) 
			 *  
			 *  返回false 不能放置
			 *  
			 */
			if(array[i]==array[n] || Math.abs(n-i)==Math.abs(array[n]-array[i])) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 	打印皇后拜访的结果
	 */
	private void print() {
		
		for(int i=0;i<array.length;i++) {
			
			System.out.printf("(%d,%d)",i,array[i]);
			if(i!=array.length-1) {
				System.out.print("->");
			}
		}
		System.out.println();
		count++;
	}
}
