package com.xidian.offer;

/**
 * @author Zhang Chenghui
 * E-mail: 463170098@qq.com
 * @version 1.0 
 * 创建时间：2018年4月1日 下午10:55:02
 * 说明：
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

