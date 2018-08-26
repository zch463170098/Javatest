package com.xidian.exam.toutiao;
import java.util.Scanner;
import java.util.*;

public class Main08 {
	public static boolean fCore(String a,String b) {
		if(a.length()!=b.length()) {
			return false;
		}
		if(a.length()==0) {
			return true;
		}
		if(a.length()==1) {
			if(a.charAt(0)==b.charAt(0)) {
				return true;
			}
		}
		
		if(a.equals(b)) {
			return true;
		}
		
		int i,j,k;
		char[] tmp =a.toCharArray();
		for(i =0;i<a.length();i++) {
			for(j=i,k=0;k<a.length();k++,j++) {
				j = j%a.length();
				tmp[k] = a.charAt(j);
			}
			if(tmp.equals(b))
				return true;
			for(j=i;j<a.length();j--,k++) {
				j=(j+a.length())%a.length();
				k = k%tmp.length;
				tmp[k] =a.charAt(j);
			}
			if(tmp.equals(b))
				return true;
		}
		return false;
	}
	
	public static boolean f(ArrayList<String> vec) {
		boolean flag = false;
		int i,j;
		for(i = 0;i<vec.size();i++) {
			for(j=i+1;j<vec.size();j++) {
			flag = fCore(vec.get(i),vec.get(j));
			if(flag)
				break;
			}
			if(flag) {
				break;
			}
		}
	    return flag;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> vec = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i =0;i<t;i++) {
			int n = Integer.parseInt(sc.nextLine());
			for(int j =0;j<n;j++) {
				vec.add(sc.nextLine());
			}
		}
		boolean re;
		re = f(vec);
		if(re) {
			System.out.println("Yeah");
		}else {
			System.out.println("Sad");
		}
	}

}
