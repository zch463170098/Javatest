package com.xidian.offer;

/**
 * @author Zhang Chenghui
 * E-mail: 463170098@qq.com
 * @version 1.0 
 * 创建时间：2018年4月1日 下午11:24:16
 * 说明：
 */
public class Erjinzhi {
	

	public static int NumberOf1(int n){
		return Integer.toBinaryString(n).replaceAll("0", "").length();
		
	}
	

		 //---------------正解--------------------------------
		//思想：用1（1自身左移运算，其实后来就不是1了）和n的每位进行位与，来判断1的个数
	public static int numberOf1(int n){
		int count =0;
		int flag = 1;
		while (flag != 0) {
			if ((n & flag) != 0) {
			 count++;
			}
			flag = flag << 1;
			}
		return count;
		
	}
	


	public static int NumberOf12(int n) {
		int count = 0;
		while (n != 0) {
			++count;
			n = (n - 1) & n;
		}
		return count;
	}
	
	public static void main(String[] args){
		System.out.println(NumberOf1(-10));
		System.out.println(numberOf1(-10));
		System.out.println(NumberOf12(-10));
	}
}

