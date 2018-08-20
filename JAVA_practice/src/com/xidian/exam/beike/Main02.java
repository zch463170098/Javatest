package com.xidian.exam.beike;
import java.util.Scanner;
/**
 * ÐÞÂ·
 * @author Administrator
 *
 */

public class Main02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int num = sc.nextInt();
		int min =0;
		int sum = 0;
		int[] nums = new int[num];
		for(int i = 0;i<num;i++) {
			nums[i] = sc.nextInt();
			sum = sum+nums[i];
		}
		sc.close();
		min = nums[0];
		for(int i =1;i<num;i++) {
			if(nums[i]<min) {
				min = nums[i];
			}
		}
		System.out.println(sum-min);
	}

}
