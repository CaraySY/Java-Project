package com.syw.mst;

import java.util.Arrays;

public class PrimeMST {

	private MGraph graph=new MGraph();
	/**
	 * 	����ͼ
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
	 * @param start ��ĳ�����㿪ʼ, 'A'->0 'B'->1
	 */
	public void prime(int start) {
		
		int count=0;
		boolean[] isVisited=new boolean[graph.vertexs]; //����һ���������飬��Ƕ����Ƿ��Ѿ����ʹ�
		isVisited[start]=true;
		int h1=-1; //��ǰ�ѷ��ʹ��Ķ����±�
		int h2=-2; //�����ʵĶ����±�
		int minLen=10000; //���õ�ǰ����䲻�ɴ�
		//�������ɵı�Ӧ�õ��� ��������ȥ 1 ,�ӵ�һ�����㿪ʼ�Ҷ�������СȨֵ ���ֻ��ѭ�� [1,vertexs-1)
		for(int k=1;k<graph.vertexs;k++) {
			for(int i=0;i<graph.vertexs;i++) { // i��ʾ�ѷ��ʶ����±�
				for(int j=0;j<graph.vertexs;j++) { //	û�з��ʵĶ����±�
					//graph.weight[i][j] < minLen ,��Ϊ��ʼ�� minLenΪ�����
					//������������ȨֵҲ����󣬴��������㲻�ɴ����
					//���򽫵�ǰ��ֵ��Ϊ��СȨֵ
					if(isVisited[i] && !isVisited[j] && graph.weight[i][j] < minLen) {
						minLen=graph.weight[i][j];
						h1=i;
						h2=j; //��¼�ҵ�һ�����ʹ��Ķ��㵽��һ���շ��ʹ���Ķ���
					}
				}
			}
			//��Ǹշ��ʵĶ���Ϊ�Ѿ����ʹ�
			isVisited[h2]=true;
			count+=minLen;
			System.out.printf("��<%c,%c>����СȨֵ��%d \n",graph.data[h1],graph.data[h2],minLen);
			//����minLen������Ѱ����һ������
			minLen=10000;
		}
		System.out.println("ʹ��Prime�㷨��С������ȨֵΪ��"+count);
	}
	
	public void print(int[][] weight) {
		
		for(int[] temp : weight) {
			System.out.println(Arrays.toString(temp));
		}
	}
	
	@SuppressWarnings("unused")
	private class MGraph {
		
		private int vertexs; //����ĸ���
		private char[] data; //���涥��
		private int[][] weight; //�ߵ�Ȩֵ
		
		public MGraph() {
			
		}
		
		public MGraph(int vertexs, char[] data, int[][] weight) {

			this.vertexs = vertexs;
			this.data = data;
			this.weight = weight;
		}
	}
}
