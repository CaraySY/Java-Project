package com.syw.recursion;

public class MazeProblem {

	/*初始化迷宫 8*7 四周设置为1即为墙 */
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
	 * 	小球从(0,0)->(6,5)
	 * @param map 表示迷宫
	 * @param i 
	 * @param j 
	 * @return 表示找到了可以去往的节点
	 */
	public boolean setWay(int[][] map,int i,int j) {
		
		if(map[6][5]==2) {
			return true;
		}else {	/*小球走路策略：[下->右->上->左] 走不通则回溯 */
			if(map[i][j]==0) { //当前位置没有走过
				map[i][j]=2;
				if(setWay(map,i+1,j)) {  //下
					return true;
				}else if(setWay(map,i,j+1)) { //右
					return true; 
				}else if(setWay(map,i-1,j)) { //上
					return true;
				}else if(setWay(map,i,j-1)) { //左
					return true;
				}else {
					return false;
				}
			}else { // map[i][j]==1,2,3无法走
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
