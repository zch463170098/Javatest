package com.xidian.exam.beike;
import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			double  n = scanner.nextInt();
			 int m = scanner.nextInt();
			 double sum = 0;
			for(int i =0;i<m;i++) {
				sum = sum+n;
				n = Math.sqrt(n);
			}
			System.out.printf("%.2f",sum);
            System.out.println();
		}
	}

}

