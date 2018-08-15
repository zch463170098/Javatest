package com.xidian.offer;

import java.util.ArrayList;
import com.xidian.struct.*;
import java.util.Queue;

/*
 * 从上往下打印出二叉树的每个节点，
 * 同层节点从左至右打印
 * 
 * 思路 ：借助队列
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
        	list.add(temp.val);  //不要把这句忘了
        }
    	return list; 
        
    }

}
