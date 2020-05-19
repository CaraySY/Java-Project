package com.syw.min_distance;

import java.util.Arrays;

public class Floyd {

	private Graph graph;
	
	public Floyd(char[] vertexs,int[][] dis) {
		
		graph=new Graph(vertexs,dis,vertexs.length);
	}
	
	public void showGraph() {
		
		System.out.println("�ڽӾ���");
		for(int[] temp : graph.dis) {
			for(int data:temp) {
				System.out.printf("%10d",data);
			}
			System.out.println();
		}
		System.out.println("ǰ�����㣺");
		for(int[] temp :graph.pre) {
			for(int data:temp) {
				System.out.print(data+"\t");
			}
			System.out.println();
		}
		System.out.println("���㼯�ϣ�");
		System.out.println(Arrays.toString(graph.vertexs));
	}
	
	public void floyd() {
		
		// kΪ�м䶥�� 
		for(int k=0;k<graph.length;k++) {
			//iΪ��������
			for(int i=0;i<graph.length;i++) {
				//j�����ﶥ��
				for(int j=0;j<graph.length;j++) {
					// len���� �ӳ�������i���յ�j����������м䶥��k�ľ���С�ڴ�i��j�ľ���
					// �滻����i��j��·��Ϊlen
					int len=graph.dis[i][k]+graph.dis[k][j];
					if(len < graph.dis[i][j]) {
						graph.dis[i][j]=len;
						//���� j ��ǰ������Ϊk
						graph.pre[i][j]=graph.pre[k][j];
					}
				}
			}
		}
	}
	
	private class Graph{
		
		private char[] vertexs; //���㼯��
		private int[][] dis; //�ڽӾ���
		private int[][] pre; //���������ǰ������
		private int length; //�������
		
		public Graph(char[] vertexs, int[][] dis,int lenght) {

			this.vertexs = vertexs;
			this.dis = dis;
			this.pre=new int[lenght][lenght];
			this.length=lenght;
			for(int i=0;i<lenght;i++) {
				Arrays.fill(pre[i], i); //�տ�ʼ����������ĳ�ʼ����Ϊ����
			}
		}
	}
}
