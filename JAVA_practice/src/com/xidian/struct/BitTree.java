package com.xidian.struct;

import java.util.LinkedList;

public class BitTree {
	
	
	/**
	 * 构建二叉树
	 * @param nodes 数据源，数组
	 * @return 返回一个二叉链表
	 */
	public static LinkedList<TreeNode>  creatTree(int [] nodes){
		 LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>() ;
		// 将一个数组的值依次转换为Node节点  
       for (int nodeIndex = 0; nodeIndex < nodes.length; nodeIndex++) {  
           nodeList.add(new TreeNode(nodes[nodeIndex]));  
       }  
       
		// 对前n-1个父节点按照父节点与子节点的关系建立二叉树
		for(int i =0;i<nodes.length/2-1;i++) {
			nodeList.get(i).left = nodeList.get(2*i+1);
			nodeList.get(i).right = nodeList.get(2*i+2);
		}
		//最后一个父节点单独处理，（因为有可能不存在右孩子）
		int lastParentIndex = nodes.length/2 -1;
		//左孩子
		nodeList.get(lastParentIndex).left =nodeList.get(lastParentIndex*2+1); 
		//右孩子,如果为奇数，才建立右孩子
		if(nodes.length%2 == 1) {
			nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex*2+2);
		}
		return nodeList;
	}
	/**
	 * 先序遍历二叉树
	 * @param root
	 */
	public static void preOrderTraverse(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.print(root.val+" ");
		preOrderTraverse(root.left);
		preOrderTraverse(root.right);
	}
	/**
	 * 中序遍历二叉树
	 * @param root
	 */
    public static void inOrderTraverse(TreeNode root) {
    	if(root == null) {
    		return;
    	}
    	inOrderTraverse(root.left);
    	System.out.print(root.val+" ");
    	inOrderTraverse(root.right);
    }
 
    /**
     * 后序遍历
     * @param root
     */
     public static void postOrderTraverse(TreeNode root) {
    	 
    	 if(root == null ) { //如果不加这句，就会出现空指针异常
    		 return;
    	 }
    	 postOrderTraverse(root.left);
    	 postOrderTraverse(root.right);
    	 System.out.print(root.val+" ");
     }
     /**
      * main 函数测试运行
      * @param args
      */
	 public static void main (String [] args) {
		 int [] nodes = {10,5,12,4,7};
		 LinkedList<TreeNode> nodeList = BitTree.creatTree(nodes);
		 System.out.println("先序遍历:");
		 preOrderTraverse(nodeList.get(0));
		 System.out.println();
		 System.out.println("中序遍历:");
		 inOrderTraverse(nodeList.get(0));
		 System.out.println();
		 System.out.println("后序遍历:");
		 postOrderTraverse(nodeList.get(0));
		 
	 }

}
