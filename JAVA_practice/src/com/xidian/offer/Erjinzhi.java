package com.xidian.offer;

/**
 * @author Zhang Chenghui
 * E-mail: 463170098@qq.com
 * @version 1.0 
 * ����ʱ�䣺2018��4��1�� ����11:24:16
 * ˵����
 */
public class Erjinzhi {
	

	public static int NumberOf1(int n){
		return Integer.toBinaryString(n).replaceAll("0", "").length();
		
	}
	

		 //---------------����--------------------------------
		//˼�룺��1��1�����������㣬��ʵ�����Ͳ���1�ˣ���n��ÿλ����λ�룬���ж�1�ĸ���
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

