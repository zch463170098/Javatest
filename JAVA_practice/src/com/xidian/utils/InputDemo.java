package com.xidian.utils;
import java.util.Scanner;

/**
 * @author Zhang Chenghui
 * E-mail: 463170098@qq.com
 * @version 1.0 
 * ����ʱ�䣺2018��4��15�� ����10:59:01
 * ˵������ϰ����̨���������
 */
public class InputDemo {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);   //��׼����̨����
		// ����һ�����ݣ�����ת����������,
		String[] fistLine = scanner.nextLine().trim().split(",");
		int[] data = new int[fistLine.length];
		for(int i = 0;i<data.length;i++) {
			System.out.println(data[i]=Integer.parseInt(fistLine[i]));
		}
		scanner.close();
		
	}
	

}

