package com.xidian.offer;

/**
 * @author Zhang Chenghui
 * E-mail: 463170098@qq.com
 * @version 1.0 
 * 创建时间：2017年10月22日 下午11:57:36
 * 说明：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 还是斐波那契数列
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

