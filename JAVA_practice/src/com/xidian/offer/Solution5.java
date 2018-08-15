package com.xidian.offer;

/**
 * @author Zhang Chenghui
 * E-mail: 463170098@qq.com
 * @version 1.0 
 * ����ʱ�䣺2017��10��14�� ����12:31:12
 * ˵����������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 * ˼·��һ�ν�ջ��ջ����������ȳ�����һ�ν�ջ��ջ�����ָ�Ϊ�Ƚ��ȳ�
 */
import java.util.Stack;
public class Solution5 {

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	

	
	public  void push(int node){
		stack1.push(node);
	}
	
	public int pop(){
		if(stack1.empty()&&stack2.empty()){
			throw new  RuntimeException("Queue is empty");
		}
		if(stack2.isEmpty()){
		    while(!stack1.empty()){
			    stack2.push(stack1.pop());
		    }
		}
		return stack2.pop();
	}
}

