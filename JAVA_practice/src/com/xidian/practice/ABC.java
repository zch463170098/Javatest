package com.xidian.practice;
import java.util.Scanner;

public class ABC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("star");
		long[] a = new long[100];
		long[] b = new long[100];
		long[] c = new long[100];
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
//		System.out.println(num);
		for (int i = 0;i<num;i++){
			a[i] = scanner.nextLong();
			b[i] = scanner.nextLong();
			c[i] = scanner.nextLong();
		}
		scanner.close();
		for(int i = 0;i < num;i++) {
			if(a[i]+b[i]>c[i])
				System.out.println("Case #"+(i+1)+": true");
			else
				System.out.println("Case #"+(i+1)+": false");
		}
	}

}
