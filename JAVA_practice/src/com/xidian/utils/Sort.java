package com.xidian.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort {
	
	/**
	 * 插入排序
	 * 就地排序
	 * 稳定
	 * 时间复杂度O（n2）
	 * @param values
	 */
	public static void insertSort(int[] nums) {
		if(nums.length<=1) {
			return;
		}
		for(int i = 1;i<nums.length;i++) {
			int key = nums[i];
			int position = i-1;
			while((position>=0)&&(key<nums[position])) {
				nums[position+1] = nums[position];
				position--;
			}
			nums[position+1] = key;
		}
		
	}
	                                                                                                                                                                         
	/**
	 * 简单选择排序
	 * 时间复杂度O（n2）
	 * 就地排序
	 * 稳定
	 * @param nums
	 * @return
	 */
	public static void selectionSort(int[] nums) {
		if(nums.length<=1) {
			return;
		}
		int min = 0;
		int temp = 0;
		for(int i = 0;i<nums.length;i++) {
			min = i;
			for(int j = i+1;j<nums.length;j++) {
				if(nums[j]<nums[min]) {
					min = j;
				}
				
			}
			if(i!=min) {
				temp = nums[i];
				nums[i] = nums[min];
				nums[min] = temp;
			}
		}
		
	}
	
	/**
	 * 冒泡排序
	 * 就地
	 * 稳定
	 * 改进，增加标志位
	 * @param nums
	 * @return
	 */
	public static void bubbleSort(int[] nums) {
		if(nums.length<=1) {
			return;
		}
		boolean flag = false; //flag 为真表示已经有序
		for(int i =0;i<nums.length&&flag !=true;i++) {
			flag = true;
			for(int j =nums.length-1;j>i;j--) {
				if(nums[j]<nums[j-1]) {
					swap(nums,j-1,j);
					flag = false;
				}
			}
		}
		
	}
	
	/**
	 * 快速排序
	 * 数组完全有序时时间复杂度O(n2)
	 * 最好O(nlgn)，划分均衡
	 * @param nums
	 * @param low
	 * @param high
	 * @return
	 * 不稳定
	 * 就地排序
	 * 由递归造成的空间复杂度是O(lgn)-O(n)
	 */
	public static void quickSort(int[] nums,int low,int high) {
		if(nums == null||low>=high||nums.length<=1) {
			return;
		}
		int mid = partition(nums,low,high);
		quickSort(nums,low,mid-1);        //这里如果不-1 就会发生栈溢出
		quickSort(nums,mid+1,high);
		
	} 
	
	public static int partition(int[] nums,int low,int high) {
		int piviot = nums[high];     // 哨兵,同时相当于此处有个坑位
		while(high>low) {
			//如果小于基准数，则指针后移
			while(nums[low]<=piviot&&low<high) {
				low++;
			}
			//如果大于基准数，则填坑，
			if(low<high) {
				nums[high] = nums[low];
				high--;
			}
			//如果high指针位置大于基准数，指针前移
			while(nums[high]>=piviot&&low<high) {
				high--;
			}
			if(low<high) {
				nums[low] = nums[high];
				low++;
			}
		}
		nums[high] = piviot;
		return high;
	}
	
	/**
	 * 归并排序
	 * @param nums
	 * @param low
	 * @param high
	 * @return
	 * 稳定的排序算法
	 * 空间复杂度O（n）
	 * 时间 O(nlgn)
	 */
	public static void mergeSort(int[] nums,int low,int high) {
		if(nums == null||low>=high||nums.length<=1) {
			return;
		}
		int mid = (high + low)/2;
		if(low<high) {
			//左边
			mergeSort(nums,low,mid);
			// 右边
			mergeSort(nums,mid+1,high);
			//合并
			merge(nums,low,mid,high);
		}
		
	}
	
	/**
	 * 
	 * @param nums 两个有序数组
	 * @param low
	 * @param mid
	 * @param high
	 */
	public static void merge(int[] nums,int low,int mid,int high) {
		int[] temps = new int[high - low +1];
		int i =low;  //左指针
		int j = mid+1; //右指针
		int k = 0;  //临时数组指针
		//较小的数放在数组中
		while(i<=mid&&j<=high){
			if(nums[i]<=nums[j]) {
				temps[k++] = nums[i++];	
			}else {
				temps[k++] = nums[j++];
			}
		}
		// 左边剩余的数放在数组中
		while(i<=mid) {
			temps[k++] = nums[i++];	
		}
		// 右边剩余的数放在数组中
		while(j<=high) {
			temps[k++] = nums[j++];	
		}
		//覆盖原来的数组
		for(int m=0;m<temps.length;m++) {
			nums[low+m] = temps[m];
		}
	}
	
	/**
	 * 堆排序
	 * 时间O（nlgn）
	 * 就地排序
	 * 不稳定
	 * @param nums
	 */
	public static int heapSize = 0;  //堆中的元素个数
	public static void heapSort (int[] nums) {
		buildMaxHeap(nums);
		for(int i = heapSize-1;i>0;i--) {
			swap(nums,0,i);
			heapSize--;
			maxHeapIfY(nums,0);
		}
	}
	
	/**
	 * 建立大顶堆，时间复杂度O(n)
	 * @param nums
	 */
	public static void buildMaxHeap(int[] nums) {
		heapSize = nums.length;
		for(int i = (heapSize-1)/2;i>=0;i--) {
			maxHeapIfY(nums,i);
		}
	}
	
	/**
	 * i 表示根节点
	 * 左右孩子分别已经是最大堆
	 * @param nums
	 * @param i
	 */
	public static void maxHeapIfY(int[] nums,int i) {
		int l = i*2+1;
		int r = (i+1)*2;
		int largest = i;  //largest 代表最大值得索引
		if(l<heapSize&&nums[l]>nums[largest]) {
			largest = l;
		}
		
		if(r<heapSize&&nums[r]>nums[largest]) {
			largest = r;
		}
		
		if(largest!=i) {
			swap(nums,i,largest);
			maxHeapIfY(nums,largest);
		}
	}
	
	/**
	 * 希尔排序
	 * 时间复杂度O(n^1.5)
	 * 不稳定
	 * 将整个待排序的记录序列分割成若干子序列分别进行直接插入排序，待整个序列中的记录基本有序时，再对整体记录进行一次直接插入排序.
	 * Step1:依次遍历递增序列中的每个值dk；
	 * Step2:根据选到的dk，把数组分成dk个子序列，每个子序列中的相邻元素的下标相差dk；
	 * Step3:针对第二步中的每个子序列进行直接插入排序。
	 * @param nums 待排序数组
	 * @param dlta 排序时依据的递增序列
	 */
	public static void shellSort(int[] nums,int[] dlta) {
		for(int i =0;i<dlta.length;i++) {
			shellInsert(nums,dlta[i]);
		}
	}
	
	/**
	 * Step2:根据选到的dk，把数组分成dk个子序列，每个子序列中的相邻元素的下标相差dk；
	 * Step3:针对第二步中的每个子序列进行直接插入排序。
	 * @param nums
	 * @param dk
	 */
	public static void shellInsert(int[] nums,int dk) {
		for(int i =0;i<dk;i++) {  //根据选到的dk，就数组分成dk个子序列
			for(int k = i+dk;k<nums.length;k=k+dk) {//对每个子序列进行直接插入排序
				int j = k-dk;
				int key = nums[k];
				while(j>=0&&key<nums[j]) {
					nums[j+dk] = nums[j];
					j = j-dk;
				}
				nums[j+dk] = key;
			}
		}
	}
	
	/**
	 * 非就地排序
	 * 稳定的排序算法
	 * 时间复杂度O（n+k）
	 * 空间复杂度O（n+k）
	 * @param nums 待排序数组
	 * @param outs 排序之后的数组
	 * @param k 数组nums中的元素在0到1之间
	 */
	public static void countSort(int[] nums,int k) {
		int[] C = new int[k+1];  //C[i]中存的是整数i在数组nums中小于等于i的个数
		int[] temps = new int[nums.length];
		for(int i = 0;i<nums.length;i++) {
			C[nums[i]]++;
		}
		for(int i =1;i<=k;i++) {
			C[i] = C[i-1]+C[i];
		}
		//从后向前遍历数组nums的元素，保证其稳定的插入到正确的位置
		for(int i =nums.length-1;i>=0;i--) {
			temps[C[nums[i]]-1] = nums[i];
			C[nums[i]]--;
		}
		
		for(int i =0;i<nums.length;i++) {
			nums[i] = temps[i];
		}
	}
	
	/**
	 * 基数排序。
	 * 给定的n个的d位数，其中每一个数位有k个可能的取值。
	 * 如果对每个有效位排序采用的是稳定的计数排序算法，
	 * 则时间复杂度是O(d(n+k))
	 * 空间复杂度也是O(d(n+k))
	 * @param nums
	 * @param d  位数
	 * @param k  最大数
	 */
	public static void RadixSort(int[] nums,int d,int k) {
		for(int i = 1;i<=d;i++) {
			countSortWei(nums,d,k);
		}
	}
	
	/**
	 * 计数排序的应用
	 * 对数组A中所有元素按照第i个有效位进行排序
	 * @param nums
	 * @param i
	 * @param k
	 */
	public static void countSortWei(int[] nums,int i,int k) {
		int[] C = new int[k+1];  //C[i]中存的是整数i在数组nums中小于等于i的个数		
		int[] temps = new int[nums.length];
		int z =1;
		for(int j = 0;j<i;j++) {
			z = z*10;
		}
		z= z/10;
		for(int j = 0;j<nums.length;j++) {
			C[nums[j]/z%10]++;
		}
		for(int j =1;j<=k;j++) {
			C[j] = C[j-1]+C[j];
		}
		//从后向前遍历数组nums的元素，保证其稳定的插入到正确的位置
		for(int j =nums.length-1;j>=0;j--) {
			int position = nums[j]/z%10;
			temps[C[position]-1] = nums[j];
			C[position]--;
		}
		for(int j =0;j<nums.length;j++) {
			nums[j] = temps[j];
		}
	
	}
	
	/**
	 * 桶排序
	 * 稳定
	 * 成员属于有限的区间
	 * 时间O(n)
	 * 空间O(N+M)
	 * @param nums
	 * @param maxNum
	 */
	public static void bucketSort(int[] nums,int maxNum) {
		           
        ArrayList <ArrayList<Integer>>  bucket= new ArrayList<>();
        for(int i =0;i<maxNum;i++) {
        	ArrayList<Integer> tempList = new ArrayList<>();
        	bucket.add(tempList);
        }
 		for(int i= 0;i<nums.length;i++) {
			int temp = nums[i]/10;
			bucket.get(temp).add(nums[i]);
			
		}
		
		for(int i=0,count=0;i<maxNum-1;i++) {
			Collections.sort((bucket.get(i)));
			for(int j =0;j<bucket.size();j++) {
				while(bucket.get(i).size()>0) {
					nums[count++] = bucket.get(i).remove(0);
				}
			}
		}
	}
	
	public static void swap(int[] nums,int i,int j) {
		int temp = 0;
		temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int [] nums01 = {49,38,65,97,76,13,27,49,55,4};
        insertSort(nums01);
        System.out.println("插入排序："+Arrays.toString(nums01));
        int [] nums02 = {49,38,65,97,76,13,27,49,55,4};
        mergeSort(nums02,0,nums02.length-1);
        System.out.println("归并排序："+Arrays.toString(nums02));
        int[] nums03 = {49,38,65,97,76,13,27,49,55,4};
        selectionSort(nums03);
        System.out.println("选择排序："+Arrays.toString(nums03));
        int[] nums04 = {49,38,65,97,76,13,27,49,55,4};
        bubbleSort(nums04);
        System.out.println("冒泡排序："+Arrays.toString(nums04));
        int[] nums05 = {49,38,65,97,76,13,27,49,55,4};
        quickSort(nums05,0,nums05.length-1);
        System.out.println("快速排序："+Arrays.toString(nums05));
        int[] nums06 = {49,38,65,97,76,13,27,49,55,4};
        heapSort(nums06);
        System.out.println("堆排序："+Arrays.toString(nums06));
        int[] nums07 = {49,38,65,97,76,13,27,49,55,4};
        int [] dlta = {5,3,1};
        shellSort(nums07,dlta);
        System.out.println("希尔排序:"+Arrays.toString(nums07));
        int [] nums08 = nums01;
        countSort(nums08,97);
        System.out.println("计数排序："+Arrays.toString(nums08));
        int[] nums09 = {329, 457, 657, 839, 436, 720, 355};
        int [] nums10 = nums01;
        RadixSort(nums10,2,10);
        System.out.println("基数排序："+Arrays.toString(nums10));
        int[] nums11 = nums01;
        bucketSort(nums11,10);
        System.out.println("桶排序："+Arrays.toString(nums11));
        
	}

}
