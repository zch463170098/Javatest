package com.xidian.sort;

/*
 * 选择排序
 * 1.从待排序序列中，找到关键字最小的元素；起始假定第一个元素为最小。
 * 2.如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换。
 * 3.从余下的 N - 1 个元素中，找出关键字最小的元素，重复1，2步，直到排序结束。
 * 
 * 选择排序的算法时间平均复杂度为O(n²)。选择排序空间复杂度为 O(1)。选择排序为不稳定排序。
 */

public class Main02 {
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

    private static void selectSort(int[] arr) {
        if (arr == null)
            return;
        int i, j, min, len = arr.length;
        for (i = 0; i < len - 1; i++) {
            min = i; // 未排序的序列中最小元素的下标
            for (j = i + 1; j < len; j++) {
                //在未排序元素中继续寻找最小元素，并保存其下标
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i)
                swap(arr, min, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 2, 1, 8, 3, 7, 9, 5};
        selectSort(arr);
        printArr(arr);
    }
	
}
