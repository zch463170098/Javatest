package com.xidian.exam;

import java.util.Scanner;
import java.util.Stack;
/**
 * Keep的一道笔试题，题目很长也没记住，核心就是在0 1矩阵中找到最大的矩形
 * @author Administrator
 *计算0 1 矩阵中最大矩形的问题
 *转化为求直方图的最大矩形问题
 *思路：经典做法，将每一行统计为一个直方图，就相当于在直方图中求解最大矩形
 *对于直方图中矩形的求解，可以借鉴顺序直方图中的利用栈的方式
 *注意栈中存放的是下标（索引）
 *
 */
public class MainTest {
	
	public static int maxSum(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		int max =0;
		for(int i =0;i<nums.length;i++) {
			if(nums[i]!=0) {
				if(stack.size() == 0) {
					stack.push(nums[i]);
				}
				if(nums[i]>=nums[stack.peek()]) {
					stack.push(i);
				}else {
					int top = nums[stack.pop()];
					int currMax =nums[top]*(i-top);   //注意此处的计算技巧公式
					max = Math.max(max, currMax);
				}
			}else {
				int count = 1;
				while(!stack.isEmpty()) {
					int currMax = nums[stack.pop()]*count;  //这块也是
					count++;
					max = Math.max(max, currMax);
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] c = new int[m][n];
		int[] sums = new int[m];
		for(int i =0;i<m;i++) {
			for(int j =0;j<n;j++) {
				c[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 1;i<m;i++) {
			for(int j = 0;j<n;j++) {
				if(c[i][j]==1) {
					c[i][j] = c[i-1][j]+c[i][j];
				}
			}
		}
		int max = 0;
		for(int i =0;i<m;i++) {
			max = Math.max(max, maxSum(c[i]));
		}
		
		System.out.println(max);
	}

}
