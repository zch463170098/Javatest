package com.xidian.offer;

/**
 * @author Zhang Chenghui
 * E-mail: 463170098@qq.com
 * @version 1.0 
 * ����ʱ�䣺2017��10��22�� ����11:57:36
 * ˵����һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж�����������
 * ����쳲���������
 */
public class Solution8 {
	public int JumpFloor(int target){
		if(target == 1 || target == 2){
			return target;
		}
		int jumpSum = 0;
		int jumpBackStep1 = 2;
		int jumpBackStep2 = 1;
		
		for(int i =3;i<=target;i++){
			jumpSum = jumpBackStep1 + jumpBackStep2;
			jumpBackStep2 =jumpBackStep1;
			jumpBackStep1 = jumpSum;
		}
		return jumpSum;
	}
	
	

}

