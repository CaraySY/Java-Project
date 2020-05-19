package com.wsy.prime;

import org.junit.Test;

import com.syw.min_distance.Dijkstra;

public class DijkstraTest {

	@Test
	public void fun1() {
		
		char[] vertexs = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		//邻接矩阵
		int[][] matrix = new int[vertexs.length][vertexs.length];
		final int N = 65535;// 表示不可以连接
		matrix[0]=new int[]{N,5,7,N,N,N,2};  
        matrix[1]=new int[]{5,N,N,9,N,N,3};  
        matrix[2]=new int[]{7,N,N,N,8,N,N};  
        matrix[3]=new int[]{N,9,N,N,N,4,N};  
        matrix[4]=new int[]{N,N,8,N,N,5,4};  
        matrix[5]=new int[]{N,N,N,4,5,N,6};  
        matrix[6]=new int[]{2,3,N,N,4,6,N};
        Dijkstra dis=new Dijkstra(vertexs,matrix);
        System.out.println("邻接矩阵如下：");
        dis.showGraph();
        dis.dijkstra(2);
        dis.showDijkstra();
	}
}
