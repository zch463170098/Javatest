package com.xidian.offer;

import java.util.Stack;
/*

思路：用一个栈data保存数据，用另外一个栈min保存依次入栈最小的数
比如，data中依次入栈，5,  4,  3, 8, 10, 11, 12, 1
       则min依次入栈，5,  4,  3，no,no, no, no, 1
 */

public class Solution18 {
	
	Stack<Integer> data = new Stack<>();
	Stack<Integer> min = new Stack<>();
	Integer temp = null;
    public void push(int node) {
        if(temp != null) {
        	if(node <= temp) {
        		temp = node;
        		min.push(node);
        	}
        	data.push(node);
        }else {
        	temp = node;
        	data.push(node);
        	min.push(node);
        }
    }
    
    public void pop() {
        int num = data.pop();
        int num2 = min.pop();
        if(num != num2) {
        	min.push(num2);
        }
    }
    
    public int top() {
        int num = data.pop();
        data.push(num);
        return num;
    }
    
    public int min() {
    	int m = min.pop();
    	min.push(m);
    	return m;
    }
    

}
