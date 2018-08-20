package com.xidian.struct;

/*
 1、每个结点都只能是红色或者黑色中的一种。 
2、根结点是黑色的。 
3、每个叶结点（NIL节点，空节点）是黑色的。 
4、如果一个结点是红的，则它两个子节点都是黑的。也就是说在一条路径上不能出现相邻的两个红色结点。 
5、从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点。
 */



public class RedBlackTree {
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private Node root;//二叉查找树的根节点

	//结点数据结构
	private class Node{
	    private Key key;//键
	    private Value value;//值
	    private Node left, right;//指向子树的链接:左子树和右子树.
	    private int N;//以该节点为根的子树中的结点总数
	    boolean color;//由其父结点指向它的链接的颜色也就是结点颜色.

	    public Node(Key key, Value value, int N, boolean color) {
	        this.key = key;
	        this.value = value;
	        this.N = N;
	        this.color = color;
	    }
	}

	/**
	 * 获取整个二叉查找树的大小
	 * @return
	 */
	public int size(){
	    return size(root);
	}
	/**
	 * 获取某一个结点为根结点的二叉查找树的大小
	 * @param x
	 * @return
	 */
	private int size(Node x){
	    if(x == null){
	        return 0;
	    } else {
	        return x.N;
	    }
	}
	private boolean isRed(Node x){
	    if(x == null){
	        return false;
	    }
	    return x.color == RED;
	}
	
	/**
	 * 左旋转
	 * @param h
	 * @return
	 */
	private Node rotateLeft(Node h){
	    Node x = h.right;
	    //把x的左结点赋值给h的右结点
	    h.right = x.left;
	    //把h赋值给x的左结点
	    x.left = h;
	    //
	    x.color = h.color;
	    h.color = RED;
	    x.N = h.N;
	    h.N = 1+ size(h.left) + size(h.right);

	    return x;
	}
	
	
	/**
	 * 右旋转
	 * @param h
	 * @return
	 */
	private Node rotateRight(Node h){
	    Node x = h.left;
	    h.left = x.right;
	    x.right = h;

	    x.color = h.color;
	    h.color = RED;
	    x.N = h.N;
	    h.N = 1+ size(h.left) + size(h.right);
	    return x;
	}
	
	/**
	 * 颜色转换
	 * @param h
	 */
	private void flipColors(Node h){
	    h.color = RED;//父结点颜色变红
	    h.left.color = BLACK;//子结点颜色变黑
	    h.right.color = BLACK;//子结点颜色变黑
	}
	


}
