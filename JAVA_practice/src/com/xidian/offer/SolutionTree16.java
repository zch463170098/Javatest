package com.xidian.offer;
import com.xidian.struct.*;

/*
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 二叉树的镜像定义：源二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
 */

public class SolutionTree16 {

	public void Mirror(TreeNode root) {
		TreeNode temp ;
		if(root !=null) {
			temp = root.left;
			root.left = root.right;
			root.right = temp;
			if(root.left!=null) {
				Mirror(root.left);
			}
			if(root.right!=null) {
				Mirror(root.right);
			}
		}
		
	}
	
//	public static TreeNode switchNode(TreeNode root) {
//		TreeNode temp ;
//		if(root == null) {
//			return null;
//		}
//		if(root.left == null ) {
//			root.left = root.right;
//			return root;
//		}
//		
//		if(root.right == null ) {
//			root.right = root.left;
//			return root;
//		}
//		
//		temp = root.left;
//		root.left = root.right;
//		root.right = temp;
//		
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
