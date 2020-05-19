package com.wsy.prime;

import org.junit.Test;

import com.syw.mst.KruskalMST;

public class KruskalMSTTest {

	private static final int INF=Integer.MAX_VALUE;
	
	@Test
	public void fun1() {
		
		char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		//��³˹�����㷨���ڽӾ���  
	    int matrix[][] = {
	      /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
	/*A*/ {   0,  12, INF, INF, INF,  16,  14},
	/*B*/ {  12,   0,  10, INF, INF,   7, INF},
	/*C*/ { INF,  10,   0,   3,   5,   6, INF},
	/*D*/ { INF, INF,   3,   0,   4, INF, INF},
	/*E*/ { INF, INF,   5,   4,   0,   2,   8},
	/*F*/ {  16,   7,   6, INF,   2,   0,   9},
	/*G*/ {  14, INF, INF, INF,   8,   9,   0}}; 
	      //��ҿ�����ȥ�����������ڽӾ��󣬽�������Եõ���С������.
	      
	      //����KruskalCase ����ʵ��
	      KruskalMST kruskalCase = new KruskalMST(vertexs, matrix);
	      //���������
	      kruskalCase.print();
	      kruskalCase.kruskal();
	}
}
