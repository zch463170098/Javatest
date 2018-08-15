package com.xidian.offer;

import java.util.ArrayList;
import com.xidian.struct.*;
import java.util.Queue;

/*
 * �������´�ӡ����������ÿ���ڵ㣬
 * ͬ��ڵ�������Ҵ�ӡ
 * 
 * ˼· ����������
 */

public class SolutionTree20 {
	
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        if(root ==null) {
        	return list;
        }
        queue.add(root);
        while(queue.size()!=0) {
        	TreeNode temp = queue.remove(0);
        	if(temp.left!=null) {
        		queue.add(temp.left);
        	}
        	if(temp.right!=null) {
        		queue.add(temp.right);
        	}
        	list.add(temp.val);  //��Ҫ���������
        }
    	return list; 
        
    }

}
