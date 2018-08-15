package com.xidian.exam.toutiao;
import java.util.Scanner;

public class Main01 {
	public static void main(String[] args0){
		Scanner scanner = new Scanner(System.in);
		String[] s = scanner.nextLine().split(",");
		
		int n = Integer.valueOf(s[0]);
		int m = Integer.valueOf(s[1]);
		int[][] g = new int[n][m];
		
		for(int i=0;i<n;i++){
			
			s = scanner.nextLine().split(",");
			
			for(int j=0;j<m;j++){
				
				g[i][j] = Integer.valueOf(s[j]);
			}
		}
		int[] res = maxArea(g);
		System.out.println(res[0]+","+res[1]);
	}
	
	public static int[] maxArea(int[][] g) {
		int[] res = new int[2];
		int sum = 0;
		
		for(int i = 0;i < g.length;i++){
			for(int j = 0;j < g[0].length;j++){
				if(g[i][j] == 1){
					int num = ds(g,i,j);
					res[0] = res[0]+1;
					res[1] = Math.max(num,res[1]);
				}
			}
		}
		return res;
	}
	public static int ds(int[][] g,int i,int j){
		if(i>=0&&i<g.length&&j>=0&&j<g[0].length&&g[i][j] == 1){
			g[i][j]=0;
			int num = 1 + ds(g,i-1,j) + ds(g,i+1,j) + ds(g,i,j-1) + ds(g,i,j+1)
					+ ds(g,i-1,j-1)+ ds(g,i-1,j+1)+ ds(g,i+1,j-1)+ ds(g,i+1,j+1);
			return num;
		}else
			return 0;
	}
}