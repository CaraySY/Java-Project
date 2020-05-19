package com.syw.list;

/**
 * 	单向环形链表，解决约瑟夫环问题
 * @author Administrator
 *
 */
public class SingleCircleLinkedList {

	private Boy first=new Boy();
	
	/**
	 * 	添加小孩子到环形链表中
	 */
	public void addBoy(int nums) {
		
		if(nums < 1) {
			System.out.println("输入数据出错...");
			return;
		}
		/*从 1 开始*/
		Boy curBoy=null;
		for(int i=1;i<=nums;i++) {
			Boy boy=new Boy(i);
			/*不带头节点的环*/
			if(i==1) {
				first=boy; //第一个节点指向头节点
				first.next=first; //构成环
				curBoy=first;//移动curBoy 指向第一个小孩
			}else {
				curBoy.next=boy;
				boy.next=first;//构成环
				curBoy=boy;//curBoy移动到当前小孩位置
			}
		}
	}
	
	/**
	 * 	
	 * @param startNo	第几个小孩开始数数
	 * @param countNum	数几下
	 * @param nums	小孩总数
	 */
	public void solveJosephCircle(int startNo,int countNum,int nums) {
		
		/*数据校验*/
		if(startNo < 0 || countNum > nums) {
			System.out.println("输入数据有误，请重新输入...");
			return;
		}
		/*定义一个辅助指针 helper[ 指向最后一个节点 ]帮助计算出圈小孩是否已达最后一个*/
		Boy helper=first;
		while(true) {
			if(helper.next==first) { //当helper的next == first 达到最后一个节点
				break;
			}
			helper=helper.next;
		}
		/*将first helper 移动到startNo[ 小孩开始报数 ]的位置 如：*/
		/* 从1开始到 1 需要移动 startNo-1=0 次*/
		/* 从3开始到 5需要移动 startNo-1=2 次*/
		for(int i=0;i<startNo-1;i++) {
			first=first.next;
			helper=helper.next;
		}
		/*游戏开始*/
		while(true) {
			if(first==helper) {
				break; //到达最后一个小孩，跳出循环
			}
			/*小孩开始报数，规则：从第1个开始报2下,需要移动指针[first、helper] 一次(当前小孩也需要计算)*/
			/*指针需移动  countNum-1 次*/
			for(int i=0;i<countNum-1;i++) {
				first=first.next;
				helper=helper.next;
			}
			/*小孩出圈*/
			System.out.println("当前出圈小孩编号："+first.no);
			first=first.next;//移动到下一个小孩
			helper.next=first;//保证helper的下一个节点为first
		}
		System.out.println("最后出圈小孩编号："+first.no);
	}
	
	public void print() {
		
		if(first==null) {
			System.out.println("链表为空，无法遍历...");
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
		
		private int no; //编号
		private Boy next;  //指向下一个节点
		
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
