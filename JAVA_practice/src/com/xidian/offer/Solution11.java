package com.xidian.offer;

/*
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��
 * ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ��λ������ĺ�벿�֣�
 * ����֤������������ż����ż��֮������λ�ò���
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
	        * ע��;��������������ָ�ֵ��ʽ�Ļ����൱�ڸ�array������temp�����ã�����ԭ������
	        * �����ָ�Ϊ֮ǰ�����õ�ַ�����Ե�������δ�����ı䣬����ֻ��ѭ����ֵ
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
