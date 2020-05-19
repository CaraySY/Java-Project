package com.syw.min_distance;

import java.util.Arrays;

public class Floyd {

	private Graph graph;
	
	public Floyd(char[] vertexs,int[][] dis) {
		
		graph=new Graph(vertexs,dis,vertexs.length);
	}
	
	public void showGraph() {
		
		System.out.println("邻接矩阵：");
		for(int[] temp : graph.dis) {
			for(int data:temp) {
				System.out.printf("%10d",data);
			}
			System.out.println();
		}
		System.out.println("前驱顶点：");
		for(int[] temp :graph.pre) {
			for(int data:temp) {
				System.out.print(data+"\t");
			}
			System.out.println();
		}
		System.out.println("顶点集合：");
		System.out.println(Arrays.toString(graph.vertexs));
	}
	
	public void floyd() {
		
		// k为中间顶点 
		for(int k=0;k<graph.length;k++) {
			//i为出发顶点
			for(int i=0;i<graph.length;i++) {
				//j到到达顶点
				for(int j=0;j<graph.length;j++) {
					// len代表 从出发顶点i到终点j，如果经过中间顶点k的距离小于从i到j的距离
					// 替换顶点i到j的路径为len
					int len=graph.dis[i][k]+graph.dis[k][j];
					if(len < graph.dis[i][j]) {
						graph.dis[i][j]=len;
						//更新 j 的前驱顶点为k
						graph.pre[i][j]=graph.pre[k][j];
					}
				}
			}
		}
	}
	
	private class Graph{
		
		private char[] vertexs; //顶点集合
		private int[][] dis; //邻接矩阵
		private int[][] pre; //各个顶点的前驱顶点
		private int length; //顶点个数
		
		public Graph(char[] vertexs, int[][] dis,int lenght) {

			this.vertexs = vertexs;
			this.dis = dis;
			this.pre=new int[lenght][lenght];
			this.length=lenght;
			for(int i=0;i<lenght;i++) {
				Arrays.fill(pre[i], i); //刚开始，各个顶点的初始顶点为自身
			}
		}
	}
}
