package com.xidian.offer;

/**
 * @author Zhang Chenghui
 * E-mail: 463170098@qq.com
 * @version 1.0 
 * ����ʱ�䣺2018��4��1�� ����10:55:02
 * ˵����
 */
public class JuXingFuGai {
	public static int RectCover(int target){
		int result;
		if(target==1){
			return 1;
		}else if(target ==0){
			return 0;
		}else if(target ==2){
			return 2;
		}
		else {
			result = RectCover(target-1)+RectCover(target -2);
		}
		return result;
	}
	public static void main(String[] args){
		System.out.println(RectCover(4));
	}
}

