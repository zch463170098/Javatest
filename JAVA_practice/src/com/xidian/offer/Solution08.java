package com.xidian.offer;

/**
 * @author Zhang Chenghui
 * E-mail: 463170098@qq.com
 * @version 1.0 
 * 创建时间：2017年10月14日 下午9:04:50
 * 说明：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *  输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 
 *  例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，
 * 该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

import java.util.ArrayList;
public class Solution08 {
	
    /**
     * 常规方法遍历到那个突然递减的数即可
     * 时间复杂度o(n)
     * @param array
     * @return
     */
	public int minNumberInRotateArray01(int [] array){
		//数组为空时
		if(array.length==0){
			return 0;
		}
		//部分数组旋转
		for (int i=0;i<array.length-1;i++){
			if(array[i]>array[i+1]){
				return array[i+1];
			}
		}
		// 全部旋转，相当于没有旋转
		return array[0];
	}
	
	public static int method(int[] array) {
		//边界
		if(array.length<=0) {
			return 0;
		}
		int low = 0;
		int high = array.length-1;
		int mid =0;
		while(low<high) {
			mid = (low+high)/2;
			if(array[mid]>array[low]&&array[mid]>array[high]) {
				low = mid+1;
			}else if(array[mid]<array[low]&&array[mid]<array[high]) {
				high = mid;  //注意此处不能-1 ，因为array[mid]本身有可能已经是要找的数了
		    }else {
			
				high = mid;  //注意 如果没有这步，当为两个数的时候就会陷入无穷循环+
			}
		}
		return array[mid];
	}
	
	public static void main(String[] args) {
		int[] array = {5,6,7,8,1,2,3,4};
		System.out.println(method(array));
	}
	

}

