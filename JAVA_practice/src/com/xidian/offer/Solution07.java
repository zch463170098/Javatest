package com.xidian.offer;

/**
 * @author Zhang Chenghui
 * E-mail: 463170098@qq.com
 * @version 1.0 
 * ����ʱ�䣺2017��10��14�� ����12:31:12
 * ˵����������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 * ˼·��һ�ν�ջ��ջ����������ȳ�����һ�ν�ջ��ջ�����ָ�Ϊ�Ƚ��ȳ�
 */
/**
 * ��չ����������ʵ��һ��ջ��ÿһ�ζ���ӵ�һ�������У���Ҫ��ջ����ʱ
 * ɾ������������Ԫ�ص�����2��Ȼ��ɾ�����������һ��Ԫ�أ��൱�ڳ�ջ������
 * ��˷���
 * 
 */
import java.util.Stack;
public class Solution07 {

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	

	
	public  void push(int node){
		stack1.push(node);
	}
	
	public int pop(){
		if(stack1.empty()&&stack2.empty()){
			throw new  RuntimeException("Queue is empty");
		}
		//ֻҪջ2�ǿյģ���Ҫ��ջһ�е�Ԫ��ȫ������ջ2�У�ȷ��˳�򲻻����
		if(stack2.isEmpty()){
		    while(!stack1.empty()){
			    stack2.push(stack1.pop());
		    }
		}
		return stack2.pop();
	}
}

