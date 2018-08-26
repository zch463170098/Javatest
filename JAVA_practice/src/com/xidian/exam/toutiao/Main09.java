package com.xidian.exam.toutiao;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Main09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		int[] p = new int[n];
		for(int i = 0;i<n;i++) {
			p[i] = sc.nextInt();
		}
		Stack<Integer> s = new Stack<>();
		for(int i =0;i<n;i++) {
			if(s.isEmpty()) {
				s.push(p[i]);
				
			}
			if(p[i]<s.peek()) {
				s.pop();
				s.push(p[i]);
			}
		}
		for(int i =0;i<t;i++) {
			for(int j=0;j<n;j++) {
				if(s.isEmpty()) {
					s.push(p[j]);
				}
				
				if(p[j]>=s.peek()) {
					s.push(p[j]);
				}
			}
		}
		System.out.println(t+r.nextInt(t+n-1));
		
	}

}
