package com.wsy.leetcode_competition.t180;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbers {

	public static void main(String[] args) {
		
		int[][] matrix= {{1,10,4,2},{9,3,8,7},{15,16,17,12}};
		luckyNumbers(matrix);
	}
	
    public static List<Integer> luckyNumbers (int[][] matrix) {

    	List<Integer> list=new ArrayList<>();
    	int column_max=0;
    	int row_min=0;
    	int row=0,col=0;
    	for(int i=0;i<matrix.length;i++) {
    		row=i;
    		row_min=matrix[row][0];
    		col=0;
    		for(int j=0;j<matrix[0].length;j++) {
    			if(matrix[row][j] < row_min) {
    				row_min=matrix[row][j];
    				col=j;
    			}
    		}
    		column_max=matrix[0][col];
    		for(int k=0;k<matrix.length;k++) {
    			column_max=Math.max(column_max, matrix[k][col]);
    			
    		}
    		if(row_min==column_max) {
    			list.add(row_min);
    		}
    	}
        return list;
    }
}
