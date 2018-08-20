package com.xidian.algorithm.dp;
import java.util.Scanner;

/**
 * 
 * @author Administrator
 * �༭���룬�ֳ�Levenshtein���루Ҳ����Edit Distance����
 * ��ָ�����ִ�֮�䣬��һ��ת����һ����������ٱ༭������������ɵı༭����������һ���ַ��滻����һ���ַ�������һ���ַ���ɾ��һ���ַ��� 
 * ���罫kittenһ��ת��sitting�� 
 * sitten ��k->s�� 
 * sittin ��e->i�� 
 * sitting ��->g�� 
����kitten��sitting�ı༭������3������˹��ѧ��Vladimir Levenshtein��1965����������� 
���������ַ���a,b����a��b�ı༭���롣
״̬����:Fi,j��ʾ��һ���ַ�����ǰi����ĸ�͵ڶ����ַ�����ǰj����ĸ��Ҫ�༭�Ĵ�������Fn,m��n��m�ֱ��������ַ����ĳ��ȡ�
״̬ת�Ʒ��̣� 
��Fi,j-1=Fi-1,jʱ��Fi,j=Fi-1,j-1�� 
��Fi,j-1��=Fi-1,jʱ��Fi,j=min{Fi-1,j-1,Fi,j-1,Fi-1,j}+1.
 *
 */

public class MinDistance {
	public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String aStr = in.nextLine();
        String bStr = in.nextLine();
        int aLen = aStr.length();
        int bLen = bStr.length();
        int[][] dp = new int[aLen + 1][bLen + 1];
        for (int i = 0; i < aLen + 1; i++) dp[i][0] = i;  // ĳ���ַ���Ϊ�յ������Ҳ������Ϊ�ǳ�ʼֵ��
        //�����ļ�¼����1֮��ľ�����
        for (int i = 0; i < bLen + 1; i++) dp[0][i] = i;
        for (int i = 1; i < aLen + 1; i++)
            for (int j = 1; j < bLen + 1; j++)
                if (aStr.charAt(i - 1) == bStr.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
        System.out.println(dp[aLen][bLen]);
    }

}
