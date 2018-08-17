package com.xidian.offer;

/*
 * 字符串
 * 替换空格
 * 题目要求：请实现一个函数，把字符串中的每个空格替换成“%20”。
 * 例如输入“we are happy。”则输出为“we%20are%20happy。”
 */

public class Solution04 {
	
	/**
	 * 直接利用java提供给的api
	 * @param str
	 * @return
	 */
    public static  String replaceSpace(StringBuffer str) {
    
    	return str.toString().replaceAll(" ", "%20");
    }
    
    /**
     *   时间复杂度为O(n2)的解法，直观的做法，
     *   从前往后遇到空格，依次替换，
     *   然后移动后面的字符，会出现重复移动。
     * @param str
     * @return
     */
    public static String replaceSpace02(StringBuffer str) {
    	/*
    	 *  不推荐使用，同时还存在数组越界的问题，
    	 *  因此还需要首先对数组进行扩充
    	 */
    	
    	for(int i = 0;i<str.length();i++) {
    		if(str.charAt(i) == ' ') {
    			for(int j = str.length()-1;j>i;j--) {
    				str.setLength(str.length()+2);   //每次碰到有空格，就对数组扩充两个单元
    				str.setCharAt(j+2, str.charAt(j)); 
    			}
    			str.setCharAt(i, '%');
    			str.setCharAt(i+1, '2');
    			str.setCharAt(i+2, '0');
    			i = i+2;
    		}
    	}
    	return str.toString();
    }
    /**
     * 时间复杂度为O(n)的解法，从后往前替换
     * @param str
     * @return
     */
    public static String replaceSpace03(StringBuffer str) {
    	int oldLength = str.length();
    	int indexOld = oldLength - 1;
    	int newLength = 0;
    	int count = 0;
    	for(int i = 0;i<oldLength;i++) {
    		if(str.charAt(i) == ' ')
    			count++;
    	}
    	newLength = oldLength + count*2;
    	int indexNew = newLength - 1;
    	str.setLength(newLength);
    	
    	for(;indexOld>=0;indexOld--) {
    		if(str.charAt(indexOld) == ' ') {
    			str.setCharAt(indexNew,'0');
    			str.setCharAt(indexNew--,'2' );
    			str.setCharAt(indexNew, '%');
    			
    		}else {
    			str.setCharAt(indexNew--, str.charAt(indexOld));
    		}
    		
    	}
    	return str.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringBuffer str = new StringBuffer("we are happy");
		String res01 = replaceSpace(str);
		System.out.println("result01"+res01);
		String res02 = replaceSpace02(str);
		System.out.println("result02"+res02);
		String res03 = replaceSpace03(str);
		System.out.println("result03"+res03);
		
	}

}
