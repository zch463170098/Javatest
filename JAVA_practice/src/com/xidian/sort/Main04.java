package com.xidian.sort;

/*
 * 归并排序
 * 1.申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
 * 2.设定两个指针，最初位置分别为两个已经排序序列的起始位置；
 * 3.比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
 * 4.重复步骤 3 直到某一指针到达序列尾；
 * 5.将另一序列剩下的所有元素直接复制到合并序列尾。
 * 
 * 归并排序算法总的时间复杂度是 O(nlogn)，
 * 而且这是归并排序算法中最好、最坏、平均的时间性能。
 * 而由于在归并排序过程中需要
 * 与原始记录序列同样数量的存储空间存放归并结果以及递归时压入栈的数据占用的空间：n + logn，
 * 所以空间复杂度为 O(n)。
 * 
 * 归并排序虽然比较稳定，在时间上也是非常有效的，
 * 但是这种算法很消耗空间，
 * 一般来说只有在外部排序才会采用这个方法，但在内部排序不会用这种方法，
 * 而是用快速排序。明天，我们将带来排序算法中的王牌：快速排序。
 */

public class Main04 {
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

    private static void mergeSort(int[] arr) {
        if (arr == null)
            return;
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start >= end)
            return;
        // 找出中间索引
        int mid = start + (end - start >> 1);
        // 对左边数组进行递归
        mergeSort(arr, start, mid);
        // 对右边数组进行递归
        mergeSort(arr, mid + 1, end);
        // 合并
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        // 先建立一个临时数组，用于存放排序后的数据
        int[] tmpArr = new int[arr.length];

        int start1 = start, end1 = mid, start2 = mid + 1, end2 = end;
        // 创建一个下标
        int pos = start1;
        // 缓存左边数组的第一个元素的索引
        int tmp = start1;
        while (start1 <= end1 && start2 <= end2) {
            // 从两个数组中取出最小的放入临时数组
            if (arr[start1] <= arr[start2])
                tmpArr[pos++] = arr[start1++];
            else
                tmpArr[pos++] = arr[start2++];
        }
        // 剩余部分依次放入临时数组，实际上下面两个 while 只会执行其中一个
        while (start1 <= end1) {
            tmpArr[pos++] = arr[start1++];
        }
        while (start2 <= end2) {
            tmpArr[pos++] = arr[start2++];
        }
        // 将临时数组中的内容拷贝回原来的数组中
        while (tmp <= end) {
            arr[tmp] = tmpArr[tmp++];
        }

    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 2, 1, 8, 3, 7, 9, 5};
        mergeSort(arr);
        printArr(arr);
    }


}
