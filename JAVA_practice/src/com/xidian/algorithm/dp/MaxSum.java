package com.xidian.algorithm.dp;
import java.util.Scanner;
/**
 * 
 * @author Administrator
 *һ���߶�ΪN������������ɵ������Σ������ߵ��£��󾭹������ֺ͵����ֵ�� 
ÿ��ֻ���ߵ���һ�����ڵ����ϣ�����ӵ�3���6�����ߣ�ֻ���ߵ���4���2��9�ϡ�

�������ε�n����n�����֣����磺

��һ����һ�����֣�5

�ڶ������������֣�8 4

���������������֣�3 6 9

���Ĳ����ĸ����֣�7 2 9 5

���ŷ����ǣ�5 + 8 + 6 + 9 = 28

ע��:����Ӧ�������г�һ�������ε����Ӳ��������Ӧ�ģ��Ű�����û����ʾ�������Ρ�

״̬����: Fi��j�ǵ�i��j�������ȡ���ͣ����n��Fn��m��0 < m < n�������ֵ��

״̬ת�Ʒ��̣�Fi��j = max{Fi-1,j-1,Fi-1,j}+Ai,j
 *
 */

public class MaxSum {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long max = 0;
        int[][] dp = new int[n][n];
        dp[0][0] = in.nextInt();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int num = in.nextInt();
                if (j == 0)
                    dp[i][j] = dp[i - 1][j] + num;  //�����������һ������
                else
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + num;
                max = Math.max(dp[i][j], max);
            }
        }
        System.out.println(max);
    }
	

}
