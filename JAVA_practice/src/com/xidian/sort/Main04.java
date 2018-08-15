package com.xidian.sort;

/*
 * �鲢����
 * 1.����ռ䣬ʹ���СΪ�����Ѿ���������֮�ͣ��ÿռ�������źϲ�������У�
 * 2.�趨����ָ�룬���λ�÷ֱ�Ϊ�����Ѿ��������е���ʼλ�ã�
 * 3.�Ƚ�����ָ����ָ���Ԫ�أ�ѡ�����С��Ԫ�ط��뵽�ϲ��ռ䣬���ƶ�ָ�뵽��һλ�ã�
 * 4.�ظ����� 3 ֱ��ĳһָ�뵽������β��
 * 5.����һ����ʣ�µ�����Ԫ��ֱ�Ӹ��Ƶ��ϲ�����β��
 * 
 * �鲢�����㷨�ܵ�ʱ�临�Ӷ��� O(nlogn)��
 * �������ǹ鲢�����㷨����á����ƽ����ʱ�����ܡ�
 * �������ڹ鲢�����������Ҫ
 * ��ԭʼ��¼����ͬ�������Ĵ洢�ռ��Ź鲢����Լ��ݹ�ʱѹ��ջ������ռ�õĿռ䣺n + logn��
 * ���Կռ临�Ӷ�Ϊ O(n)��
 * 
 * �鲢������Ȼ�Ƚ��ȶ�����ʱ����Ҳ�Ƿǳ���Ч�ģ�
 * ���������㷨�����Ŀռ䣬
 * һ����˵ֻ�����ⲿ����Ż������������������ڲ����򲻻������ַ�����
 * �����ÿ����������죬���ǽ����������㷨�е����ƣ���������
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
        // �ҳ��м�����
        int mid = start + (end - start >> 1);
        // �����������еݹ�
        mergeSort(arr, start, mid);
        // ���ұ�������еݹ�
        mergeSort(arr, mid + 1, end);
        // �ϲ�
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        // �Ƚ���һ����ʱ���飬���ڴ������������
        int[] tmpArr = new int[arr.length];

        int start1 = start, end1 = mid, start2 = mid + 1, end2 = end;
        // ����һ���±�
        int pos = start1;
        // �����������ĵ�һ��Ԫ�ص�����
        int tmp = start1;
        while (start1 <= end1 && start2 <= end2) {
            // ������������ȡ����С�ķ�����ʱ����
            if (arr[start1] <= arr[start2])
                tmpArr[pos++] = arr[start1++];
            else
                tmpArr[pos++] = arr[start2++];
        }
        // ʣ�ಿ�����η�����ʱ���飬ʵ������������ while ֻ��ִ������һ��
        while (start1 <= end1) {
            tmpArr[pos++] = arr[start1++];
        }
        while (start2 <= end2) {
            tmpArr[pos++] = arr[start2++];
        }
        // ����ʱ�����е����ݿ�����ԭ����������
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
