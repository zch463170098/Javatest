package com.xidian.exam;

import java.util.Scanner;
import java.util.Stack;
/**
 * Keep��һ�������⣬��Ŀ�ܳ�Ҳû��ס�����ľ�����0 1�������ҵ����ľ���
 * @author Administrator
 *����0 1 �����������ε�����
 *ת��Ϊ��ֱ��ͼ������������
 *˼·��������������ÿһ��ͳ��Ϊһ��ֱ��ͼ�����൱����ֱ��ͼ�����������
 *����ֱ��ͼ�о��ε���⣬���Խ��˳��ֱ��ͼ�е�����ջ�ķ�ʽ
 *ע��ջ�д�ŵ����±꣨������
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
					int currMax =nums[top]*(i-top);   //ע��˴��ļ��㼼�ɹ�ʽ
					max = Math.max(max, currMax);
				}
			}else {
				int count = 1;
				while(!stack.isEmpty()) {
					int currMax = nums[stack.pop()]*count;  //���Ҳ��
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
