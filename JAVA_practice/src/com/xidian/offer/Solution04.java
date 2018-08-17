package com.xidian.offer;

/*
 * �ַ���
 * �滻�ո�
 * ��ĿҪ����ʵ��һ�����������ַ����е�ÿ���ո��滻�ɡ�%20����
 * �������롰we are happy���������Ϊ��we%20are%20happy����
 */

public class Solution04 {
	
	/**
	 * ֱ������java�ṩ����api
	 * @param str
	 * @return
	 */
    public static  String replaceSpace(StringBuffer str) {
    
    	return str.toString().replaceAll(" ", "%20");
    }
    
    /**
     *   ʱ�临�Ӷ�ΪO(n2)�Ľⷨ��ֱ�۵�������
     *   ��ǰ���������ո������滻��
     *   Ȼ���ƶ�������ַ���������ظ��ƶ���
     * @param str
     * @return
     */
    public static String replaceSpace02(StringBuffer str) {
    	/*
    	 *  ���Ƽ�ʹ�ã�ͬʱ����������Խ������⣬
    	 *  ��˻���Ҫ���ȶ������������
    	 */
    	
    	for(int i = 0;i<str.length();i++) {
    		if(str.charAt(i) == ' ') {
    			for(int j = str.length()-1;j>i;j--) {
    				str.setLength(str.length()+2);   //ÿ�������пո񣬾Ͷ���������������Ԫ
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
     * ʱ�临�Ӷ�ΪO(n)�Ľⷨ���Ӻ���ǰ�滻
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
