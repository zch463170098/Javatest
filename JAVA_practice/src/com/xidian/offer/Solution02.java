package com.xidian.offer;

/*
 * 实现单例模式
 * 题目要求：设计一个类，我们只能生成该类的一个实类。
 * 设计模式中的单类模式
 * 方法：
 */

public class Solution02 {
	//构造函数设置为私有函数,
	//这种方式只适用于单线程环境
	private Solution02() {
		
	}
	
	private static Solution02 instance = null;
	
	//适用于单线程
	public static Solution02 getInstance() {
		if(instance == null ) {
			instance = new Solution02();
			return instance;
		}else {
			return instance;
		}
	}
	
	/**
	 * 适用于多线程环境，增加同步锁，但是效率不高
	 * 因为在任何时候只有一个线程去调用getInstance02方法
	 * 同时枷锁操作也是十分耗时的
	 * @return
	 */
	public static synchronized Solution02 getInstance02() {
		if(instance == null) {
			instance = new Solution02();
			return instance;
		}
		return instance;
		
	}
	/**
	 * 再一次改进，在实类没有创建之前加锁，保证只有一个线程创建实例
	 * 
	 * @return
	 */
	public static Solution02 getInstance03() {
		if(instance == null) {
			synchronized (Solution02.class) {
				instance = new Solution02();
				return instance;
			}
			
		}
		return instance;
	}
	/*
	 * 强烈推荐的方法，静态内部类
	 * 静态内部类只会被加载一次，并且是线程安全的。
	 */
	private static class Holder{
		private static Solution02 instance = new Solution02();
	}
	
	public static Solution02 getInstance04() {
		return Holder.instance;
	} 
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
