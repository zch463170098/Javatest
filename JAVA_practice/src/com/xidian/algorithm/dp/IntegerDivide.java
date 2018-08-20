package com.xidian.algorithm.dp;

import java.util.Scanner;

//��һ����������Ϊ2�飬Ҫ��2��ĺ������С�� 
//���磺1 2 3 4 5����1 2 4��Ϊ1�飬3 5��Ϊ1�飬��������1�������з�����������ٵġ�

/*
 * �����൱�ڱ�������ı��֣�˼·�����������ϵĲ�ֵһ���ǽӽ���sum/2
 * ���Ż���С����˾ͼ���һ����������������sum/2
 * ��ô�ʱ�����ֵ�Ϳ�
 */

public class IntegerDivide {

	 public static void main(String[] args) {

	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        long sum = 0, max = 0;
	        int[] nums = new int[n];
	        for (int i = 0; i < n; i++) {
	            nums[i] = in.nextInt();
	            sum += nums[i];
	        }
	        int[] dp = new int[(int) (sum / 2 + 1)];
	        for (int i = 0; i < n; i++)
	            for (int j = (int) (sum / 2); j > 0; j--)
	                if (j >= nums[i])
	                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
	        for (int i = 1; i < sum / 2 + 1; i++)
	            max = max > dp[i] ? max : dp[i];
	        System.out.println(Math.abs((sum - max) - max));
	    }
}
