package com.xidian.sort;

/*
 * 插入排序
 * 思路：
 * 1.从第一个元素开始，该元素可以认为已经被排序。
 * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描。
 * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置。
 * 4.重复步骤 3，直到找到已排序的元素小于或者等于新元素的位置
 * 5.将新元素插入到该位置后
 * 6.重复步骤 2~5
 * 
 * 总结：
 * 插入排序的算法时间平均复杂度为O(n²)。
 * 插入排序空间复杂度为 O(1)。
 * 插入排序为稳定排序。
 * 插入排序对于近乎有序的数组来说效率更高，插入排序可用来优化高级排序算法
 */

public class Main03 {

	  private static void swap(int[] arr, int i, int j) {
	        int temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }

	    private static void printArr(int[] arr) {
	        for (int anArr : arr) {
	            System.out.print(anArr + " ");
	        }
	    }

	    private static void insertionSort(int[] arr) {
	        if (arr == null)
	            return;
	        int j;
	        int temp;
	        for (int i = 1; i < arr.length; i++) {
	            // 设置哨兵，拿出待插入的值
	            temp = arr[i];
	            j = i;
	            // 然后寻找正确插入的位置
	            while (j > 0 && arr[j - 1] > temp) {
	                arr[j] = arr[j - 1];
	                j--;
	            }
	            arr[j] = temp;
	        }
	    }

	    public static void main(String[] args) {
	        int[] arr = {6, 4, 2, 1, 8, 3, 7, 9, 5};
	        insertionSort(arr);
	        printArr(arr);
	    }
}
