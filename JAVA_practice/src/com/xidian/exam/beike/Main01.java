package com.xidian.exam.beike;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ÆË¿ËÅÆ
 * @author Administrator
 *
 */


public class Main01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		String str = sc.nextLine();
		char[] charAll = str.toCharArray();
		int len = charAll.length;
		int[] counts = new int[13];
		for(int i =0;i<charAll.length;i++) {
			switch(charAll[i]) {
			case'A':counts[0]++;break;
			case'2':counts[1]++;break;
			case'3':counts[2]++;break;
			case'4':counts[3]++;break;
			case'5':counts[4]++;break;
			case'6':counts[5]++;break;
			case'7':counts[6]++;break;
			case'8':counts[7]++;break;
			case'9':counts[8]++;break;
			case'T':counts[9]++;break;
			case'J':counts[10]++;break;
			case'Q':counts[11]++;break;
			case'K':counts[12]++;break;
			}
		}
		int count = 0;
		for(int i=0;i<13;i++) {
			if(counts[i]>0) {
				
			}
		}
		
		System.out.println(4);
		
	}
		

}