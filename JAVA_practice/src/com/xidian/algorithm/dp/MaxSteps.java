package com.xidian.algorithm.dp;
import java.util.Scanner;
/**
 * 
 * @author Administrator
 * 一个N*N矩阵中有不同的正整数，经过这个格子，就能获得相应价值的奖励，从左上走到右下，只能向下向右走，求能够获得的最大价值。例如：3 * 3的方格。

1 3 3 
2 1 3 
2 2 1

能够获得的最大价值为：11。
 *
 */
public class MaxSteps {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] dp = new int[n + 1];
        int[] readArr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            for (int k = 1; k < n + 1; k++)
                readArr[k] = in.nextInt();
            for (int j = 1; j < n + 1; j++)
                dp[j] = Math.max(dp[j], dp[j - 1]) + readArr[j];
        }
        System.out.println(dp[n]);
    }

}
