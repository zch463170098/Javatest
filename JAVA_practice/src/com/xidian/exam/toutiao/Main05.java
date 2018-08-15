package com.xidian.exam.toutiao;


import java.util.Arrays;
import java.util.Scanner;

public class Main05 {
	private static boolean[] x;
	private static int[] y;

	public static class ACs implements Comparable<ACs> {

		private int startTime;// 开始时间
		private int endTime;// 结束时间

		public ACs(int startTime, int endTime) {
			super();
			this.startTime = startTime;
			this.endTime = endTime;
		}

		public ACs() {
			super();
		}

		public int getStartTime() {
			return startTime;
		}

		public void setStartTime(int startTime) {
			this.startTime = startTime;
		}

		public int getEndTime() {
			return endTime;
		}

		public void setEndTime(int endTime) {
			this.endTime = endTime;
		}

		/**
		 * 实现对活动排序的接口
		 */
		@Override
		public int compareTo(ACs o) {
			// TODO Auto-generated method stub
			return this.endTime - o.endTime;
		}

	}

	private static void GreedySeletor(int n, ACs[] s, boolean[] a) {
		a[1] = true;
		int j = 1;
		for (int i = 2; i <= n; i++) {
			if (s[i].getStartTime() >= s[j].getEndTime()) {
				a[i] = true;
				j = i;
			} else {
				a[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
//		if (N < 1 || N > Math.pow(10, 5)) {
//			return;
//		}
		int M = scan.nextInt();
//		if (M < 2 || M > Math.pow(10, 6)) {
//			return;
//		}
		x = new boolean[N + 1];
		x[0] = false;
		ACs[] A = new ACs[N + 1];
		A[0] = new ACs();
		int[] startTime = new int[N + 1];
		int[] endTime = new int[N + 1];
		startTime[0] = 0;
		endTime[0] = 0;
		for (int i = 1; i <= N; i++) {
			startTime[i] = scan.nextInt();
			endTime[i] = scan.nextInt();
//			if (startTime[i] > M || endTime[i] > M) {
//				return;
//			}
		}
		for (int i = 1; i <= N; i++) {
			A[i] = new ACs(startTime[i], endTime[i]);
		}
		Arrays.sort(A);

		GreedySeletor(N, A, x);
		int times = 0;
		for (int i = 1; i <= N; i++) {
			if (x[i])
				times++;
		}
		System.out.println(times);
	}
}