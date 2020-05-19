package com.syw.min_distance;

import java.util.Arrays;

public class Dijkstra {

	private Graph graph;
	private VisitedVertex v;
	private int start;
	
	public Dijkstra(char[] vertexs,int[][] matrix) {
		this.graph = new Graph(vertexs,matrix);
	}

	/**
	 * 	
	 * @param start 出发顶点的下标
	 */
	public void dijkstra(int start) {
		
		v=new VisitedVertex(graph.vertexs.length, start);
		this.start=start;
		update(start);
		//初始顶点已经访问，从下一个开始更新
		for(int i=1;i<graph.vertexs.length;i++) {
			int next=v.updateArr(); //获取并返回一个新的顶点--其到初始顶点的距离最小的顶点
			update(next); //更新下一个顶点
		}
	}
	
	/**
	 * 	更新下标为index的顶点到周围顶点的距离，和周围顶点的前驱顶点
	 * @param index
	 */
	private void update(int index) {
		
		int len=0; 
		//遍历第index行的 邻接矩阵
		for(int j=0;j<graph.matrix[index].length;j++) {
			//len表示 当前顶点index到出发顶点的距离 + index顶点到顶点j的距离
			len=v.getDis(index)+graph.matrix[index][j]; 
			if(!v.isVisited(j) && len < v.getDis(j)) {
				v.updateDis(j, len); //更新出发顶点到 j的距离
				v.updatePre(j, index); // 将j的前驱顶点设置为index
			}
		}
	}
	
	public void showGraph() {
		
		for(int[] temp : graph.matrix) {
			for(int data:temp) {
				System.out.printf("%10d",data);
			}
			System.out.println();
		}
	}
	
	public void showDijkstra() {
		
		v.show(graph,start);
	}
	
	/**
	 * 	已访问顶点类
	 * @author Administrator
	 *
	 */
	private class VisitedVertex{
		
		//记录每个顶点是否访问过，true：访问 false：未访问
		private boolean[] already_arr;
		//每个下标对应的值为前一个顶点的下标(动态更新)
		private int[] pre_visited;
		//记录出发顶点到其他所有顶点的距离
		//如：G为出发顶点，会记录G到其它顶点的距离，将最短的放入
		private int[] dis;
		
		/**
		 * 	构造器
		 * @param length 顶点的个数
		 * @param start 出发顶点
		 */
		public VisitedVertex(int length,int start) {
			this.already_arr = new boolean[length]; //初始化所有顶点未访问
			this.pre_visited = new int[length];
			this.dis = new int[length];
			Arrays.fill(dis, 65535);
			this.already_arr[start]=true;//设置出发顶点为已经访问
			dis[start]=0; //出发顶点访问距离为0
		}

		/**
		 *  判断下标为index的顶点是否访问过
		 * @param index
		 * @return true：访问过 false:未访问
		 */
		public boolean isVisited(int index) {
			return already_arr[index];
		}
		
		/**
		 * 	更新出发顶点到 下标为index顶点的距离
		 * @param index 下标
		 * @param len 距离 
		 */
		public void updateDis(int index,int len) {
			
			dis[index]=len;
		}
		
		/**
		 * 	将下标为pre的顶点的前驱结点更换为 index
		 * @param cur
		 * @param index
		 */
		public void updatePre(int cur,int index) {
			pre_visited[cur]=index;
		}
		
		/**
		 * 	返回出发顶点到下标为index的顶点的距离
		 * @param index
		 * @return 距离
		 */
		public int getDis(int index) {
			return dis[index];
		}
		
		/**
		 * 	继续寻找并且访问一个新的顶点-->如初始顶点为G，从dis数组中找到一个最小值，A作为新的访问顶点
		 * 	并且将A设置为已经访问
		 * @return
		 */
		public int updateArr() {
			
			int min=65535;
			int next=-1;
			for(int i=0;i<dis.length;i++) {
				//保存新的顶点没有被访问且权值最小
				if(!isVisited(i) && getDis(i) < min) {
					min=getDis(i);
					next=i;
				}
			}
			already_arr[next]=true;//标记为已经访问
			return next;
		}
		
		public void show(Graph graph,int start) {
			
			System.out.println("每个顶点访问情况：");
			System.out.println(Arrays.toString(already_arr));
			System.out.println("每个顶点的前驱顶点：");
			for(int i=0;i<graph.vertexs.length;i++) {
				System.out.printf("%c->(%c)\n",graph.vertexs[i],graph.vertexs[pre_visited[i]]);
			}
			System.out.println("初始顶点("+graph.vertexs[start]+")到每个顶点的最短路径：");
			for(int i=0;i<graph.vertexs.length;i++) {
				if(dis[i]!=65535) {
					System.out.printf("%c(%d)",graph.vertexs[i],dis[i]);
				}else {
					System.out.print("N");
				}
			}
			int count=0;
			for(int way : dis) {
				count+=way;
			}
			System.out.println("\n以顶点"+graph.vertexs[start]+"为初始顶点的最短路径为："+count);
		}
	}
	
	/**
	 * 	定义图
	 * @author Administrator
	 *
	 */
	private class Graph{
		
		private char[] vertexs; //顶点集合
		private int[][] matrix; //邻接矩阵
		
		public Graph(char[] vertexs, int[][] matrix) {
			this.vertexs = vertexs;
			this.matrix = matrix;
		}

		@Override
		public String toString() {
			return "Graph [vertexs=" + Arrays.toString(vertexs) + ", matrix=" + Arrays.toString(matrix) + "]";
		}
	}
}
