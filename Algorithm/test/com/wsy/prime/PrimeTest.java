package com.wsy.prime;

import org.junit.Test;

import com.syw.mst.PrimeMST;

public class PrimeTest {

	@Test
	public void fun1() {
		
		PrimeMST prime=new PrimeMST();
		//顶点
		char[] vertexs = new char[]{'A','B','C','D','E','F','G'};
		//邻接矩阵表 10000代表不连通
		int [][]weight=new int[][]{
            {10000,5,7,10000,10000,10000,2},
            {5,10000,10000,9,10000,10000,3},
            {7,10000,10000,10000,8,10000,10000},
            {10000,9,10000,10000,10000,4,10000},
            {10000,10000,8,10000,10000,5,4},
            {10000,10000,10000,4,5,10000,6},
            {2,3,10000,10000,4,6,10000},};
		prime.createGraph(vertexs.length, vertexs, weight);
		prime.print(weight);
		prime.prime(6);
	}
}
