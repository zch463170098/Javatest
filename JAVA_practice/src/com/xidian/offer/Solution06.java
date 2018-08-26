package com.xidian.offer;

import com.xidian.struct.TreeNode;
/**
 * 
 * @author Administrator
 *输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 *假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *例如输入前序遍历序列{1,2,4,7,3,5,6,8}和
 *中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 *注：两种带中序的遍历方式可以确定一个树结构
 */


public class Solution06{
	/**
	 * 先根据前序遍历序列的第一个数字创建根节点，接下来在中序遍历序列中找到根节点的位置，
	 * 这样就能确定左右子数节点的数量。在前序遍历和中序遍历的序列中划分左右子树节点的值之后，
	 * 递归构建它的左右子树
	 * @param pre
	 * @param in
	 * @return
	 */
	public TreeNode reConstructBinaryTree(int[] pre,int[] in ){
		TreeNode root = reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
		return root;
	}
	
	private TreeNode reConstructBinaryTree(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn){
		if(startPre>endPre||startIn>endIn){
			return null;
		}
		TreeNode root = new TreeNode(pre[startPre]);  //根节点就是先序遍历的第一个节点
		for(int i=startIn;i<=endIn;i++){
			if(in[i]==pre[startPre]){  //中序遍历的根节点之前的就是左子树，后面的就是右子树，然后循环递归
				//此时的i-starIn也代表了左子树的长度
				root.left = reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
				root.right = reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
				//注意下标含义的深刻理解与灵活运用		
			}
		}

		return root;
	}
}

