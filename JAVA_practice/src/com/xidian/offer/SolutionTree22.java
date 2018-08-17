package com.xidian.offer;

import com.xidian.struct.TreeNode;
import com.xidian.struct.BitTree;
import java.util.ArrayList;
import java.util.LinkedList;


/*
 * 输入一颗二叉树的跟节点和一个整数，
 * 打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */

/*
 * 典型的DFS
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
			list.add(new ArrayList<Integer>(listPath));  // 如果不new的话，就会导致所有的list的引用都指向同一个listPath
		}
		FindPath(root.left,target);
		FindPath(root.right,target);
		
		listPath.remove(listPath.size() -1);     //如果递归到叶节点没有遍历到的话，就要重新回到根节点，继续寻找。
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
