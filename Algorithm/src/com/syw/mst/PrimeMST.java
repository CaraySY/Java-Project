package com.syw.mst;

import java.util.Arrays;

public class PrimeMST {

	private MGraph graph=new MGraph();
	/**
	 * 	创建图
	 * @param vertexs
	 * @param data
	 * @param weight
	 */
	public void createGraph(int vertexs,char[] data,int[][] weight) {
		
		graph.vertexs=vertexs;
		graph.data=data;
		graph.weight=weight;
	}
	
	/**
	 * @param start 从某个顶点开始, 'A'->0 'B'->1
	 */
	public void prime(int start) {
		
		int count=0;
		boolean[] isVisited=new boolean[graph.vertexs]; //创建一个布尔数组，标记顶点是否已经访问过
		isVisited[start]=true;
		int h1=-1; //当前已访问过的顶点下标
		int h2=-2; //待访问的顶点下标
		int minLen=10000; //设置当前顶点间不可达
		//最终生成的边应该等于 顶点数减去 1 ,从第一个顶点开始找顶点间的最小权值 因此只用循环 [1,vertexs-1)
		for(int k=1;k<graph.vertexs;k++) {
			for(int i=0;i<graph.vertexs;i++) { // i表示已访问顶点下标
				for(int j=0;j<graph.vertexs;j++) { //	没有访问的顶点下标
					//graph.weight[i][j] < minLen ,因为初始化 minLen为无穷大，
					//出现两个顶点权值也无穷大，代表两顶点不可达，跳过
					//否则将当前最值设为最小权值
					if(isVisited[i] && !isVisited[j] && graph.weight[i][j] < minLen) {
						minLen=graph.weight[i][j];
						h1=i;
						h2=j; //记录找到一个访问过的顶点到另一个刚访问过后的顶点
					}
				}
			}
			//标记刚访问的顶点为已经访问过
			isVisited[h2]=true;
			count+=minLen;
			System.out.printf("边<%c,%c>的最小权值：%d \n",graph.data[h1],graph.data[h2],minLen);
			//重置minLen，继续寻找下一个顶点
			minLen=10000;
		}
		System.out.println("使用Prime算法最小生成树权值为："+count);
	}
	
	public void print(int[][] weight) {
		
		for(int[] temp : weight) {
			System.out.println(Arrays.toString(temp));
		}
	}
	
	@SuppressWarnings("unused")
	private class MGraph {
		
		private int vertexs; //顶点的个数
		private char[] data; //保存顶点
		private int[][] weight; //边的权值
		
		public MGraph() {
			
		}
		
		public MGraph(int vertexs, char[] data, int[][] weight) {

			this.vertexs = vertexs;
			this.data = data;
			this.weight = weight;
		}
	}
}
