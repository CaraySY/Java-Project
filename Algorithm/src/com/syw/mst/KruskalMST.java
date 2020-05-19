package com.syw.mst;

public class KruskalMST {

	private char[] vertexs; //存放顶点
	private int[][] matrix; //邻接矩阵
	private int edgeNum; //边的个数
	private int vertexNum; //顶点个数
	private EData[] edata; //边对象数组
	private static final int INF =Integer.MAX_VALUE;
	
	/**
	 *  构造器初始化，使用复制拷贝而非引用直接拷贝
	 * @param vertexs
	 * @param matrix
	 */
	public KruskalMST(char[] vertexs, int[][] matrix) {
		
		this.vertexNum=vertexs.length;
		this.vertexs=new char[vertexs.length];
		//初始化顶点
		for(int i=0;i<vertexs.length;i++) {
			this.vertexs[i]=vertexs[i];
		}
		this.matrix=new int[vertexs.length][vertexs.length];
		//初始化边
		for(int i=0;i<vertexs.length;i++) {
			for(int j=0;j<vertexs.length;j++) {
				this.matrix[i][j]=matrix[i][j];
			}
		}
		//统计边
		for(int i=0;i<vertexs.length;i++) {
			for(int j=i+1;j<vertexs.length;j++) {
				if(matrix[i][j]!=INF) {
					this.edgeNum++;
				}
			}
		}
		initEData();
	}
	
	public void kruskal() {
		
		int index=0;
		int[] ends=new int[edgeNum]; //保存已有最小生成树每个顶点在最小生成树的终点
		//保存最后的最小生成树
		EData[] rets=new EData[edgeNum];
		//获取图中所有边的集合
		EData[] edges=getEData();
		//按照边权值---小->大
		sortEData(edges);
		for(int i=0;i<edgeNum;i++) {
			//获取第i条边的start顶点
			int p1=getPosition(edges[i].start);
			//获取第i条边的end
			int p2=getPosition(edges[i].end);
			//获取p1这个顶点在已有最小生成树的终点
			int m=getEnd(ends,p1);
			//获取p2这个顶点在已有最小生成树的终点
			int n=getEnd(ends,p2);
			if(m!=n) { //不构成回路
				ends[m]=n;// 设置m在已有生成树的终点 <E,F> 0 0 0 0 5 0 0 0 0 0 0 0 
				rets[index++]=edges[i];
			}
		}
		System.out.println("最小生成树：");
		for(int i=0;i<index;i++) {
			System.out.printf("<%c,%c>:%d\n",rets[i].start,rets[i].end,rets[i].weight);
		}
	}
	
	public int getVertexsCount() {
		
		return vertexNum;
	}
	
	public int getEdgeCount() {
		
		return edgeNum;
	}
	
	public void print() {
		
		for(int i=0;i<vertexs.length;i++) {
			for(int j=0;j<vertexs.length;j++) {
				System.out.printf("%20d",matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	/**
	 * 	冒泡排序---从小到大
	 * @param eDate
	 */
	public void sortEData(EData[] eData) {
		
		EData temp=null;
		for(int i=0;i<eData.length;i++) {
			for(int j=0;j<eData.length-i-1;j++) {
				if(eData[j].weight > eData[j+1].weight) {
					temp=eData[j];
					eData[j]=eData[j+1];
					eData[j+1]=temp;
				}
			}
		}
	}
	
	/**
	 * 	获取下标为i的顶点的终点()，用于判断两个顶点的终点是否相同
	 * @param ends	数组就是记录了各个顶点对应的终点是哪个，ends数组是动态形成的
	 * @param i 表示传入的顶点对应的下标
	 * @return 返回就是下标为i的这个顶点对应的终点的下标
	 */
	public int getEnd(int[] ends,int i) {
		
		while(ends[i]!=0) {
			i=ends[i];
		}
		return i;
	}
	
	/**
	 *  返回顶点的下标
	 * @param data
	 * @return
	 */
	public int getPosition(char data) {
		
		for(int i=0;i<vertexNum;i++) {
			if(vertexs[i]==data) {
				return i;
			}
		}
		return -1;
	}
	
	public EData[] getEData() {
		
		return edata;
	}
	
	/**
	 * 	返回定义边对象的数组
	 * @return
	 */
	private void initEData() {
		
		edata=new EData[edgeNum];
		int index=0;
		//遍历邻接矩阵，自己和自己不算一条边，从一个开始：'a' 'a' 'b' 'b'
		for(int i=0;i<vertexNum;i++) {
			for(int j=i+1;j<vertexNum;j++) {
				if(matrix[i][j]!=INF) {
					edata[index++]=new EData(vertexs[i],vertexs[j],matrix[i][j]);
				}
			}
		}
	}
	/**
	 * 	边的定义 
	 * @author Administrator
	 *
	 */
	private class EData{
		
		private char start;
		private char end;
		private int weight;
		
		public EData(char start, char end, int weight) {
			
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "EData [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}
	}
}
