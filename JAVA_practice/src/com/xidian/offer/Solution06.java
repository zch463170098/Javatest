package com.xidian.offer;

import com.xidian.struct.TreeNode;
/**
 * 
 * @author Administrator
 *����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
 *���������ǰ���������������Ľ���ж������ظ������֡�
 *��������ǰ���������{1,2,4,7,3,5,6,8}��
 *�����������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 *
 *ע�����ִ�����ı�����ʽ����ȷ��һ�����ṹ
 */


public class Solution06{
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
		TreeNode root = new TreeNode(pre[startPre]);  //���ڵ������������ĵ�һ���ڵ�
		for(int i=startIn;i<=endIn;i++){
			if(in[i]==pre[startPre]){  //��������ĸ��ڵ�֮ǰ�ľ���������������ľ�����������Ȼ��ѭ���ݹ�
				//��ʱ��i-starInҲ�������������ĳ���
				root.left = reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
				root.right = reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
				//ע���±꺬������������������		
			}
		}

		return root;
	}
}

