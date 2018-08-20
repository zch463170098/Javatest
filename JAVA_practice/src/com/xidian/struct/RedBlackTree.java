package com.xidian.struct;

/*
 1��ÿ����㶼ֻ���Ǻ�ɫ���ߺ�ɫ�е�һ�֡� 
2��������Ǻ�ɫ�ġ� 
3��ÿ��Ҷ��㣨NIL�ڵ㣬�սڵ㣩�Ǻ�ɫ�ġ� 
4�����һ������Ǻ�ģ����������ӽڵ㶼�Ǻڵġ�Ҳ����˵��һ��·���ϲ��ܳ������ڵ�������ɫ��㡣 
5������һ��㵽��ÿ��Ҷ�ӵ�����·����������ͬ��Ŀ�ĺ�ɫ��㡣
 */



public class RedBlackTree {
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private Node root;//����������ĸ��ڵ�

	//������ݽṹ
	private class Node{
	    private Key key;//��
	    private Value value;//ֵ
	    private Node left, right;//ָ������������:��������������.
	    private int N;//�Ըýڵ�Ϊ���������еĽ������
	    boolean color;//���丸���ָ���������ӵ���ɫҲ���ǽ����ɫ.

	    public Node(Key key, Value value, int N, boolean color) {
	        this.key = key;
	        this.value = value;
	        this.N = N;
	        this.color = color;
	    }
	}

	/**
	 * ��ȡ��������������Ĵ�С
	 * @return
	 */
	public int size(){
	    return size(root);
	}
	/**
	 * ��ȡĳһ�����Ϊ�����Ķ���������Ĵ�С
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
	 * ����ת
	 * @param h
	 * @return
	 */
	private Node rotateLeft(Node h){
	    Node x = h.right;
	    //��x�����㸳ֵ��h���ҽ��
	    h.right = x.left;
	    //��h��ֵ��x������
	    x.left = h;
	    //
	    x.color = h.color;
	    h.color = RED;
	    x.N = h.N;
	    h.N = 1+ size(h.left) + size(h.right);

	    return x;
	}
	
	
	/**
	 * ����ת
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
	 * ��ɫת��
	 * @param h
	 */
	private void flipColors(Node h){
	    h.color = RED;//�������ɫ���
	    h.left.color = BLACK;//�ӽ����ɫ���
	    h.right.color = BLACK;//�ӽ����ɫ���
	}
	


}
