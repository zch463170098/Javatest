package com.xidian.test;

import java.util.Arrays;
import java.util.concurrent.*;

public class Test {
	static String testStr;
	static double d;
	static int[] nums;
	
	static class inner{
		String a = testStr;
	}
	
	
	public static void f() throws Exception  {
		System.out.println("Exception begin");
		throw new Exception();
	}
	
	

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub

//		System.out.println(testStr);
//		System.out.println(d);
//		System.out.println(Arrays.toString(nums));
		try {
			f();
		}catch(Exception e) {
//			e.printStackTrace();  //打印的是调用栈的信息
			System.out.println(e.fillInStackTrace());
		}finally {
			System.out.println("end");
		}
	
		
	}

}
