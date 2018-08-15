package com.xidian.offer;

/*
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变
 */
public class Solution11 {

	  public void reOrderArray(int [] array) {
		   int length = array.length; 
		   int countOdd = 0;
	       int [] temp = new int [length];
	       
	       for(int i = 0;i < length;i++ ) {
	    	   if(array[i]%2 == 1) {
	    		   temp[countOdd] = array[i];
	    		   countOdd++;
	    		 
	    	   }
	       }
	       
	       for(int i = 0;i < length;i++ ) {
	    	   if(array[i]%2 == 0) {
	    		   temp[countOdd] = array[i];
	    		   countOdd++;
	    		 
	    	   }
	       }
	       /*
	        * 注意;这里如果按照这种赋值方式的话，相当于给array传递了temp的引用，返回原方法后，
	        * 引用又改为之前的引用地址，所以导致数据未发生改变，所以只能循环赋值
	        */
	       for(int i = 0;i<length;i++) {
	    	   array[i] = temp[i];
	       }
	     

	    }
	  public static void main (String[] args) {
		  int[] a = {1,2,3,4,5,6,7};
		  Solution11 s = new Solution11();
		  s.reOrderArray(a);
		  for(int i = 0;i < a.length;i++) {
			  System.out.println(a[i]);
		  }
	  }
	  
}
