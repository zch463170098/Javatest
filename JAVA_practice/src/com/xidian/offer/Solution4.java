package com.xidian.offer;

import com.xidian.struct.TreeNode;

public class Solution4 {
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
		TreeNode root = new TreeNode(pre[startPre]);
		for(int i=startIn;i<=endIn;i++){
			if(in[i]==pre[startPre]){
				root.left = reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
				root.right = reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
						
			}
		}

		return root;
	}
}

