package com.xidian.algorithm.dp;
import java.util.Scanner;
/**
 * 
 * @author Administrator
 * һ��N*N�������в�ͬ��������������������ӣ����ܻ����Ӧ��ֵ�Ľ������������ߵ����£�ֻ�����������ߣ����ܹ���õ�����ֵ�����磺3 * 3�ķ���

1 3 3 
2 1 3 
2 2 1

�ܹ���õ�����ֵΪ��11��
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
