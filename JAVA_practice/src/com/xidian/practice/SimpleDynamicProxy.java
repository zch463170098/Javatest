package com.xidian.practice;

import com.xidian.practice.Interface;

import java.lang.reflect.*;


class RealObject implements Interface{

	@Override
	public void doSomething() {
		System.out.println("doSomething");
	}

	@Override
	public void doSomethingElse(String args) {
		System.out.println("doSomethingElse "+args);
	}
	
}

class DynamicProxyHander implements InvocationHandler{

	private Object proxied;//��ʵ�ı������ʵ��
	public DynamicProxyHander(Object proxied){
		this.proxied = proxied;
	}
	
	/**
	 * �ڴ���ʵ���ϴ��������ò����ؽ����
	 * ���뷽�������Ĵ���ʵ���ϵ��÷���ʱ�����ڵ��ô�������ϵ��ô˷����� 
	 * obj - �����ϵ��÷����Ĵ���ʵ��.
	 * method - ��Ӧ���ڴ���ʵ���ϵ��õĽӿڷ����� Method ʵ��(ָ������������Ҫ������ʵ�����ĳ��������Method����)��
	 * Method ����������ཫ�����������������Ľӿڣ��ýӿڿ����Ǵ��������Լ̳з����Ĵ���ӿڵĳ��ӿڡ�
     * args - �����������ʵ���Ϸ������õĲ���ֵ�Ķ�������(ָ�����ǵ�����ʵ����ĳ������ʱ���ܵĲ���)������ӿڷ�����ʹ�ò�������Ϊ null
     * ���������͵Ĳ�������װ���ʵ�������װ���ࣨ�� java.lang.Integer �� java.lang.Boolean����ʵ���С� 
	 */
	@Override
	public Object invoke(Object obj, Method method, Object[] args)
			throws Throwable {
		System.out.println();
		System.out.println("�������ʵ�ʵķ���ǰ���������һЩ����Ĺ���������������Ĵ�ӡһЩ��Ϣ~~~");		
		System.out.println("******** obj: "+obj.getClass() +", method: "+method+", args: "+args);
		if(args!=null){
			for(Object arg : args){
				System.out.println(" "+arg);
			}
		}
		method.invoke(proxied, args);//������ַ�����������Ķ���
		System.out.println("�������ʵ�ʵķ�����~~~");
		return null;
	}	
}

public class SimpleDynamicProxy {	
	public static void consumer(Interface iface){
		iface.doSomething();
		iface.doSomethingElse("zzzkkk");
		System.out.println("hello world");
	}	
	public static void main(String[] args){
		RealObject real = new RealObject();
		consumer(real);		
		/*	
		 * Proxy.newProxyInstance������̬����
		 * ��Ҫ����������Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
		 * һ�����������ClassLoader loader:һ��ClassLoader����
		 * ���������ĸ�ClassLoader�����������ɵĴ��������м���.
		 * һ���Ǹô���ʵ�ֵĽӿ��б������������ࣩClass<?>[] interfaces:
		 * һ��Interface��������飬��ʾ�����ҽ�Ҫ������Ҫ����Ķ����ṩһ��ʲô�ӿڣ�
		 * ������ṩ��һ��ӿڸ�������ô���������������ʵ���˸ýӿ�(��̬)�������Ҿ��ܵ�������ӿ��еķ�����.
		 * һ����InvocationHandler�ӿڵ�һ��ʵ��:һ��InvocationHandler����
		 * ��ʾ���ǵ��������̬��������ڵ��÷�����ʱ�򣬻��������һ��InvocationHandler������.
		 * 
		 * ��������д����ʾ���Ƕ�̬����RealObject��һ��ʵ������real��
		 * ָ����Interface.class��������������������Ķ��󣬸ö���ʵ����Interface�ӿڡ�
		 * ע��������Interfaceֻ����������һ���ӿڡ�
		 * 
		 * ������ͨ������������һ��������ʱ����������ĵ��þͻᱻת��Ϊ��InvocationHandler����ӿڵ� invoke���������е���.
		 */
		Interface proxy = (Interface) Proxy.newProxyInstance(
				Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHander(real));	
		consumer(proxy);	
System.out.println(proxy.getClass().getName());	
	}
}

