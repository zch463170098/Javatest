package com.xidian.utils;
import java.util.Scanner;

/**
 * @author Zhang Chenghui
 * E-mail: 463170098@qq.com
 * @version 1.0 
 * ����ʱ�䣺2018��4��15�� ����10:59:01
 * ˵����
 */
public class InputDemo {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);   //��׼����̨����
		int data = sc.nextInt();
		System.out.println(data);
		int count = 0;
		while (sc.hasNext()){
			String inputStr = sc.next();
			System.out.println("��"+count+"�����룺"+inputStr);
			count++;
		}
		sc.close();
	}
	

}

