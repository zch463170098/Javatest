package com.xidian.offer;

/*
 * ���������������У���һ�����б�ʾջ��ѹ��˳��
 * �����жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ���������־�����ȡ�
 * ��������1,2,3,4,5��ĳջ��ѹ��˳��
 * ����4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С�
 * ��ע�⣺���������еĳ�������ȵģ�
 */

import java.util.ArrayList;
import java.util.Stack;
public class SolutionStack19 {
	
	public static  boolean IspopOrder(int [] pushA, int [] popA) {
		Stack<Integer> stack = new Stack<>();
		if(pushA.length!=popA.length) {
			return false;
		}
		if(pushA.length == 0 || popA.length == 0) {
			return false;
		}
		int popIndex = 0;
		for(int i =0;i<pushA.length;i++) {
			stack.push(pushA[i]);
			while(!stack.isEmpty()&&stack.peek() == popA[popIndex]) {
				stack.pop();
				popIndex++;
			}
		}
		return stack.empty();
	}

	public static void main(String [] args) {
		int[] pushA = {1,2,3,4,5};
		int[] popA = {4,5,3,2,1};
		System.out.println(IspopOrder(pushA,popA));
		
		
	}
}
