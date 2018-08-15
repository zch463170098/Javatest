package com.xidian.offer;

import java.util.ArrayList;

/*
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
 * ���磬�����������4 X 4���� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
/*
 * ����� Ŀǰ���������ط���̫����
 * 1.����Ȧ��������
 * 2.�����������ж��Լ����ϵ���������������
 */
public class Solution17 {
	
	public ArrayList<Integer> printMatrix(int [][] matrix){
		ArrayList<Integer> arrayList = new ArrayList<>();
		int rows = matrix.length;
		int columns = matrix[0].length;
		if(columns == 0) {
			return arrayList;
		}  
		
		// ����Ȧ��,��Ҫ�Լ��ֶ�ȥ��һ�¹���
		int layers = ((rows<columns?rows:columns)-1)/2+1;
		
	    for(int i =0;i<layers;i++) {
	    	for(int k =i;k<columns-i;k++) {
	    		arrayList.add(matrix[i][k]);  //������
	    	}
	    	for(int j = i+1;j<rows-i;j++) {
	    		arrayList.add(matrix[j][columns-i-1]);  //���ϵ���
	    	}
	    	for(int k = columns-i-2;(k>=i)&&(rows-i-1!=i);k--) {
	    		arrayList.add(matrix[rows-i-1][k]);  //���µ���
	    	}
	    	for(int j = rows-i-2;(j>i)&&(columns -i-1 != i);j--) {
	    		arrayList.add(matrix[j][i]);      //���µ���
	    	}
	    }
		return arrayList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
