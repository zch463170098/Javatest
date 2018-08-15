package com.xidian.offer;
import org.w3c.dom.ls.LSException;

import com.xidian.struct.ListNode;

/*
 * ���������������������������������ϳɺ������
 * ��Ȼ������Ҫ�ϳɺ���������㵥����������
 * 
 */

public class Solution14 {

    public static ListNode Merge(ListNode list1,ListNode list2) {
    	if((list1==null)&&(list2==null)) {
    		return null;
    	}
    	// ����������⣬��Ҫ����list1 ��list2 �ֱ�Ϊ�յ����
    	if(list1 == null) {
    		return list2;
    	}
    	
    	if(list2 ==null ) {
    		return list1;
    	}
        ListNode list3 = null ;
        ListNode head =null;
        while((list1!=null)&&(list2!=null)) {
        	if(list1.val<=list2.val) {
        		if(head == null) {
        			head = new ListNode(list1.val);
        			list3 = head;
        			list1 = list1.next;
        		}else {
        			list3.next = new ListNode(list1.val);
        			list3 = list3.next;
        			list1 = list1.next;
        		}
        	}else {
        		if(head == null) {
        			head = new ListNode(list2.val);
        			list3 = head;
        		    list2 = list2.next;
        		}else {
        			list3.next = new ListNode(list2.val);
        			list3 = list3.next;
        			list2 = list2.next;
        		}
        		
        	}
        }
        
        if(list1 == null) {
        	list3.next = list2;
        }else {
        	list3.next = list1;
        }
        return head;
    }
    
    public static ListNode creatListNode(int[] array) {
    	ListNode head =null;
    	ListNode l =null;
    	for(int i=0;i<array.length;i++) {
    		if(head == null) {
    			head = new ListNode(array[i]);
    			l =head;
    		}else {
    			l.next = new ListNode(array[i]);
    			l =l.next;
    		}
    	}
    	l = head;
		while(l!=null) {
			System.out.println(l.val);
			l = l.next;
		}
    	return head;
    }
   /**
    * ����������
    * @param args
    */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int a[] = {1,3,5};
        int b[] = {2,4,6};
        ListNode list1 = null;
        ListNode list2 = null;
        ListNode list3 =null;
        //��������
        list1 = creatListNode(a);
//    	while(list1!=null) {
//			System.out.println(list1.val);
//			list1 = list1.next;
//		}
        list2 = creatListNode(b);
//    	while(list2!=null) {
//			System.out.println(list2.val);
//			list2 = list2.next;
//		}
//    	System.out.println("begin");
        list3 = Merge(list1,list2);
        System.out.println("end");
    	while(list3!=null) {
			System.out.println(list3.val);
			list3 = list3.next;
		}
	}

}
