package com.xidian.utils;
import java.util.Scanner;

/**
 * @author Zhang Chenghui
 * E-mail: 463170098@qq.com
 * @version 1.0 
 * 创建时间：2018年4月15日 下午10:59:01
 * 说明：
 */
public class InputDemo {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);   //标准控制台输入
		int data = sc.nextInt();
		System.out.println(data);
		int count = 0;
		while (sc.hasNext()){
			String inputStr = sc.next();
			System.out.println("第"+count+"次输入："+inputStr);
			count++;
		}
		sc.close();
	}
	

}

