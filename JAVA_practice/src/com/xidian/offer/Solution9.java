package com.xidian.offer;
/**
 * ����һ��double���͵ĸ�����base��int���͵�����exponent��
 * ��base��exponent�η���
 * @author Administrator
 * 
 * ע��Ҫ����ָ��Ϊ0�͸��������
 *
 */

public class Solution9 {
	
	
	public double Power(double base,int exponent){
		double result = 1;
		int i;
		if(exponent>0){
		    for(i = 0;i<exponent;i++){
			    result = result * base;
		    }  
		}else if(exponent == 0){
			result = 1;
		}else{
			for(i = 0;i > exponent;exponent++){
				 result = result * base;
			}
			result = 1/result;
			
		}
		return result;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Solution9 solution9 =new Solution9();
        System.out.println(solution9.Power(2,-3));
	}

}
