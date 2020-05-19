package com.syw.divide_and_conquer;

/**
 * 	汉诺塔是一个分治算法的经典案例
 * 	A  B  C  为三个柱子
 * 		N ： 盘子的个数
 *   N=1  -> 从   a->c
 *   N=2  -> 从   a->b a->c b->c
 *   ...
 *   N > 2 看做上下两个盘，最下面只有一个盘
 *   递归可以得出 ： 总是先将上面的一个盘从a放到b，将下面的盘从a放到c，最后将b的盘放到c [ a->b a->c b->c]
 * @author Administrator
 *
 */
public class HanorTower {

	public static void main(String[] args) {
		
		hanorTower(3,'A','B','C');
	}
	
	public static void hanorTower(int num,char a,char b,char c) {
		
		if(num==1) { //只有一个盘的时候
			System.out.printf("从:%c -> %c\n",a,c);
		}else {
			//将从上到下的 1~N-1个盘从：a->b
			hanorTower(num-1,a,c,b); // 如：3个盘，将(a)1->c,(a)2->b,(c)2->b 需借助c，先移动到c
			//将第n个盘从：a->c
			System.out.printf("从:%c -> %c\n",a,c);
			//将从上到下的 1~N-1个盘从：b->c
			hanorTower(num-1, b, a, c); //如：3个盘，将(b)1->a,(b)2->c,(a)1->c 需借助a，先移动到a
		}
	}
}
