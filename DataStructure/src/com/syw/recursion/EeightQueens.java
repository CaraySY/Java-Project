package com.syw.recursion;

/**
 * 	ʹ��һλ����������˻ʺ����⣬�����±��ʾ���ڵڼ��У������value��ʾ���ڵڼ���
 * @author Administrator
 *
 */
public class EeightQueens {

	private final int MAX=8;//��ʾ�ʺ�ĸ���
	
	private static int count=0;//�˻ʺ�Ľⷨ
	
	private int[] array=new int[MAX];
	
	/**
	 * 	check��ÿһ�εݹ��ǣ����뵽check�� ����һ�� forѭ��
	 * @param n ��ʾ�� n ���ʺ�
	 */
	public void check(int n) {
		
		if(n==MAX) { // n==8 ��ʾ�Ѿ�������8���ʺ�Ӧ��������
			print();
			return;
		}
		
		/*���η���ʺ󣬲����ж��Ƿ��ͻ*/
		for(int i=0;i<MAX;i++) {
			//�Ƚ���ǰ�Ļʺ�n[ nͬʱ���������� ]�ŵ����еĵ�i��
			array[n]=i;
			if(judge(n)) {
				check(n+1); //���û�г�ͻ��������һ���ʺ�
			}
			/*����г�ͻ���ŵ����е���һ��*/
		}
	}
	
	public int count() {
		
		return count;
	}
	
	/**
	 * 	A�������±��ʾ���ڵڼ���
	 * 	B�������value��ʾ���ڵڼ���
	 * @param n ��ʾ�ڼ����ʺ����������[����Ҫ�ж��Ƿ����ͬһ��] n�Ѿ�����������������ַ�����ͬһ��
	 * @return
	 */
	private boolean judge(int n) {
		
		for(int i=0;i<n;i++) {
			
			/*	array[i]==array[n] ��ʾ��N�Ļʺ��ǰ���i���ʺ���ͬһ���� 
			 * 
			 *  Math.abs(n-i)==Math.abs(array[n]-array[i]) ��ʾ��N�Ļʺ��ǰ���i���ʺ���ͬһ��б����
			 *  ����б�ʵĹ�ʽ��k=(y1-y2)/(x1-x2) 
			 *  
			 *  ����false ���ܷ���
			 *  
			 */
			if(array[i]==array[n] || Math.abs(n-i)==Math.abs(array[n]-array[i])) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 	��ӡ�ʺ�ݷõĽ��
	 */
	private void print() {
		
		for(int i=0;i<array.length;i++) {
			
			System.out.printf("(%d,%d)",i,array[i]);
			if(i!=array.length-1) {
				System.out.print("->");
			}
		}
		System.out.println();
		count++;
	}
}
