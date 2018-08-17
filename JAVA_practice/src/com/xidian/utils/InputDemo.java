package com.xidian.utils;
import java.util.Scanner;

/**
 * @author Zhang Chenghui
 * E-mail: 463170098@qq.com
 * @version 1.0 
 * 创建时间：2018年4月15日 下午10:59:01
 * 说明：练习控制台的输入输出
 */
public class InputDemo {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);   //标准控制台输入
		// 读入一行数据，并且转换到数组中,
		String[] fistLine = scanner.nextLine().trim().split(",");
		int[] data = new int[fistLine.length];
		for(int i = 0;i<data.length;i++) {
			System.out.println(data[i]=Integer.parseInt(fistLine[i]));
		}
		scanner.close();
		
	}
	

}

