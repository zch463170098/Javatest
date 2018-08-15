package com.xidian.offer;

/**
 * @author Zhang Chenghui
 * E-mail: 463170098@qq.com
 * @version 1.0 
 * ����ʱ�䣺2017��10��12�� ����9:43:21
 * ˵��������һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ��
 */

import com.xidian.offer.ListNode;
import java.util.ArrayList;
import java.util.Stack;
public class Solution3 {

	ArrayList<Integer> arrayList = new ArrayList<Integer>();
	/**
	 * �ݹ�ʵ��,��ʵ�ݹ�ı��ʻ���ջ
	 * @param listNode
	 * @return
	 */
	public ArrayList<Integer> printListFromTailToHead1(ListNode listNode){
		if(listNode != null){
			this.printListFromTailToHead1(listNode.next);
			arrayList.add(listNode.val);
		}
		
		return arrayList;
		
	}
	
	public ArrayList<Integer> printListFromtailToHead2(ListNode listNode){
		Stack<Integer> stack = new Stack<Integer>();
		while(listNode!=null){
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
		while(!stack.isEmpty()){
			arrayList2.add(stack.pop());
		}
		return arrayList2;
		
	}
	
	
}

