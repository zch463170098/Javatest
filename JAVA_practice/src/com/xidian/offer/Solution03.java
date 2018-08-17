package com.xidian.offer;

/**
 * @author Zhang Chenghui
 * E-mail: 463170098@qq.com
 * @version 1.0 
 * 创建时间：2017年10月10日 下午9:31:58
 * 说明：题目描述
在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，
输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution03 {
	
	/**
	 * 逐行遍历，算法复杂度O(n^2)
	 * @param target
	 * @param array
	 * @return
	 */
	public boolean Find1(int target,int[][] array){
		for(int i = 0;i<array.length;i++){
			for(int j = 0;j<array[i].length;j++){
				if(target==array[i][j])
					return true;
			}
		}
		return false;
	}
	/**
	 * 普通办法，逐行遍历+二分查找
	 * 算法复杂度 O(nlogn)
	 * @param target
	 * @param array
	 * @return
	 */
	 public boolean Find2(int target, int [][] array) {
		 for(int i = 0;i<array.length;i++){
			 int low = 0;
			 int high = array[i].length-1;
			 while(low<=high){
				 int mid = (low+high)/2;
				 if(target<array[i][mid]){
					 //注意此处为什么-1
					 high = mid-1;
				 }else if(target>array[i][mid]){
					 low = mid+1;
				 }else{
					 return true;
				 }
			 }
		 }
		 
		return false;
    }
	 /**
	  * 

利用二维数组由上到下，由左到右递增的规律，
那么选取右上角或者左下角的元素a[row][col]与target进行比较，
当target小于元素a[row][col]时，那么target必定在元素a所在行的左边,
即col--；
当target大于元素a[row][col]时，那么target必定在元素a所在列的下边,
即row++；
时间复杂度为：O(n)
	  * @param target
	  * @param array
	  * @return
	  */
	 public boolean Find3(int target, int[][] array){
		 //选取左下角的元素
		 int row = array.length-1;
		 int col = 0;
		 while(col<array[0].length&&row>=0){
			 if(target==array[row][col])
				return true;
			 else if(target>array[row][col])
				 col++;
			 else
				 row--;
				 
		 }
		 return false;
	 }

	 public static void main (String[] args){
		 Solution03 solution1 = new Solution03();
		 int array[][] = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		 int target = 5;
		 boolean flag1 = solution1.Find1(target,array);
		 boolean flag2 = solution1.Find2(target,array);
		 boolean flag3 = solution1.Find3(target,array);
		 System.out.println("flag1:"+flag1);
		 System.out.println("flag2:"+flag2);
		 System.out.println("flag3:"+flag3);
		 String a= "TextPathView\u662f\u4e00\u4e2a\u628a\u6587\u5b57\u8f6c\u5316\u4e3a\u8def\u5f84\u52a8\u753b\u7136\u540e\u5c55\u73b0\u51fa\u6765\u7684\u81ea\u5b9a\u4e49\u63a7\u4ef6";
		 System.out.println("a:"+a);
	 }
}

