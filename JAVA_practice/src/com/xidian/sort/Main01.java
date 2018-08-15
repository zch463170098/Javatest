package com.xidian.sort;

/*
 * 改进版的冒泡排序
 * 原理：
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * 
 * 冒泡排序的算法时间平均复杂度为 O(n²)。空间复杂度为 O(1)。
 * 稳定排序
 */
public class Main01 {
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

    private static void bubbleSort(int[] arr) {
        if (arr == null)
            return;
        // 定义一个标记 isSort，当其值为 true 的时候代表已经有序。
        boolean isSort;
        for (int i = 0; i < arr.length - 1; i++) {
            isSort = true;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    isSort = false;
                }
            }
            if (isSort)
                break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 2, 1, 8, 3, 7, 9, 5};
        bubbleSort(arr);
        printArr(arr);
    }



}
