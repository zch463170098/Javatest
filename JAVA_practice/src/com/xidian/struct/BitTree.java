package com.xidian.struct;

import java.util.LinkedList;

public class BitTree {
	
	
	/**
	 * ����������
	 * @param nodes ����Դ������
	 * @return ����һ����������
	 */
	public static LinkedList<TreeNode>  creatTree(int [] nodes){
		 LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>() ;
		// ��һ�������ֵ����ת��ΪNode�ڵ�  
       for (int nodeIndex = 0; nodeIndex < nodes.length; nodeIndex++) {  
           nodeList.add(new TreeNode(nodes[nodeIndex]));  
       }  
       
		// ��ǰn-1�����ڵ㰴�ո��ڵ����ӽڵ�Ĺ�ϵ����������
		for(int i =0;i<nodes.length/2-1;i++) {
			nodeList.get(i).left = nodeList.get(2*i+1);
			nodeList.get(i).right = nodeList.get(2*i+2);
		}
		//���һ�����ڵ㵥����������Ϊ�п��ܲ������Һ��ӣ�
		int lastParentIndex = nodes.length/2 -1;
		//����
		nodeList.get(lastParentIndex).left =nodeList.get(lastParentIndex*2+1); 
		//�Һ���,���Ϊ�������Ž����Һ���
		if(nodes.length%2 == 1) {
			nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex*2+2);
		}
		return nodeList;
	}
	/**
	 * �������������
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
	 * �������������
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
     * �������
     * @param root
     */
     public static void postOrderTraverse(TreeNode root) {
    	 
    	 if(root == null ) { //���������䣬�ͻ���ֿ�ָ���쳣
    		 return;
    	 }
    	 postOrderTraverse(root.left);
    	 postOrderTraverse(root.right);
    	 System.out.print(root.val+" ");
     }
     /**
      * main ������������
      * @param args
      */
	 public static void main (String [] args) {
		 int [] nodes = {10,5,12,4,7};
		 LinkedList<TreeNode> nodeList = BitTree.creatTree(nodes);
		 System.out.println("�������:");
		 preOrderTraverse(nodeList.get(0));
		 System.out.println();
		 System.out.println("�������:");
		 inOrderTraverse(nodeList.get(0));
		 System.out.println();
		 System.out.println("�������:");
		 postOrderTraverse(nodeList.get(0));
		 
	 }

}
