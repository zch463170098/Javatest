package com.xidian.offer;
import com.xidian.struct.ListNode;
/**
 * 
 * @author Administrator
 *
 */
/*
 * 输入一个链表，反转链表后，输出新链表的表头
 * 注：依然是需要考虑边界条件
 */
public class Solution13 {
	 public ListNode ReverseList(ListNode head) {
		 	int[] a = new int[100];
		 	ListNode l = head;
		 	int i =0;
		 	if(l == null)
		 		return null;
		 	while(l.next!=null) {
		 		a[i] = l.val;
		 		i++;
		 		l =l.next;
		 	}
		 	a[i] = l.val;
		 	int length = a.length;
		 	l =head;
		 	while(l.next!= null) {
		 		l.val = a[i];
		 		i--;
		 		l = l.next;
		 	}
		 	l.val = a[0];
		 	return head;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
