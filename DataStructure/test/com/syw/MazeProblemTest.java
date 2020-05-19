package com.syw;

import org.junit.Test;

import com.syw.recursion.MazeProblem;

public class MazeProblemTest {

	private final int ROW=8;
	private final int COL=7;
	
	/**
	 * 迷宫问题说明：
	 *  1、map表示迷宫
	 *  2、(i,j) 表示迷宫的位置，从(1,1)开始
	 *  3、如果走到(6,5)，说明通路找到
	 *  4、约定：
	 *  	0：表示该点没有走过
	 *  	1：表示墙
	 *  	2：表示通路
	 *  	3：表示走过的点，但无法走通
	 *  5、走迷宫确定走的策略
	 *  	[下->右->上->左] 走不通则回溯
	 */
	@Test
	public void fun1() {
		
		MazeProblem maze=new MazeProblem();
		int[][] map=new int[8][7];
		System.out.println("初始化迷宫...");
		maze.initMaze(map,ROW,COL);
		maze.setWay(map, 1, 1);
		System.out.println("小球开始走迷宫...");
		maze.print(map);
	}
}
