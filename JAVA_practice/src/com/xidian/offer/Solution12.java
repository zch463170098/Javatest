package com.xidian.offer;
import com.xidian.struct.ListNode;

/*
 * ����һ����������������е�����k����㡣
 * ס����Ҫ��Ҫ���Ǳ߽�����
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
