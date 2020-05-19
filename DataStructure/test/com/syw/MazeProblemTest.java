package com.syw;

import org.junit.Test;

import com.syw.recursion.MazeProblem;

public class MazeProblemTest {

	private final int ROW=8;
	private final int COL=7;
	
	/**
	 * �Թ�����˵����
	 *  1��map��ʾ�Թ�
	 *  2��(i,j) ��ʾ�Թ���λ�ã���(1,1)��ʼ
	 *  3������ߵ�(6,5)��˵��ͨ·�ҵ�
	 *  4��Լ����
	 *  	0����ʾ�õ�û���߹�
	 *  	1����ʾǽ
	 *  	2����ʾͨ·
	 *  	3����ʾ�߹��ĵ㣬���޷���ͨ
	 *  5�����Թ�ȷ���ߵĲ���
	 *  	[��->��->��->��] �߲�ͨ�����
	 */
	@Test
	public void fun1() {
		
		MazeProblem maze=new MazeProblem();
		int[][] map=new int[8][7];
		System.out.println("��ʼ���Թ�...");
		maze.initMaze(map,ROW,COL);
		maze.setWay(map, 1, 1);
		System.out.println("С��ʼ���Թ�...");
		maze.print(map);
	}
}
