package com.xidian.struct;

public class ThreadBinaryTree {
	
	private Node preNode;   //������ʱ��¼ǰһ���ڵ�

    //�ڵ�洢�ṹ
    static class Node {
        String data;        //������
        Node left;          //��ָ����
        Node right;         //��ָ����
        boolean isLeftThread = false;   //��ָ��������  false��ָ���ӽڵ㡢true��ǰ����������
        boolean isRightThread = false;  //��ָ��������  false��ָ���ӽڵ㡢true��ǰ����������

        Node(String data) {
            this.data = data;
        }
    }
    
    /**
     * ͨ�����鹹��һ������������ȫ��������
     * @param array
     * @param index
     * @return
     */
    static Node createBinaryTree(String[] array, int index) {
        Node node = null;

        if(index < array.length) {
            node = new Node(array[index]);
            node.left = createBinaryTree(array, index * 2 + 1);
            node.right = createBinaryTree(array, index * 2 + 2);
        }
        return node;
    }
    
    /**
     * ����������������
     * @param node  �ڵ�
     */
    void inThreadOrder(Node node) {
        if(node == null) {
            return;
        }

        //����������
        inThreadOrder(node.left);

        //��ָ��Ϊ��,����ָ��ָ��ǰ���ڵ�
        if(node.left == null) {
            node.left = preNode;
            node.isLeftThread = true;
        }

        //ǰһ���ڵ�ĺ�̽ڵ�ָ��ǰ�ڵ�
        if(preNode != null && preNode.right == null) {
            preNode.right = node;
            preNode.isRightThread = true;
        }
        preNode = node;

        //����������
        inThreadOrder(node.right);
    }
    
    /**
     * ����������������������պ�̷�ʽ������˼·���ҵ������ӽڵ㿪ʼ��
     * @param node
     */
    void inThreadList(Node node) {
        //1�������������ʽ��ʼ�Ľڵ�
        while(node != null && !node.isLeftThread) {
            node = node.left;
        }

        while(node != null) {
            System.out.print(node.data + ", ");

            //�����ָ��������
            if(node.isRightThread) {
                node = node.right;

            } else {    //�����ָ�벻���������ҵ���������ʼ�Ľڵ�
                node = node.right;
                while(node != null && !node.isLeftThread) {
                    node = node.left;
                }
            }
        }
    }

    /**
     * �����������������������ǰ����ʽ������˼·���ҵ������ӽڵ㿪ʼ���������
     * @param node
     */
    void inPreThreadList(Node node) {
        //1�������һ���ڵ�
        while(node.right != null && !node.isRightThread) {
            node = node.right;
        }

        while(node != null) {
            System.out.print(node.data + ", ");

            //�����ָ��������
            if(node.isLeftThread) {
                node = node.left;

            } else {    //�����ָ�벻���������ҵ���������ʼ�Ľڵ�
                node = node.left;
                while(node.right != null && !node.isRightThread) {
                    node = node.right;
                }
            }
        }
    }

    /**
     * ǰ��������������
     * @param node
     */
    void preThreadOrder(Node node) {
        if(node == null) {
            return;
        }

        //��ָ��Ϊ��,����ָ��ָ��ǰ���ڵ�
        if(node.left == null) {
            node.left = preNode;
            node.isLeftThread = true;
        }

        //ǰһ���ڵ�ĺ�̽ڵ�ָ��ǰ�ڵ�
        if(preNode != null && preNode.right == null) {
            preNode.right = node;
            preNode.isRightThread = true;
        }

        preNode = node;

        //����������
        if(!node.isLeftThread) {
            preThreadOrder(node.left);
        }

        //����������
        if(!node.isRightThread) {
            preThreadOrder(node.right);
        }
    }

    /**
     * ǰ��������������������պ������������
     * @param node
     */
    void preThreadList(Node node) {
        while(node != null) {

            while(!node.isLeftThread) {
                System.out.print(node.data + ", ");
                node = node.left;
            }

            System.out.print(node.data + ", ");
            node = node.right;
        }
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 String[] array = {"A", "B", "C", "D", "E", "F", "G", "H"};
	        Node root = createBinaryTree(array, 0);

	        ThreadBinaryTree tree = new ThreadBinaryTree();
	        tree.inThreadOrder(root);
	        System.out.println("���򰴺�̽ڵ�������������������");
	        tree.inThreadList(root);
	        System.out.println("\n���򰴺�̽ڵ�������������������");
	        tree.inPreThreadList(root);

	        Node root2 = createBinaryTree(array, 0);
	        ThreadBinaryTree tree2 = new ThreadBinaryTree();
	        tree2.preThreadOrder(root2);
	        tree2.preNode = null;
	        System.out.println("\nǰ�򰴺�̽ڵ�������������������");
	        tree.preThreadList(root2);
	    
	}

}
