package com.xidian.offer;

/**
 * @author Zhang Chenghui
 * E-mail: 463170098@qq.com
 * @version 1.0 
 * 创建时间：2017年10月14日 下午12:31:12
 * 说明：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 思路：一次进栈出栈操作，后进先出，再一次进栈出栈，就又改为先进先出
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

