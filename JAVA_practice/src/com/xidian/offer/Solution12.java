package com.xidian.offer;
import com.xidian.struct.ListNode;

/*
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 住：主要是要考虑边界条件
 */

public class Solution12 {
	
	 public ListNode FindKthToTail(ListNode head,int k) {
		ListNode listNode = head;
		int count = 0;
		if(head == null) {
			return null;
		}
		while(listNode.next != null) {
			listNode = listNode.next;
			count++;	
		}
		if(k>count)
			return null;
		listNode = head;
		for (int i = 0 ;i<count-k+1;i++) {
			listNode = listNode.next;
		}
		return listNode;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
