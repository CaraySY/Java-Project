package com.syw.recursion;

public class MazeProblem {

	/*��ʼ���Թ� 8*7 ��������Ϊ1��Ϊǽ */
	public void initMaze(int[][] map,int row,int col) {
		
		for(col=0;col<7;col++) {
			map[0][col]=1;
			map[7][col]=1;
		}
		
		for(row=0;row<8;row++) {
			map[row][0]=1;
			map[row][6]=1;
		}
		
		for(int j=1;j<=2;j++) {
			map[3][j]=1;
		}
		
		print(map);
	}
	
	/**
	 * 	С���(0,0)->(6,5)
	 * @param map ��ʾ�Թ�
	 * @param i 
	 * @param j 
	 * @return ��ʾ�ҵ��˿���ȥ���Ľڵ�
	 */
	public boolean setWay(int[][] map,int i,int j) {
		
		if(map[6][5]==2) {
			return true;
		}else {	/*С����·���ԣ�[��->��->��->��] �߲�ͨ����� */
			if(map[i][j]==0) { //��ǰλ��û���߹�
				map[i][j]=2;
				if(setWay(map,i+1,j)) {  //��
					return true;
				}else if(setWay(map,i,j+1)) { //��
					return true; 
				}else if(setWay(map,i-1,j)) { //��
					return true;
				}else if(setWay(map,i,j-1)) { //��
					return true;
				}else {
					return false;
				}
			}else { // map[i][j]==1,2,3�޷���
				return false;
			}
		}
	}
	
	public void print(int[][] map) {
		
		for(int[] temp:map) {
			for(int data:temp) {
				System.out.print(data+" ");
			}
			System.out.println();
		}
	}
}
