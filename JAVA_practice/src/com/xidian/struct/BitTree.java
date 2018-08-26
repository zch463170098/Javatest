package com.xidian.struct;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


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
	 * �ǵݹ�ʵ��-�������
	 * @param root
	 * ˼·��������ջ���ȰѸ��ڵ�ѹջ��Ȼ����ջ��ӡ��ǰ�ڵ㣬
	 * �����ǰ�ڵ���Һ��Ӳ�Ϊ�գ���ѹջ�����Ӳ�Ϊ����ѹջ��
	 * whileѭ�����ϲ��裬ֱ��ջΪ�գ�
	 *��Ϊջ�Ǻ���ȳ���������ѹ�Һ��ӣ���ѹ����ʵ�������ȳ�ջ��
	 */
	public static void preOrdertraverse_noRecursion(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		if(root!=null) {
			stack.push(root);
		}
		while(!stack.isEmpty()) {
			TreeNode currNode = stack.pop();
			System.out.print(currNode.val+" ");
			if(currNode.right!=null) {
				stack.push(currNode.right);
			}
			if(currNode.left!=null) {
				stack.push(currNode.left);
			}
			
		}
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
     * �������-�ǵݹ�ʵ��
     * @param root
     * ˼·��һֱ��������ߵ�ͷ��Ȼ���ջ��
     * Ȼ���нڵ���ӽ�ջ
     * ջ��ָ��Ϊ������ʾ�ߵ���ͷ
     */
    public static void inOrderTraverse_noRecurison(TreeNode root) {
    	if(root == null) {
    		return;
    	}
    	Stack<TreeNode> stack = new Stack<>();
    	stack.push(root);
    	while(!stack.isEmpty()) {
    	    while( stack.peek()!=null) {
    	    	stack.push(stack.peek().left);
    	    }
    	    stack.pop();  //������ָ��
    	    if(!stack.isEmpty()) {
    	    	System.out.print(stack.peek().val+" ");
    	    	stack.push(stack.pop().right);
    	    }
    	}
    		
    	
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
     
     public static void postOrder(TreeNode root) {
    	 
    	 Stack<TreeNode> stack = new Stack<>();
    	 stack.push(root);
    	 TreeNode pre = null;
    	 TreeNode cur;
    	 while(!stack.isEmpty()) {
    		 cur = stack.peek();
    		 if((cur.left==null&&cur.right==null)
    				 ||((pre!=null)&&(pre==cur.left||pre==cur.right))) {
    			 stack.pop();
    			 System.out.print(cur.val+" ");
    			 pre = cur;
    		 }else {
    			 if(cur.right!=null) {
    				 stack.push(cur.right);
    			 }
    			 if(cur.left!=null) {
    				 stack.push(cur.left);
    			 }
    		 }
    	 }
     }
     
     public static void gradationTraverse(TreeNode root) {
    	 LinkedList<TreeNode> queue = new LinkedList<>();
    	 queue.add(root);
    	 TreeNode cur;
    	 while(!queue.isEmpty()) {
    		 cur = queue.remove();
    		 System.out.print(cur.val+" ");
    		 if(cur.left!=null) {
    			 queue.add(cur.left);
    		 }
    		 if(cur.right!=null) {
    			 queue.add(cur.right);
    		 }
    	 }
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
		 System.out.println("\n����ķǵݹ��㷨");
		 preOrdertraverse_noRecursion(nodeList.getFirst());
		 System.out.println();
		 System.out.println("�������:");
		 inOrderTraverse(nodeList.get(0));
		 System.out.println("\n����ǵݹ�");
		 inOrderTraverse_noRecurison(nodeList.get(0));
		 System.out.println();
		 System.out.println("�������:");
		 postOrderTraverse(nodeList.get(0));
		 System.out.println("\n�����ǵݹ�");
		 postOrder(nodeList.getFirst());
		 System.out.println("\n�������");
		 gradationTraverse(nodeList.getFirst());
	 }
	

}
