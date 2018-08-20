package com.xidian.Search;

public class Search {
	
	/**
	 * 顺序查找
	 * @param nums 待查数组
	 * @param target 目标
	 * @return -1表示查找失败 成功返回下标
	 */
	public static int orderSearch(int[] nums,int target) {
		if(nums.length<=0) {
			return -1;
		}
		int index = -1 ;
		for(int i =nums.length -1;i>=0;i--) {
			if(nums[i] == target)
				return i;
		}
		return -1;
	}
	/**
	 * 折半查找要求线性表是有序表。
	 * 搜索过程从数组的中间元素开始，如果中间元素正好是要查找的元素，则搜索过程结束；
	 * 如果某一特定元素大于或者小于中间元素，则在数组大于或小于中间元素的那一半中查找，而且跟开始一样从中间元素开始比较。
	 * 如果在某一步骤数组为空，则代表找不到。
	 * 这种搜索算法每一次比较都使搜索范围缩小一半。
	 * 折半搜索每次把搜索区域减少一半，时间复杂度为O(log n)。
	 * @param nums
	 * @param target
	 * @return
	 * 可以借助二叉判定树求得折半查找的平均查找长度：log2(n+1)-1。
	 * 折半查找在失败时所需比较的关键字个数不超过判定树的深度，
	 * n个元素的判定树的深度和n个元素的完全二叉树的深度相同log2(n)+1
	 */
	public static int binarySearch(int[] nums,int target) {
		if(nums.length<=0) {
			return -1;       //-1代表查找失败
		}
		int index = -1;
		int start = 0;
		int end = nums.length -1;
		while(start<=end) {   //注意 
			//如果是start < end，那么当target等于num[num.length-1]时，会找不到该值
			int mid = (start+end)/2;
			if(nums[mid] == target) {
				return mid;
			}else if(nums[mid]>target){
				end = mid-1;   //注意  否则在边界值程序将陷入死循环
			}else {
				start = mid+1;  //注意
			}
		}
		
		return -1;
	}
	
	/**
	 * 分块查找
	 * 分块查找又称索引顺序查找，它是一种性能介于顺序查找和折半查找之间的查找方法。
	 * 分块查找由于只要求索引表是有序的，对块内节点没有排序要求，因此特别适合于节点动态变化的情况。
	 * 分块查找要求把一个大的线性表分解成若干块，每块中的节点可以任意存放，但块与块之间必须排序
	 * step1 先选取各块中的最大关键字构成一个索引表；
	 * step2 查找分两个部分：先对索引表进行二分查找或顺序查找，以确定待查记录在哪一块中；
	 * step3 然后，在已确定的块中用顺序法进行查找
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int blockSearch(int[] nums,int target) {
		
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] nums = {0,1,2,3,4,5,6,7,8,9};
        System.out.println("顺序查找："+orderSearch(nums,5));
        System.out.println("拆半查找："+binarySearch(nums,5));
	}

}
