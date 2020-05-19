package com.syw.list;

/**
 * 	�������������Լɪ������
 * @author Administrator
 *
 */
public class SingleCircleLinkedList {

	private Boy first=new Boy();
	
	/**
	 * 	���С���ӵ�����������
	 */
	public void addBoy(int nums) {
		
		if(nums < 1) {
			System.out.println("�������ݳ���...");
			return;
		}
		/*�� 1 ��ʼ*/
		Boy curBoy=null;
		for(int i=1;i<=nums;i++) {
			Boy boy=new Boy(i);
			/*����ͷ�ڵ�Ļ�*/
			if(i==1) {
				first=boy; //��һ���ڵ�ָ��ͷ�ڵ�
				first.next=first; //���ɻ�
				curBoy=first;//�ƶ�curBoy ָ���һ��С��
			}else {
				curBoy.next=boy;
				boy.next=first;//���ɻ�
				curBoy=boy;//curBoy�ƶ�����ǰС��λ��
			}
		}
	}
	
	/**
	 * 	
	 * @param startNo	�ڼ���С����ʼ����
	 * @param countNum	������
	 * @param nums	С������
	 */
	public void solveJosephCircle(int startNo,int countNum,int nums) {
		
		/*����У��*/
		if(startNo < 0 || countNum > nums) {
			System.out.println("����������������������...");
			return;
		}
		/*����һ������ָ�� helper[ ָ�����һ���ڵ� ]���������ȦС���Ƿ��Ѵ����һ��*/
		Boy helper=first;
		while(true) {
			if(helper.next==first) { //��helper��next == first �ﵽ���һ���ڵ�
				break;
			}
			helper=helper.next;
		}
		/*��first helper �ƶ���startNo[ С����ʼ���� ]��λ�� �磺*/
		/* ��1��ʼ�� 1 ��Ҫ�ƶ� startNo-1=0 ��*/
		/* ��3��ʼ�� 5��Ҫ�ƶ� startNo-1=2 ��*/
		for(int i=0;i<startNo-1;i++) {
			first=first.next;
			helper=helper.next;
		}
		/*��Ϸ��ʼ*/
		while(true) {
			if(first==helper) {
				break; //�������һ��С��������ѭ��
			}
			/*С����ʼ���������򣺴ӵ�1����ʼ��2��,��Ҫ�ƶ�ָ��[first��helper] һ��(��ǰС��Ҳ��Ҫ����)*/
			/*ָ�����ƶ�  countNum-1 ��*/
			for(int i=0;i<countNum-1;i++) {
				first=first.next;
				helper=helper.next;
			}
			/*С����Ȧ*/
			System.out.println("��ǰ��ȦС����ţ�"+first.no);
			first=first.next;//�ƶ�����һ��С��
			helper.next=first;//��֤helper����һ���ڵ�Ϊfirst
		}
		System.out.println("����ȦС����ţ�"+first.no);
	}
	
	public void print() {
		
		if(first==null) {
			System.out.println("����Ϊ�գ��޷�����...");
			return;
		}
		Boy curBoy=first;
		while(true) {
			System.out.print(curBoy.no);
			if(curBoy.next!=first) {
				System.out.print("->");
			}
			if(curBoy.next==first) {
				break;
			}
			curBoy=curBoy.next;
		}
		System.out.println();
	}
	
	private class Boy{
		
		private int no; //���
		private Boy next;  //ָ����һ���ڵ�
		
		public Boy() {
			
		}
		
		public Boy(int no) {
			this.no=no;
		}

		@Override
		public String toString() {
			return "Boy [no=" + no + "]";
		}
	}
}
