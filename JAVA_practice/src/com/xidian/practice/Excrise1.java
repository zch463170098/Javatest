package com.xidian.practice;

/**
 * 编写一个名为Outer的类，它包含一个名为Inner的类。在Outer类中添加一个方法，
 * 它返回一个Inner类型的对象，在main()中，创建并初始化一个指向某个Inner对象的
 * 引用。
 */
public class Excrise1 {
	/*定义一个内部类*/
	class Inner{
		Inner(){
			System.out.println("得到一个内部类的引用");
		}
	}
	/*外部类中定义一个返回Inner类型对象的方法*/
	public Inner getInner(){
		return new Inner();
	}
	public static void main(String[] args){
		Excrise1 e = new Excrise1();
		/*在main()中，创建并初始化一个指向某个Inner对象的引用*/
		Excrise1.Inner i = e.getInner();//方法一：通过调用外部类返回内部类引用的方法
		Excrise1.Inner i2 = e.new Inner();//方法二：利用外部对象引用新建一个内部类对象引用
	}
}
