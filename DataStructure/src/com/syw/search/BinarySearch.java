package com.syw.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 	���ֲ��ҷ�������ѯ����������������
 * @author Administrator
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		/*��Ҫ���ҳ���������Ϊ 8 ���±�*/
		int[] array= {1,3,5,8,8,8,9,74};
		List<Integer> list= binarySearch(array,0,array.length-1,8);
		if(list.size()>0) {
			System.out.println("�鵽�����±�:"+list.toString());
		}else {
			System.out.println("�Ҳ��������ݡ�����");
		}
	}
	
	/**
	 * 	
	 * @param array �Ӹ�����鵽--> data
	 * @param left lowָ��
	 * @param right highָ��
	 * @param data ���ҵ�����
	 * @return ���� �ҵ������±꣬�Ҳ�������-1
	 */
	public static List<Integer> binarySearch(int[] array,int left,int right,int data) {
		
		if(left > right) {
			return new ArrayList<Integer>();//����left=right--->�����������һ��λ��
		}
		int midIndex=(left+right)/2;
		int midVal=array[midIndex];
		if(data>midVal) { //�ҵݹ�
			return binarySearch(array,midIndex+1,right,data);
		}else if(data < midVal) {
			return  binarySearch(array,left,midIndex-1,data);
		}else {
			
			List<Integer> list= getReapeatIndex(midIndex,array,data);
			return list;
		}
	}
	
	/**
	 * 	
	 * @param midIndex ���ҵ�һ��һ�������±�
	 * @param array
	 * @return ����������Ҫ���ҵ������±�
	 */
	private static List<Integer> getReapeatIndex(int midIndex,int[] array,int data){
		
		List<Integer> list=new ArrayList<>();
		list.add(midIndex);
		//�������
		int tempIndex=midIndex-1;
		while(true) {
			if(tempIndex < 0 || array[tempIndex]!=data) {
				break;
			}
			list.add(tempIndex);
			tempIndex--;
		}
		//���Ҳ���
		tempIndex=midIndex+1;
		while(true) {
			if(tempIndex > array.length-1 || array[tempIndex]!=data) {
				break;
			}
			list.add(tempIndex);
			tempIndex++;
		}
		return list;
	}
}
