package com.xidian.offer;

/**
 * @author Zhang Chenghui
 * E-mail: 463170098@qq.com
 * @version 1.0 
 * ����ʱ�䣺2017��10��14�� ����9:04:50
 * ˵������һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
 *  ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء� 
 *  ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת��
 * ���������СֵΪ1�� NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 */

import java.util.ArrayList;
public class Solution08 {
	
    /**
     * ���淽���������Ǹ�ͻȻ�ݼ���������
     * ʱ�临�Ӷ�o(n)
     * @param array
     * @return
     */
	public int minNumberInRotateArray01(int [] array){
		//����Ϊ��ʱ
		if(array.length==0){
			return 0;
		}
		//����������ת
		for (int i=0;i<array.length-1;i++){
			if(array[i]>array[i+1]){
				return array[i+1];
			}
		}
		// ȫ����ת���൱��û����ת
		return array[0];
	}
	
	public static int method(int[] array) {
		//�߽�
		if(array.length<=0) {
			return 0;
		}
		int low = 0;
		int high = array.length-1;
		int mid =0;
		while(low<high) {
			mid = (low+high)/2;
			if(array[mid]>array[low]&&array[mid]>array[high]) {
				low = mid+1;
			}else if(array[mid]<array[low]&&array[mid]<array[high]) {
				high = mid;  //ע��˴�����-1 ����Ϊarray[mid]�����п����Ѿ���Ҫ�ҵ�����
		    }else {
			
				high = mid;  //ע�� ���û���ⲽ����Ϊ��������ʱ��ͻ���������ѭ��+
			}
		}
		return array[mid];
	}
	
	public static void main(String[] args) {
		int[] array = {5,6,7,8,1,2,3,4};
		System.out.println(method(array));
	}
	

}

