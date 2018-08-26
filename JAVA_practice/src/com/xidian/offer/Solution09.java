package com.xidian.offer;

/**
 * @author Zhang Chenghui
 * E-mail: 463170098@qq.com
 * @version 1.0 
 * ����ʱ�䣺2017��10��15�� ����9:19:22
 * ˵����쳲��������У�Ҫ������һ������n�����쳲��������еĵ�n��n��=39��
 */
public class Solution09 {
	/**
	 * ����ͨ�ķ���
	 * @param n
	 * @return
	 */
	public int Fibonacci1(int n){
		if(n>39){
			return 0;
		}
		if(n==0)
			return 0;
		
		if(n==1){
			return 1;
		}
		
		
			return Fibonacci1(n-2)+Fibonacci1(n-1);
	}
	
	public int Fibonacci(int n){
		if(n == 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		int numfn1 = 0;
		int numfn2 = 1;
		int currentnum = 0;
		for(int i = 2;i <= n;i++){
			currentnum = numfn1 + numfn2;
			numfn1 = numfn2;
			numfn2 = currentnum;
		}
		return currentnum;
	}
	
	public static void main(String [] args){
		
		
	}

}

