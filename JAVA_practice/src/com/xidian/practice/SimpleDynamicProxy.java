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

	private Object proxied;//真实的被代理的实例
	public DynamicProxyHander(Object proxied){
		this.proxied = proxied;
	}
	
	/**
	 * 在代理实例上处理方法调用并返回结果。
	 * 在与方法关联的代理实例上调用方法时，将在调用处理程序上调用此方法。 
	 * obj - 在其上调用方法的代理实例.
	 * method - 对应于在代理实例上调用的接口方法的 Method 实例(指代的是我们所要调用真实对象的某个方法的Method对象)。
	 * Method 对象的声明类将是在其中声明方法的接口，该接口可以是代理类赖以继承方法的代理接口的超接口。
     * args - 包含传入代理实例上方法调用的参数值的对象数组(指代的是调用真实对象某个方法时接受的参数)，如果接口方法不使用参数，则为 null
     * 。基本类型的参数被包装在适当基本包装器类（如 java.lang.Integer 或 java.lang.Boolean）的实例中。 
	 */
	@Override
	public Object invoke(Object obj, Method method, Object[] args)
			throws Throwable {
		System.out.println();
		System.out.println("代理调用实际的方法前，可以添加一些额外的工作操作比如下面的打印一些信息~~~");		
		System.out.println("******** obj: "+obj.getClass() +", method: "+method+", args: "+args);
		if(args!=null){
			for(Object arg : args){
				System.out.println(" "+arg);
			}
		}
		method.invoke(proxied, args);//把请求分发给真正代理的对象。
		System.out.println("代理调用实际的方法后~~~");
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
		 * Proxy.newProxyInstance创建动态代理，
		 * 需要三个参数，Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
		 * 一个是类加载器ClassLoader loader:一个ClassLoader对象，
		 * 定义了由哪个ClassLoader对象来对生成的代理对象进行加载.
		 * 一个是该代理实现的接口列表（不是类或抽象类）Class<?>[] interfaces:
		 * 一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，
		 * 如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了.
		 * 一个是InvocationHandler接口的一个实现:一个InvocationHandler对象，
		 * 表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上.
		 * 
		 * 下面的这行代码表示的是动态代理RealObject的一个实例对象real，
		 * 指定由Interface.class的类加载器加载这个代理的对象，该对象实现了Interface接口。
		 * 注意在这里Interface只是我声明的一个接口。
		 * 
		 * 当我们通过代理对象调用一个方法的时候，这个方法的调用就会被转发为由InvocationHandler这个接口的 invoke方法来进行调用.
		 */
		Interface proxy = (Interface) Proxy.newProxyInstance(
				Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHander(real));	
		consumer(proxy);	
System.out.println(proxy.getClass().getName());	
	}
}

