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
	 * @param start ����������±�
	 */
	public void dijkstra(int start) {
		
		v=new VisitedVertex(graph.vertexs.length, start);
		this.start=start;
		update(start);
		//��ʼ�����Ѿ����ʣ�����һ����ʼ����
		for(int i=1;i<graph.vertexs.length;i++) {
			int next=v.updateArr(); //��ȡ������һ���µĶ���--�䵽��ʼ����ľ�����С�Ķ���
			update(next); //������һ������
		}
	}
	
	/**
	 * 	�����±�Ϊindex�Ķ��㵽��Χ����ľ��룬����Χ�����ǰ������
	 * @param index
	 */
	private void update(int index) {
		
		int len=0; 
		//������index�е� �ڽӾ���
		for(int j=0;j<graph.matrix[index].length;j++) {
			//len��ʾ ��ǰ����index����������ľ��� + index���㵽����j�ľ���
			len=v.getDis(index)+graph.matrix[index][j]; 
			if(!v.isVisited(j) && len < v.getDis(j)) {
				v.updateDis(j, len); //���³������㵽 j�ľ���
				v.updatePre(j, index); // ��j��ǰ����������Ϊindex
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
	 * 	�ѷ��ʶ�����
	 * @author Administrator
	 *
	 */
	private class VisitedVertex{
		
		//��¼ÿ�������Ƿ���ʹ���true������ false��δ����
		private boolean[] already_arr;
		//ÿ���±��Ӧ��ֵΪǰһ��������±�(��̬����)
		private int[] pre_visited;
		//��¼�������㵽�������ж���ľ���
		//�磺GΪ�������㣬���¼G����������ľ��룬����̵ķ���
		private int[] dis;
		
		/**
		 * 	������
		 * @param length ����ĸ���
		 * @param start ��������
		 */
		public VisitedVertex(int length,int start) {
			this.already_arr = new boolean[length]; //��ʼ�����ж���δ����
			this.pre_visited = new int[length];
			this.dis = new int[length];
			Arrays.fill(dis, 65535);
			this.already_arr[start]=true;//���ó�������Ϊ�Ѿ�����
			dis[start]=0; //����������ʾ���Ϊ0
		}

		/**
		 *  �ж��±�Ϊindex�Ķ����Ƿ���ʹ�
		 * @param index
		 * @return true�����ʹ� false:δ����
		 */
		public boolean isVisited(int index) {
			return already_arr[index];
		}
		
		/**
		 * 	���³������㵽 �±�Ϊindex����ľ���
		 * @param index �±�
		 * @param len ���� 
		 */
		public void updateDis(int index,int len) {
			
			dis[index]=len;
		}
		
		/**
		 * 	���±�Ϊpre�Ķ����ǰ��������Ϊ index
		 * @param cur
		 * @param index
		 */
		public void updatePre(int cur,int index) {
			pre_visited[cur]=index;
		}
		
		/**
		 * 	���س������㵽�±�Ϊindex�Ķ���ľ���
		 * @param index
		 * @return ����
		 */
		public int getDis(int index) {
			return dis[index];
		}
		
		/**
		 * 	����Ѱ�Ҳ��ҷ���һ���µĶ���-->���ʼ����ΪG����dis�������ҵ�һ����Сֵ��A��Ϊ�µķ��ʶ���
		 * 	���ҽ�A����Ϊ�Ѿ�����
		 * @return
		 */
		public int updateArr() {
			
			int min=65535;
			int next=-1;
			for(int i=0;i<dis.length;i++) {
				//�����µĶ���û�б�������Ȩֵ��С
				if(!isVisited(i) && getDis(i) < min) {
					min=getDis(i);
					next=i;
				}
			}
			already_arr[next]=true;//���Ϊ�Ѿ�����
			return next;
		}
		
		public void show(Graph graph,int start) {
			
			System.out.println("ÿ��������������");
			System.out.println(Arrays.toString(already_arr));
			System.out.println("ÿ�������ǰ�����㣺");
			for(int i=0;i<graph.vertexs.length;i++) {
				System.out.printf("%c->(%c)\n",graph.vertexs[i],graph.vertexs[pre_visited[i]]);
			}
			System.out.println("��ʼ����("+graph.vertexs[start]+")��ÿ����������·����");
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
			System.out.println("\n�Զ���"+graph.vertexs[start]+"Ϊ��ʼ��������·��Ϊ��"+count);
		}
	}
	
	/**
	 * 	����ͼ
	 * @author Administrator
	 *
	 */
	private class Graph{
		
		private char[] vertexs; //���㼯��
		private int[][] matrix; //�ڽӾ���
		
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
