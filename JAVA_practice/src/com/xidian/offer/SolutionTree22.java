package com.xidian.offer;

import com.xidian.struct.TreeNode;
import com.xidian.struct.BitTree;
import java.util.ArrayList;
import java.util.LinkedList;


/*
 * ����һ�Ŷ������ĸ��ڵ��һ��������
 * ��ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 * (ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)
 */

/*
 * ���͵�DFS
 */

public class SolutionTree22 {
	
	private ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	private ArrayList<Integer> listPath = new ArrayList<>();
	private LinkedList<TreeNode> bitTree = new LinkedList<>();
	
	 public  ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		if(root == null) {
			return list;
		}
		listPath.add(root.val);
		target -= root.val;
		if(target == 0 && root.left == null &&root.right == null) {
			list.add(new ArrayList<Integer>(listPath));  // �����new�Ļ����ͻᵼ�����е�list�����ö�ָ��ͬһ��listPath
		}
		FindPath(root.left,target);
		FindPath(root.right,target);
		
		listPath.remove(listPath.size() -1);     //����ݹ鵽Ҷ�ڵ�û�б������Ļ�����Ҫ���»ص����ڵ㣬����Ѱ�ҡ�
		return list;
	         
	    }
	 
	 public static void main (String [] args) {
		SolutionTree22 s = new SolutionTree22();
		int [] nodes = {10,5,12,4,7};
		s.bitTree = BitTree.creatTree(nodes);
		int target = 22;
		ArrayList <ArrayList<Integer>> list = s.FindPath(s.bitTree.getFirst(),target);
		System.out.println(list.toString());
		 
		 
	 }
	
	 

	 

}
