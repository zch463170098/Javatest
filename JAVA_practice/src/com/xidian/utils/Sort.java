package com.xidian.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort {
	
	/**
	 * ��������
	 * �͵�����
	 * �ȶ�
	 * ʱ�临�Ӷ�O��n2��
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
	 * ��ѡ������
	 * ʱ�临�Ӷ�O��n2��
	 * �͵�����
	 * �ȶ�
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
	 * ð������
	 * �͵�
	 * �ȶ�
	 * �Ľ������ӱ�־λ
	 * @param nums
	 * @return
	 */
	public static void bubbleSort(int[] nums) {
		if(nums.length<=1) {
			return;
		}
		boolean flag = false; //flag Ϊ���ʾ�Ѿ�����
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
	 * ��������
	 * ������ȫ����ʱʱ�临�Ӷ�O(n2)
	 * ���O(nlgn)�����־���
	 * @param nums
	 * @param low
	 * @param high
	 * @return
	 * ���ȶ�
	 * �͵�����
	 * �ɵݹ���ɵĿռ临�Ӷ���O(lgn)-O(n)
	 */
	public static void quickSort(int[] nums,int low,int high) {
		if(nums == null||low>=high||nums.length<=1) {
			return;
		}
		int mid = partition(nums,low,high);
		quickSort(nums,low,mid-1);        //���������-1 �ͻᷢ��ջ���
		quickSort(nums,mid+1,high);
		
	} 
	
	public static int partition(int[] nums,int low,int high) {
		int piviot = nums[high];     // �ڱ�,ͬʱ�൱�ڴ˴��и���λ
		while(high>low) {
			//���С�ڻ�׼������ָ�����
			while(nums[low]<=piviot&&low<high) {
				low++;
			}
			//������ڻ�׼��������ӣ�
			if(low<high) {
				nums[high] = nums[low];
				high--;
			}
			//���highָ��λ�ô��ڻ�׼����ָ��ǰ��
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
	 * �鲢����
	 * @param nums
	 * @param low
	 * @param high
	 * @return
	 * �ȶ��������㷨
	 * �ռ临�Ӷ�O��n��
	 * ʱ�� O(nlgn)
	 */
	public static void mergeSort(int[] nums,int low,int high) {
		if(nums == null||low>=high||nums.length<=1) {
			return;
		}
		int mid = (high + low)/2;
		if(low<high) {
			//���
			mergeSort(nums,low,mid);
			// �ұ�
			mergeSort(nums,mid+1,high);
			//�ϲ�
			merge(nums,low,mid,high);
		}
		
	}
	
	/**
	 * 
	 * @param nums ������������
	 * @param low
	 * @param mid
	 * @param high
	 */
	public static void merge(int[] nums,int low,int mid,int high) {
		int[] temps = new int[high - low +1];
		int i =low;  //��ָ��
		int j = mid+1; //��ָ��
		int k = 0;  //��ʱ����ָ��
		//��С��������������
		while(i<=mid&&j<=high){
			if(nums[i]<=nums[j]) {
				temps[k++] = nums[i++];	
			}else {
				temps[k++] = nums[j++];
			}
		}
		// ���ʣ���������������
		while(i<=mid) {
			temps[k++] = nums[i++];	
		}
		// �ұ�ʣ���������������
		while(j<=high) {
			temps[k++] = nums[j++];	
		}
		//����ԭ��������
		for(int m=0;m<temps.length;m++) {
			nums[low+m] = temps[m];
		}
	}
	
	/**
	 * ������
	 * ʱ��O��nlgn��
	 * �͵�����
	 * ���ȶ�
	 * @param nums
	 */
	public static int heapSize = 0;  //���е�Ԫ�ظ���
	public static void heapSort (int[] nums) {
		buildMaxHeap(nums);
		for(int i = heapSize-1;i>0;i--) {
			swap(nums,0,i);
			heapSize--;
			maxHeapIfY(nums,0);
		}
	}
	
	/**
	 * �����󶥶ѣ�ʱ�临�Ӷ�O(n)
	 * @param nums
	 */
	public static void buildMaxHeap(int[] nums) {
		heapSize = nums.length;
		for(int i = (heapSize-1)/2;i>=0;i--) {
			maxHeapIfY(nums,i);
		}
	}
	
	/**
	 * i ��ʾ���ڵ�
	 * ���Һ��ӷֱ��Ѿ�������
	 * @param nums
	 * @param i
	 */
	public static void maxHeapIfY(int[] nums,int i) {
		int l = i*2+1;
		int r = (i+1)*2;
		int largest = i;  //largest �������ֵ������
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
	 * ϣ������
	 * ʱ�临�Ӷ�O(n^1.5)
	 * ���ȶ�
	 * ������������ļ�¼���зָ�����������зֱ����ֱ�Ӳ������򣬴����������еļ�¼��������ʱ���ٶ������¼����һ��ֱ�Ӳ�������.
	 * Step1:���α������������е�ÿ��ֵdk��
	 * Step2:����ѡ����dk��������ֳ�dk�������У�ÿ���������е�����Ԫ�ص��±����dk��
	 * Step3:��Եڶ����е�ÿ�������н���ֱ�Ӳ�������
	 * @param nums ����������
	 * @param dlta ����ʱ���ݵĵ�������
	 */
	public static void shellSort(int[] nums,int[] dlta) {
		for(int i =0;i<dlta.length;i++) {
			shellInsert(nums,dlta[i]);
		}
	}
	
	/**
	 * Step2:����ѡ����dk��������ֳ�dk�������У�ÿ���������е�����Ԫ�ص��±����dk��
	 * Step3:��Եڶ����е�ÿ�������н���ֱ�Ӳ�������
	 * @param nums
	 * @param dk
	 */
	public static void shellInsert(int[] nums,int dk) {
		for(int i =0;i<dk;i++) {  //����ѡ����dk��������ֳ�dk��������
			for(int k = i+dk;k<nums.length;k=k+dk) {//��ÿ�������н���ֱ�Ӳ�������
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
	 * �Ǿ͵�����
	 * �ȶ��������㷨
	 * ʱ�临�Ӷ�O��n+k��
	 * �ռ临�Ӷ�O��n+k��
	 * @param nums ����������
	 * @param outs ����֮�������
	 * @param k ����nums�е�Ԫ����0��1֮��
	 */
	public static void countSort(int[] nums,int k) {
		int[] C = new int[k+1];  //C[i]�д��������i������nums��С�ڵ���i�ĸ���
		int[] temps = new int[nums.length];
		for(int i = 0;i<nums.length;i++) {
			C[nums[i]]++;
		}
		for(int i =1;i<=k;i++) {
			C[i] = C[i-1]+C[i];
		}
		//�Ӻ���ǰ��������nums��Ԫ�أ���֤���ȶ��Ĳ��뵽��ȷ��λ��
		for(int i =nums.length-1;i>=0;i--) {
			temps[C[nums[i]]-1] = nums[i];
			C[nums[i]]--;
		}
		
		for(int i =0;i<nums.length;i++) {
			nums[i] = temps[i];
		}
	}
	
	/**
	 * ��������
	 * ������n����dλ��������ÿһ����λ��k�����ܵ�ȡֵ��
	 * �����ÿ����Чλ������õ����ȶ��ļ��������㷨��
	 * ��ʱ�临�Ӷ���O(d(n+k))
	 * �ռ临�Ӷ�Ҳ��O(d(n+k))
	 * @param nums
	 * @param d  λ��
	 * @param k  �����
	 */
	public static void RadixSort(int[] nums,int d,int k) {
		for(int i = 1;i<=d;i++) {
			countSortWei(nums,d,k);
		}
	}
	
	/**
	 * ���������Ӧ��
	 * ������A������Ԫ�ذ��յ�i����Чλ��������
	 * @param nums
	 * @param i
	 * @param k
	 */
	public static void countSortWei(int[] nums,int i,int k) {
		int[] C = new int[k+1];  //C[i]�д��������i������nums��С�ڵ���i�ĸ���		
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
		//�Ӻ���ǰ��������nums��Ԫ�أ���֤���ȶ��Ĳ��뵽��ȷ��λ��
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
	 * Ͱ����
	 * �ȶ�
	 * ��Ա�������޵�����
	 * ʱ��O(n)
	 * �ռ�O(N+M)
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
        System.out.println("��������"+Arrays.toString(nums01));
        int [] nums02 = {49,38,65,97,76,13,27,49,55,4};
        mergeSort(nums02,0,nums02.length-1);
        System.out.println("�鲢����"+Arrays.toString(nums02));
        int[] nums03 = {49,38,65,97,76,13,27,49,55,4};
        selectionSort(nums03);
        System.out.println("ѡ������"+Arrays.toString(nums03));
        int[] nums04 = {49,38,65,97,76,13,27,49,55,4};
        bubbleSort(nums04);
        System.out.println("ð������"+Arrays.toString(nums04));
        int[] nums05 = {49,38,65,97,76,13,27,49,55,4};
        quickSort(nums05,0,nums05.length-1);
        System.out.println("��������"+Arrays.toString(nums05));
        int[] nums06 = {49,38,65,97,76,13,27,49,55,4};
        heapSort(nums06);
        System.out.println("������"+Arrays.toString(nums06));
        int[] nums07 = {49,38,65,97,76,13,27,49,55,4};
        int [] dlta = {5,3,1};
        shellSort(nums07,dlta);
        System.out.println("ϣ������:"+Arrays.toString(nums07));
        int [] nums08 = nums01;
        countSort(nums08,97);
        System.out.println("��������"+Arrays.toString(nums08));
        int[] nums09 = {329, 457, 657, 839, 436, 720, 355};
        int [] nums10 = nums01;
        RadixSort(nums10,2,10);
        System.out.println("��������"+Arrays.toString(nums10));
        int[] nums11 = nums01;
        bucketSort(nums11,10);
        System.out.println("Ͱ����"+Arrays.toString(nums11));
        
	}

}
