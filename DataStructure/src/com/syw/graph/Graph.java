package com.syw.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 	ͼ�Ĵ������ڽӱ���ڽӾ���
 * @author Administrator
 *
 */
//ʹ���ڽӾ��󴴽�ͼ
public class Graph {

	private List<String> vertexs; //���涥���List--->�������
	private int count; //�ߵ����� 
	private int[][] edges; //�ڽ�����
	private boolean[] isVisited; //��¼ͼ���ι��̷��ʹ��Ķ���
	
	public Graph(int n) {
		
		this.vertexs=new ArrayList<>(n);
		this.edges=new int[n][n];
		this.count=0;
		this.isVisited=new boolean[n];
	}
	
	/**
	 * 	��Ӷ���
	 * @param vertex
	 */
	public void add(String vertex) {
		
		vertexs.add(vertex);
	}
	
	/**
	 * 	�����ߵĹ�ϵ
	 * @param vertex1  ����1
	 * @param vertex2  ����2
	 * @param weight Ȩֵ
	 */
	public void insertEdge(String vertex1,String vertex2,int weight) {
		
		int indexVal1=vertexs.indexOf(vertex1);
		int indexVal2=vertexs.indexOf(vertex2);
		edges[indexVal1][indexVal2]=weight; //����ͼ
		edges[indexVal2][indexVal1]=weight; //����ͼ
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
	 * 	����dfs������ʵ�ֵ�ǰ�����Ҳ�����һ���ڽӶ���ʱ�ĵݹ鷵�أ�����һ�����㿪ʼ����dfs
	 */
	public void dfs() {
		
		for(int i=0;i<vertexs.size();i++) {
			if(!isVisited[i]) {
				dfs(isVisited,i); //�ڻ��ݵĹ����У�ĳ����������Ѿ����ʹ�
			}
		}
	}
	
	public void bfs() {
		
		for(int i=0;i<vertexs.size();i++) {
			if(!isVisited[i]) {
				bfs(isVisited,i); //�ڻ��ݵĹ����У�ĳ����������Ѿ����ʹ�
			}
		}
	}
	
	
	
	/**
	 *  <strong>������ȱ���</strong>�㷨��<br>
	 * + ���ʳ�ʼ����v������Ƕ���Ϊ�ѷ��� <br>
	 * + ���ҽ��v�ĵ�һ���ڽӶ���w <br>
	 * + ��w���ڣ���ִ����һ����w�����ڣ��򷵻ص�һ��������v����һ��������� <br>
	 * + ��wδ�����ʣ���w����������ȱ����ݹ�(����w������һ��v��Ȼ�����1 2 3��) <br>
	 * + ���ҽ��v��w�ڽӽ�����һ���ڽӽ�㣬ת�ز���3 <br>
	 * 
	 * @param isVisited �����Ƿ���ʹ������� <br>
	 * @param v ��ǰ�����Ķ�����±� <br>
	 */
	private void dfs(boolean[] isVisited,int v) {
		
		//1�����ʳ�ʼ����
		System.out.print(vertexs.get(v)+"->");
		isVisited[v]=true; //����ǰ��������Ϊ�Ѿ�����
		//2�����ҵ�һ���ڽӶ���
		int w=getFirstNeighbor(v);
		//3��ͨ��wѭ���ݹ����DFS
		while(w!=-1) {
			if(!isVisited[w]) { //��ǰ�������һ������û�з��ʹ�
				dfs(isVisited,w);
			}
			w=getNextNeighbor(v, w); //������ʹ�����w����һ��v��ʼdfs
		}
	}
	
	/**
	 * 	<b>������ȱ����㷨</b> <br>
	 * 	+ ���ʳ�ʼ����v������Ƕ���vΪ�ѷ��� <br>
	 *  + ����v����� <br>
	 *  + ������Ϊ��ʱ������ִ�У������㷨���� <br>
	 *  + �����У�ȡ�ö���ͷ����u <br>
	 *  + ���Ҷ���u�Ķ�һ���ڽӶ���w <br>
	 *  + ������u���ڽӶ���w�����ڣ���ת������3������ѭ��ִ�����²��� <br>
	 *  	-������wδ�����ʣ�����ʶ���w�����Ϊ�ѷ��� <br>
	 *  	-����w����� <br>
	 *  	-���Ҷ���u�ļ�w�ڽӶ�������һ���ڽӶ���w��ת������6 <br>
	 * @param isVisited
	 * @param u
	 */
	private void bfs(boolean[] isVisited,int v) {
		
		int u,w;
		//1�����ʳ�ʼ����
		System.out.print(vertexs.get(v)+"->");
		//���Ϊ�ѷ���
		isVisited[v]=true;
		//2����ʼ���������--->ʹ��linkedListģ����еĲ���
		LinkedList<Integer> queue=new LinkedList<>();
		queue.addLast(v);
		//3�����в�Ϊ�գ�ѭ��ִ��
		while(!queue.isEmpty()) {
			//ͷ���������
			u=queue.removeFirst();
			//�õ���һ���ڽӶ��� u ����һ������w
			w=getFirstNeighbor(u);
			while(w!=-1) {
				if(!isVisited[w]) {
					// ������wδ�����ʣ�����ʶ���w�����Ϊ�ѷ���
					System.out.print(vertexs.get(w)+"->");
					isVisited[w]=true;
					//�����
					queue.addLast(w);
				}
				//��uΪ��ǰ���㣬�ҵ�w�������һ���ڽӶ���
				w=getNextNeighbor(u, w);
			}
		}
	}
	
	/**
	 * 	���ص�ǰ������һ���ڽӶ���
	 * @param v
	 * @return ������һ���ڽӶ�����±�
	 */
	private int getFirstNeighbor(int v) {
		
		for(int w=0;w<vertexs.size();w++) {
			if(edges[v][w] > 0) {
				return w;
			}
		}
		return -1;//�Ҳ���
	}
	
	/**
	 * 	
	 * @param v ��ǰ�����±�
	 * @param w ��һ���ڽӶ��㶥���±�
	 * @return w �ĵ�һ���ڽӶ����±� v -> w -> z
	 */
	private int getNextNeighbor(int v,int w) {
		
		for(int z=w+1;z<vertexs.size();z++) {
			if(edges[v][z] > 0) {
				return z;
			}
		}
		return -1; //�Ҳ���
	}
}
