package com.xidian.algorithm.dp;
import java.util.Scanner;

/**
 * 
 * @author Administrator
 *N��������ɵ�����a[1],a[2],a[3],��,a[n]
 *�����������a[i]+a[i+1]+��+a[j]�������Ӷκ͵����ֵ�� ��������������Ϊ����ʱ��Ϊ0�� 
���磺-2,11,-4,13,-5,-2���������Ӷ�Ϊ��11,-4,13����Ϊ20��
 */

public class MaxListSum {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long max = 0, subMax = 0;
        for (int i = 0; i < n; i++) {
            subMax += in.nextInt();
            if (max < subMax)
                max = subMax;
            if (subMax < 0)
                subMax = 0;
        }
        System.out.println(max);
    }

}
