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
public class Solution6 {
	public int minNumberInRotateArray(int [] array){
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

}

