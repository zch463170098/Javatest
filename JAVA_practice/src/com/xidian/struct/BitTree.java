package com.xidian.struct;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


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
	 * 非递归实现-先序遍历
	 * @param root
	 * 思路：创建空栈，先把根节点压栈，然后抛栈打印当前节点，
	 * 如果当前节点的右孩子不为空，则压栈，左孩子不为空则压栈，
	 * while循环以上步骤，直到栈为空（
	 *因为栈是后进先出，所以先压右孩子，再压左孩子实现左孩子先出栈）
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
     * 中序遍历-非递归实现
     * @param root
     * 思路：一直向左遍历走到头，然后出栈，
     * 然后有节点添加进栈
     * 栈顶指针为空来表示走到尽头
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
    	    stack.pop();  //弹出空指针
    	    if(!stack.isEmpty()) {
    	    	System.out.print(stack.peek().val+" ");
    	    	stack.push(stack.pop().right);
    	    }
    	}
    		
    	
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
      * main 函数测试运行
      * @param args
      */
	 public static void main (String [] args) {
		 int [] nodes = {10,5,12,4,7};
		 LinkedList<TreeNode> nodeList = BitTree.creatTree(nodes);
		 System.out.println("先序遍历:");
		 preOrderTraverse(nodeList.get(0));
		 System.out.println("\n先序的非递归算法");
		 preOrdertraverse_noRecursion(nodeList.getFirst());
		 System.out.println();
		 System.out.println("中序遍历:");
		 inOrderTraverse(nodeList.get(0));
		 System.out.println("\n中序非递归");
		 inOrderTraverse_noRecurison(nodeList.get(0));
		 System.out.println();
		 System.out.println("后序遍历:");
		 postOrderTraverse(nodeList.get(0));
		 System.out.println("\n后续非递归");
		 postOrder(nodeList.getFirst());
		 System.out.println("\n层序遍历");
		 gradationTraverse(nodeList.getFirst());
	 }
	

}
