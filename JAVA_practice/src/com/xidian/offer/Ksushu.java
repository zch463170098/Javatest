package com.xidian.offer;

import java.util.Scanner;

/**
 * @author Zhang Chenghui
 * E-mail: 463170098@qq.com
 * @version 1.0 
 * 创建时间：2018年4月15日 上午10:44:26
 * 说明：
 */
public class Ksushu {
	
	public static void  main(String[] arges){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] k = new int[n];
		int [][] a = new int[n][];
		for(int i=0;i<n;i++){
//			 k[i] = scanner.nextInt();
			 int count = 0;
			 while(scanner.hasNext()){
//				 if(scanner.next().equals("\n")){
//					 break;
//				 }
//				 scanner.useDelimiter(" ");
				 a[i][count] = scanner.nextInt();
				 count++;
				 
			 }
		}
		scanner.close();
	}

}

