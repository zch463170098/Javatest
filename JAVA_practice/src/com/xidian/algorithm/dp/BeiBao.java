package com.xidian.algorithm.dp;

import java.util.Scanner;
/**
 * 
 * @author Administrator
 * 在N件物品取出若干件放在容量为W的背包里，每件物品的体积为W1，W2……Wn（Wi为整数），
 * 与之相对应的价值为P1,P2……Pn（Pi为整数）。求背包能够容纳的最大价值。
 *
 */
public class BeiBao {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int v = in.nextInt();
        int[] dp = new int[v + 1];
        int[] price = new int[n + 1];
        int[] weight = new int[n + 1];
        long max = 0;
        for (int i = 1; i < n + 1; i++) {
            weight[i] = in.nextInt();
            price[i] = in.nextInt();
        }
        for (int i = 1; i < n + 1; i++)
            for (int j = v; j > 0; j--)
                if (j - weight[i] >= 0)
                	//dp[j - weight[i]]表示剩余空间中的价值
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + price[i]);
        
                else
                    dp[j] = dp[j];
        for (int i = 0; i < v + 1; i++)
            max = max > dp[i] ? max : dp[i];
        System.out.println(max);
    }
}
