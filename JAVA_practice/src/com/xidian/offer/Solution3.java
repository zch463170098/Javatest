package com.xidian.offer;

/**
 * @author Zhang Chenghui
 * E-mail: 463170098@qq.com
 * @version 1.0 
 * 创建时间：2017年10月12日 下午9:43:21
 * 说明：输入一个链表，从尾到头打印链表每个节点的值。
 */

import com.xidian.offer.ListNode;
import java.util.ArrayList;
import java.util.Stack;
public class Solution3 {

	ArrayList<Integer> arrayList = new ArrayList<Integer>();
	/**
	 * 递归实现,其实递归的本质还是栈
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

