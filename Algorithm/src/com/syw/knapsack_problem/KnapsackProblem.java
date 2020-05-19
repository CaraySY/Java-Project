package com.syw.knapsack_problem;

public class KnapsackProblem {

	public static void main(String[] args) {
		
		knapsackProblem();
	}
	
	public static void knapsackProblem() {
		
		int[] w= {1,4,3}; //��Ʒ������
		int[] val= {1500,3000,2000};
		int m=4; //����������
		int n=w.length; //��Ʒ�ĸ���
		// v[i][j] --> ��ʾ��ǰi����Ʒװ������Ϊj�ı���������ֵ
		int[][] v=new int [n+1][m+1]; // ��һ�к͵�һ��ȫΪ��0
		//�����ά�����¼����Ʒ�����
		int[][] path=new int [n+1][m+1];
		//��һ��ȫ��
		/*
		 * for(int i=0;i<v.length;i++) { for(int j=0;j<v[i].length;j++) { v[0][j]=0; } }
		 */
		//��һ��ȫ��
		/*
		 * for(int i=0;i<v.length;i++) { for(int j=0;j<v[i].length;j++) { v[i][0]=0; } }
		 */
		/*��һ�е�һ�ж�Ϊ 0 ���±�� 1 ��ʼ*/
		for(int i=1;i<v.length;i++) {
			for(int j=1;j<v[i].length;j++) {
				//��� W[i] > j ����׼���������Ʒ�������ڵ�ǰʣ������
				if(w[i-1] > j) { // i��1��ʼ������ w[i-1]
					v[i][j]=v[i-1][j]; //��ǰi����Ʒװ������Ϊj�ı���������ֵΪǰi-1����Ʒװ�뱳���ļ�ֵ
				}else{ //��� W[i] <= j ����׼���������Ʒ��С�ڵ����ڵ�ǰʣ������
					
					//val[i]+v[i-1][j-w[i]] 
					//	-> ������ת��Ϊǰ i-1����Ʒ�ڱ�������Ϊ j-w[i] ����׼������ĵ� i����Ʒ�ļ�ֵ֮��
					if(v[i-1][j] > val[i-1]+v[i-1][j-w[i-1]]) {
						v[i][j]=v[i-1][j];
					}else {
						v[i][j]=val[i-1]+v[i-1][j-w[i-1]];
						path[i][j]=1 ;//��¼���Ž�����
					}
				}
					//��¼��Ʒ��ŵ������������ʹ��if-else
					
			}
		}
		printArray(v);
		//��������ŵ������ļ�¼
		int i=path.length-1;
		int j=path[0].length-1;
		while(i>0 && j>0) {
			if(path[i][j] == 1) {
				System.out.printf("��%d����Ʒ���뱳��\n",i);
				j=j-w[i-1];
			}
			i--;
		}
		
	}
	
	public static void printArray(int[][] array) {
		
		for(int[] temp : array) {
			for(int data : temp) {
				System.out.print(data+"\t");
			}
			System.out.println("\n");
		}
	}
}


