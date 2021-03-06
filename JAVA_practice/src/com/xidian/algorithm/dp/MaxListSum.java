package com.xidian.algorithm.dp;
import java.util.Scanner;

/**
 * 
 * @author Administrator
 *N个整数组成的序列a[1],a[2],a[3],…,a[n]
 *，求该序列如a[i]+a[i+1]+…+a[j]的连续子段和的最大值。 当所给的整数均为负数时和为0。 
例如：-2,11,-4,13,-5,-2，和最大的子段为：11,-4,13。和为20。
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
