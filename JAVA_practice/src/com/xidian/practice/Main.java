package com.xidian.practice;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * ��������ԭ�򣬵���ʱ�䲻̫���ã�дһ�´���˼·��
 * ���õϽ�˹�����㷨���ֱ����ÿ��������֮������·��
 * @author Administrator
 *
 */

public class Main {
	/**
	 * ����ַ�����������ֵ��תΪintֵ
	 * @param zuobiao
	 * @return
	 */
	public static int[] getZuobiao(String zuobiao) {
		int a[] = new int[2];
		
		return a;
	}

/** ������������������ʵ����ĿҪ��Ĺ��� **/
 /** ��Ȼ����Ҳ���Բ��������ģ����������ȫ�����Լ����뷨�� ^-^  **/
    static int calculate(String[] locations) {
    	int distance = 0;
    	int num = locations.length;
    	int[] l = new int[num];
    	
    	for(int i =0;i<num;i++) {
    		
    	}
    	return distance;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine().trim());
        int index = 0;
        String[] locations = new String[num];
        while(num-- > 0){
            locations[index++] = scanner.nextLine();
        }

        System.out.println(calculate(locations));  
    }
}