package com.xidian.practice;

import java.lang.reflect.*;
class T{
	public int i;
}
public class Reflect extends T{
	public int num;
	public T[] sss;
	private String str = "xidian";
	public Reflect(int i){
		System.out.println("通过反射机制构造带参数的实例对象成功");
	}
	private Reflect(int i,int j){
	}
	public void f(int i){
		System.out.println("调用了f方法 i = "+i);
	}
	public String g(char c){
		return "";
	}
	private int k(){
		System.out.println("调用private权限的方法成功");
		return 999;
	}
	public  static void main(String[] args) throws ClassNotFoundException{
		Class c = Class.forName("com.xidian.practice.Reflect");
		Method[] methods = c.getMethods();
		Constructor[] ctors = c.getConstructors();//返回的是public权限的构造器
		System.out.println("1. 输出这个类中的所有public方法");
		for(Method m : methods){
			System.out.println(m.toString());
		}
		
		System.out.println("**********************************************************************");
		System.out.println("2. 输出这个类中的所有public构造器方法：");
		for(Constructor con : ctors){
			System.out.println(con.toString());
		}			
		System.out.println("**********************************************************************");
		System.out.println("3. 根据反射机制调用非默认构造器创建实例对象");
		Constructor constructor = ctors[0];
		Reflect r = null;
		try {
			r = (Reflect) constructor.newInstance(3);			
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		System.out.println("**********************************************************************");
		System.out.println("4. 应用反射机制调用方法");
		try {
			methods[1].invoke(r, 8866);
		} catch (IllegalAccessException e1) {			
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {			
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {			
			e1.printStackTrace();
		}
		System.out.println("**********************************************************************");
		System.out.println("5. 应用反射机制也可以调用类中的指定的方法个，即使是private访问权限的");
		try {
			Method mm = c.getDeclaredMethod("k");
			System.out.println(mm);
			mm.setAccessible(true);
			mm.invoke(r);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("**********************************************************************");
		
		System.out.println("6. 返回一个包含某些 Field 对象的数组，这些对象反映此 Class 对象所表示的类或接口的所有可访问公共字段()也包含它继承自父类的可用的可访问的公共字段");
		Field[] fs = c.getFields();
		for(Field f:fs){
			System.out.println(f);
		}
		System.out.println("**********************************************************************");
		System.out.println("7. 访问对象中非public权限的成员变量");
		try {
			Field f = c.getDeclaredField("str");
			f.setAccessible(true);
			System.out.println(f.get(r));
		} catch (NoSuchFieldException | SecurityException  | IllegalAccessException e) {
			e.printStackTrace();
		}	
	}
}
