package com.xidian.offer;

/**
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��
 * ʹ�����е�����λ�������ǰ�벿�֣�
 * ���е�ż��λ��λ������ĺ�벿�֣�����֤������������
 * ż����ż��֮������λ�ò��䡣
 * @author Administrator
 *
 */

public class Solution10 {

	public void reOrderArray(int[] array){
		int length = array.length;
		int[] b = new int[length];
		for(int i = 0;i < length;i++){
			if(array[i]%2 == 0){
				b[i] = array[i];
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
