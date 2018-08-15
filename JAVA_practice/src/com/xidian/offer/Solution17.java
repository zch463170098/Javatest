package com.xidian.offer;

import java.util.ArrayList;

/*
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
/*
 * 这道题 目前还有两个地方不太明白
 * 1.计算圈数的问题
 * 2.限制条件额判断以及与关系后面你的限制条件
 */
public class Solution17 {
	
	public ArrayList<Integer> printMatrix(int [][] matrix){
		ArrayList<Integer> arrayList = new ArrayList<>();
		int rows = matrix.length;
		int columns = matrix[0].length;
		if(columns == 0) {
			return arrayList;
		}  
		
		// 计算圈数,需要自己手动去找一下规律
		int layers = ((rows<columns?rows:columns)-1)/2+1;
		
	    for(int i =0;i<layers;i++) {
	    	for(int k =i;k<columns-i;k++) {
	    		arrayList.add(matrix[i][k]);  //左至右
	    	}
	    	for(int j = i+1;j<rows-i;j++) {
	    		arrayList.add(matrix[j][columns-i-1]);  //右上到下
	    	}
	    	for(int k = columns-i-2;(k>=i)&&(rows-i-1!=i);k--) {
	    		arrayList.add(matrix[rows-i-1][k]);  //右下到左
	    	}
	    	for(int j = rows-i-2;(j>i)&&(columns -i-1 != i);j--) {
	    		arrayList.add(matrix[j][i]);      //左下到上
	    	}
	    }
		return arrayList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
