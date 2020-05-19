package com.syw.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 	图的创建：邻接表和邻接矩阵
 * @author Administrator
 *
 */
//使用邻接矩阵创建图
public class Graph {

	private List<String> vertexs; //保存顶点的List--->方便插入
	private int count; //边的条数 
	private int[][] edges; //邻接数组
	private boolean[] isVisited; //记录图周游过程访问过的顶点
	
	public Graph(int n) {
		
		this.vertexs=new ArrayList<>(n);
		this.edges=new int[n][n];
		this.count=0;
		this.isVisited=new boolean[n];
	}
	
	/**
	 * 	添加顶点
	 * @param vertex
	 */
	public void add(String vertex) {
		
		vertexs.add(vertex);
	}
	
	/**
	 * 	创建边的关系
	 * @param vertex1  顶点1
	 * @param vertex2  顶点2
	 * @param weight 权值
	 */
	public void insertEdge(String vertex1,String vertex2,int weight) {
		
		int indexVal1=vertexs.indexOf(vertex1);
		int indexVal2=vertexs.indexOf(vertex2);
		edges[indexVal1][indexVal2]=weight; //无序图
		edges[indexVal2][indexVal1]=weight; //无序图
		count++;
	}
	
	public void printEdges() {
		
		for(int[] edge : edges) {
			for(int data : edge) {
				System.out.print(data+" ");
			}
			System.out.println();
		}
	}
	
	public int getCount() {
		
		return count;
	}
	
	public int getVertexNum() {
		
		return vertexs.size();
	}
	
	/**
	 * 	重载dfs函数，实现当前顶点找不到第一个邻接顶点时的递归返回，从下一个顶点开始进行dfs
	 */
	public void dfs() {
		
		for(int i=0;i<vertexs.size();i++) {
			if(!isVisited[i]) {
				dfs(isVisited,i); //在回溯的过程中，某个顶点可能已经访问过
			}
		}
	}
	
	public void bfs() {
		
		for(int i=0;i<vertexs.size();i++) {
			if(!isVisited[i]) {
				bfs(isVisited,i); //在回溯的过程中，某个顶点可能已经访问过
			}
		}
	}
	
	
	
	/**
	 *  <strong>深度优先遍历</strong>算法：<br>
	 * + 访问初始顶点v，并标记顶点为已访问 <br>
	 * + 查找结点v的第一个邻接顶点w <br>
	 * + 若w存在，则执行下一步，w不存在，则返回第一步，将从v的下一个顶点继续 <br>
	 * + 若w未被访问，对w进行深度优先遍历递归(即把w当做另一个v，然后进行1 2 3步) <br>
	 * + 查找结点v的w邻接结点的下一个邻接结点，转回步骤3 <br>
	 * 
	 * @param isVisited 顶点是否访问过的数组 <br>
	 * @param v 当前遍历的顶点的下标 <br>
	 */
	private void dfs(boolean[] isVisited,int v) {
		
		//1、访问初始顶点
		System.out.print(vertexs.get(v)+"->");
		isVisited[v]=true; //将当前顶点设置为已经访问
		//2、查找第一个邻接顶点
		int w=getFirstNeighbor(v);
		//3、通过w循环递归进行DFS
		while(w!=-1) {
			if(!isVisited[w]) { //当前顶点的下一个顶点没有访问过
				dfs(isVisited,w);
			}
			w=getNextNeighbor(v, w); //如果访问过，把w做另一个v开始dfs
		}
	}
	
	/**
	 * 	<b>广度优先遍历算法</b> <br>
	 * 	+ 访问初始顶点v，并标记顶点v为已访问 <br>
	 *  + 顶点v入队列 <br>
	 *  + 当队列为空时，继续执行，否则算法结束 <br>
	 *  + 出队列，取得队列头顶点u <br>
	 *  + 查找顶点u的顶一个邻接顶点w <br>
	 *  + 若顶点u的邻接顶点w不存在，则转到步骤3；否则循环执行如下步骤 <br>
	 *  	-若顶点w未被访问，则访问顶点w并标记为已访问 <br>
	 *  	-顶点w入队列 <br>
	 *  	-查找顶点u的继w邻接顶点后的下一个邻接顶点w，转到步骤6 <br>
	 * @param isVisited
	 * @param u
	 */
	private void bfs(boolean[] isVisited,int v) {
		
		int u,w;
		//1、访问初始顶点
		System.out.print(vertexs.get(v)+"->");
		//标记为已访问
		isVisited[v]=true;
		//2、初始顶点入队列--->使用linkedList模拟队列的操作
		LinkedList<Integer> queue=new LinkedList<>();
		queue.addLast(v);
		//3、队列不为空，循环执行
		while(!queue.isEmpty()) {
			//头顶点出队列
			u=queue.removeFirst();
			//得到第一个邻接顶点 u 的下一个顶点w
			w=getFirstNeighbor(u);
			while(w!=-1) {
				if(!isVisited[w]) {
					// 若顶点w未被访问，则访问顶点w并标记为已访问
					System.out.print(vertexs.get(w)+"->");
					isVisited[w]=true;
					//入队列
					queue.addLast(w);
				}
				//以u为当前顶点，找到w后面的下一个邻接顶点
				w=getNextNeighbor(u, w);
			}
		}
	}
	
	/**
	 * 	返回当前结点的下一个邻接顶点
	 * @param v
	 * @return 返回下一个邻接顶点的下标
	 */
	private int getFirstNeighbor(int v) {
		
		for(int w=0;w<vertexs.size();w++) {
			if(edges[v][w] > 0) {
				return w;
			}
		}
		return -1;//找不到
	}
	
	/**
	 * 	
	 * @param v 当前顶点下标
	 * @param w 第一个邻接顶点顶点下标
	 * @return w 的第一个邻接顶点下标 v -> w -> z
	 */
	private int getNextNeighbor(int v,int w) {
		
		for(int z=w+1;z<vertexs.size();z++) {
			if(edges[v][z] > 0) {
				return z;
			}
		}
		return -1; //找不到
	}
}
