package com.syw.mst;

public class KruskalMST {

	private char[] vertexs; //��Ŷ���
	private int[][] matrix; //�ڽӾ���
	private int edgeNum; //�ߵĸ���
	private int vertexNum; //�������
	private EData[] edata; //�߶�������
	private static final int INF =Integer.MAX_VALUE;
	
	/**
	 *  ��������ʼ����ʹ�ø��ƿ�����������ֱ�ӿ���
	 * @param vertexs
	 * @param matrix
	 */
	public KruskalMST(char[] vertexs, int[][] matrix) {
		
		this.vertexNum=vertexs.length;
		this.vertexs=new char[vertexs.length];
		//��ʼ������
		for(int i=0;i<vertexs.length;i++) {
			this.vertexs[i]=vertexs[i];
		}
		this.matrix=new int[vertexs.length][vertexs.length];
		//��ʼ����
		for(int i=0;i<vertexs.length;i++) {
			for(int j=0;j<vertexs.length;j++) {
				this.matrix[i][j]=matrix[i][j];
			}
		}
		//ͳ�Ʊ�
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
		int[] ends=new int[edgeNum]; //����������С������ÿ����������С���������յ�
		//����������С������
		EData[] rets=new EData[edgeNum];
		//��ȡͼ�����бߵļ���
		EData[] edges=getEData();
		//���ձ�Ȩֵ---С->��
		sortEData(edges);
		for(int i=0;i<edgeNum;i++) {
			//��ȡ��i���ߵ�start����
			int p1=getPosition(edges[i].start);
			//��ȡ��i���ߵ�end
			int p2=getPosition(edges[i].end);
			//��ȡp1���������������С���������յ�
			int m=getEnd(ends,p1);
			//��ȡp2���������������С���������յ�
			int n=getEnd(ends,p2);
			if(m!=n) { //�����ɻ�·
				ends[m]=n;// ����m���������������յ� <E,F> 0 0 0 0 5 0 0 0 0 0 0 0 
				rets[index++]=edges[i];
			}
		}
		System.out.println("��С��������");
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
	 * 	ð������---��С����
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
	 * 	��ȡ�±�Ϊi�Ķ�����յ�()�������ж�����������յ��Ƿ���ͬ
	 * @param ends	������Ǽ�¼�˸��������Ӧ���յ����ĸ���ends�����Ƕ�̬�γɵ�
	 * @param i ��ʾ����Ķ����Ӧ���±�
	 * @return ���ؾ����±�Ϊi����������Ӧ���յ���±�
	 */
	public int getEnd(int[] ends,int i) {
		
		while(ends[i]!=0) {
			i=ends[i];
		}
		return i;
	}
	
	/**
	 *  ���ض�����±�
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
	 * 	���ض���߶��������
	 * @return
	 */
	private void initEData() {
		
		edata=new EData[edgeNum];
		int index=0;
		//�����ڽӾ����Լ����Լ�����һ���ߣ���һ����ʼ��'a' 'a' 'b' 'b'
		for(int i=0;i<vertexNum;i++) {
			for(int j=i+1;j<vertexNum;j++) {
				if(matrix[i][j]!=INF) {
					edata[index++]=new EData(vertexs[i],vertexs[j],matrix[i][j]);
				}
			}
		}
	}
	/**
	 * 	�ߵĶ��� 
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
