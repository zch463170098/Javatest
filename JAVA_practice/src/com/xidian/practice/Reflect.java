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
		System.out.println("ͨ��������ƹ����������ʵ������ɹ�");
	}
	private Reflect(int i,int j){
	}
	public void f(int i){
		System.out.println("������f���� i = "+i);
	}
	public String g(char c){
		return "";
	}
	private int k(){
		System.out.println("����privateȨ�޵ķ����ɹ�");
		return 999;
	}
	public  static void main(String[] args) throws ClassNotFoundException{
		Class c = Class.forName("com.xidian.practice.Reflect");
		Method[] methods = c.getMethods();
		Constructor[] ctors = c.getConstructors();//���ص���publicȨ�޵Ĺ�����
		System.out.println("1. ���������е�����public����");
		for(Method m : methods){
			System.out.println(m.toString());
		}
		
		System.out.println("**********************************************************************");
		System.out.println("2. ���������е�����public������������");
		for(Constructor con : ctors){
			System.out.println(con.toString());
		}			
		System.out.println("**********************************************************************");
		System.out.println("3. ���ݷ�����Ƶ��÷�Ĭ�Ϲ���������ʵ������");
		Constructor constructor = ctors[0];
		Reflect r = null;
		try {
			r = (Reflect) constructor.newInstance(3);			
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		System.out.println("**********************************************************************");
		System.out.println("4. Ӧ�÷�����Ƶ��÷���");
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
		System.out.println("5. Ӧ�÷������Ҳ���Ե������е�ָ���ķ���������ʹ��private����Ȩ�޵�");
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
		
		System.out.println("6. ����һ������ĳЩ Field ��������飬��Щ����ӳ�� Class ��������ʾ�����ӿڵ����пɷ��ʹ����ֶ�()Ҳ�������̳��Ը���Ŀ��õĿɷ��ʵĹ����ֶ�");
		Field[] fs = c.getFields();
		for(Field f:fs){
			System.out.println(f);
		}
		System.out.println("**********************************************************************");
		System.out.println("7. ���ʶ����з�publicȨ�޵ĳ�Ա����");
		try {
			Field f = c.getDeclaredField("str");
			f.setAccessible(true);
			System.out.println(f.get(r));
		} catch (NoSuchFieldException | SecurityException  | IllegalAccessException e) {
			e.printStackTrace();
		}	
	}
}
