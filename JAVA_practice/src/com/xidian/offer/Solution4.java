package com.xidian.offer;

import com.xidian.struct.TreeNode;

public class Solution4 {
	/**
	 * �ȸ���ǰ��������еĵ�һ�����ִ������ڵ㣬����������������������ҵ����ڵ��λ�ã�
	 * ��������ȷ�����������ڵ����������ǰ���������������������л������������ڵ��ֵ֮��
	 * �ݹ鹹��������������
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

