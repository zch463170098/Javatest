package com.xidian.exam.beike;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * 社团
 * 有更暴力简单的方法，直接枚举删除即可
 * @author Administrator
 *
 */

public class Main03 {
	public static boolean result(int[][] times,int p) {
		int row = times.length;
		for(int i =0;i<row;i++) {
			if(i==p)
				continue;
			
			for(int j= i+1;j<row;j++) {
				if(j==p)
					continue;
				if(hasjiaoji(times[i][0],times[i][1],times[j][0],times[j][1]))
					return false;
			}
		}
		return true;		
	}
	
	public static boolean hasjiaoji(int a,int b,int c,int d) {
		if(b<=c) {
			return false;
		}else if(a>=d) {
			return false;
		}else {
			return true;
		}		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		int[][] times =new int[n][2];
		for(int i =0;i<n;i++) {
			times[i][0] = sc.nextInt();
			times[i][1] = sc.nextInt();
		}
		sc.close();
		int[][] flag = new int[n][n];
		for(int i = 0;i<n;i++) {
			for(int j=i+1;j<n;j++){
				if(hasjiaoji(times[i][0],times[i][1],times[j][0],times[j][1])) {
					flag[i][j] = 1;
				}
			}
		}
		Set<Integer> set = new HashSet<>();
		boolean fg =true;
		for(int i =0;i<n;i++) {
			for(int j= i+1;j<n;j++) {
				if(flag[i][j] == 1) {
					fg =false;
					if(result(times,i)) {
						set.add(i);
					}
					if(result(times,j)) {
						set.add(j);
					}
				}
			}
		}
		int out =set.size();

		if(fg) {
			System.out.println(n);
			for(int i =1;i<=n;i++) {
				System.out.print(i+" ");
			}
			return;
		}
		System.out.println(out);
		Iterator<Integer> it =  set.iterator();
		while(it.hasNext()) {
			int a= it.next()+1;
			System.out.print(a+" ");
		}					
	}

}
