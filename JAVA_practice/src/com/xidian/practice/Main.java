package com.xidian.practice;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * 由于其他原因，导致时间不太够用，写一下大体思路，
 * 运用迪杰斯特拉算法，分别求出每个两两点之间的最短路径
 * @author Administrator
 *
 */

public class Main {
	/**
	 * 求出字符串返回坐标值，转为int值
	 * @param zuobiao
	 * @return
	 */
	public static int[] getZuobiao(String zuobiao) {
		int a[] = new int[2];
		
		return a;
	}

/** 请完成下面这个函数，实现题目要求的功能 **/
 /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
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