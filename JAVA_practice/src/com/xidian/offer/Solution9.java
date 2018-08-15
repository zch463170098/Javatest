package com.xidian.offer;
/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 * @author Administrator
 * 
 * 注意要考虑指数为0和负数的情况
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
