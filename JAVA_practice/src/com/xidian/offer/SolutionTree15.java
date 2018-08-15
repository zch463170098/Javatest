package com.xidian.offer;

import com.xidian.struct.*;
import com.xidian.struct.TreeNode;

/**
 * 
 * @author Administrator
 *
 */

 /*
  * 输入两棵二叉树A，B，判断B是不是A的子结构。
  * （ps：我们约定空树不是任意一个树的子结构）
  * 
  */
public class SolutionTree15 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
    	boolean result = false;
    	
    	if(root2 == null ) {
    		return result;
    	}
    	
    	if(root1 == null ) {
    		return result;
    	}
    	if(root1.val == root2.val) {
    		result = doesTree1HaveTree2(root1, root2);
    	}
    	if(!result) {
    		result = doesTree1HaveTree2(root1.left, root2);
    	}
    	if(!result) {
    		result = doesTree1HaveTree2(root1.right, root2);
    	}
       return result; 
    }
    
    public static boolean doesTree1HaveTree2(TreeNode node1,TreeNode node2){
    	if(node2 == null ) {
    		return true;
    	}
    	if(node1 == null) {
    		return false;
    	}
    	if(node1.val != node2.val) {
    		return false;
    	}
    	return doesTree1HaveTree2(node1.left, node2.left)&&doesTree1HaveTree2(node1.right, node2.right);
    }
    
}
