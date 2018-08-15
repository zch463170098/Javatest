package com.xidian.exam.toutiao;

import java.util.*;
import java.util.Scanner;

class Interval {
	int start, end;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class Mian02 {

	public static List<Interval> merge(List<Interval> intervals) {
		// write your code here
		List<Interval> result = new LinkedList<>();
		if (intervals == null || intervals.size() < 1) {
			return result;
		}
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});

		Interval prev = null;
		for (Interval item : intervals) {

			if (prev == null || prev.end < item.start) {
				result.add(item);
				prev = item;
			} else if (prev.end < item.end) {
				prev.end = item.end;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		
		List<Interval> list = new LinkedList<Interval>();
		List<Interval> res = new LinkedList<Interval>();
		sc.nextLine();
		
		for(int i = 0; i < m; i++) {
			String[]  singleInterval = sc.nextLine().split(";");
			for(int j = 0; j < singleInterval.length; j++) {
				String[] temp = singleInterval[j].split(",");
				Interval interval = new Interval(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
				list.add(interval);
			}
		}
//		System.out.println(list.size());
		
		res = merge(list);
		
		for(int i = 0; i < res.size(); i++) {
			Interval tempInterval = res.get(i);
			if(i==0)
				System.out.print(tempInterval.start+","+tempInterval.end);
			else
				System.out.print(";"+tempInterval.start+","+tempInterval.end);
		}
		
		sc.close();
	}
}