package com.xidian.offer;

/**
 * @author Zhang Chenghui
 * E-mail: 463170098@qq.com
 * @version 1.0 
 * 创建时间：2017年10月14日 下午12:31:12
 * 说明：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 思路：一次进栈出栈操作，后进先出，再一次进栈出栈，就又改为先进先出
 */
/**
 * 拓展：两个队列实现一个栈，每一次都入队到一个对列中，需要出栈操作时
 * 删除队列中其他元素到队列2，然后删除队列中最后一个元素，相当于出栈操作，
 * 如此反复
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
		//只要栈2是空的，就要把栈一中的元素全部放入栈2中，确保顺序不会打乱
		if(stack2.isEmpty()){
		    while(!stack1.empty()){
			    stack2.push(stack1.pop());
		    }
		}
		return stack2.pop();
	}
}

