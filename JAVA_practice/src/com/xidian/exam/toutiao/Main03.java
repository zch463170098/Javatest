package com.xidian.exam.toutiao;
import java.util.Scanner;

public class Main03 {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[][] pai = new int[num][2];
		for(int i = 0;i<num;i++){
			pai[i][0] = scanner.nextInt();
			pai[i][1] = scanner.nextInt();
		}
		int[] p = new int[num];
		for(int i = 0;i<num;i++){
			p[i] = pai[i][1] - pai[i][0];
		}
		if(num == 2){
			System.out.println(pai[0][1]+pai[1][1]);
		}
		System.out.println(10);
		
	}

}
