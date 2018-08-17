package com.xidian.offer;

/**
 * @author Zhang Chenghui
 * E-mail: 463170098@qq.com
 * @version 1.0 
 * ����ʱ�䣺2017��10��10�� ����9:31:58
 * ˵������Ŀ����
��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳�����������һ��������
����������һ����ά�����һ���������ж��������Ƿ��и�������
 */
public class Solution03 {
	
	/**
	 * ���б������㷨���Ӷ�O(n^2)
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
	 * ��ͨ�취�����б���+���ֲ���
	 * �㷨���Ӷ� O(nlogn)
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
					 //ע��˴�Ϊʲô-1
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

���ö�ά�������ϵ��£������ҵ����Ĺ��ɣ�
��ôѡȡ���Ͻǻ������½ǵ�Ԫ��a[row][col]��target���бȽϣ�
��targetС��Ԫ��a[row][col]ʱ����ôtarget�ض���Ԫ��a�����е����,
��col--��
��target����Ԫ��a[row][col]ʱ����ôtarget�ض���Ԫ��a�����е��±�,
��row++��
ʱ�临�Ӷ�Ϊ��O(n)
	  * @param target
	  * @param array
	  * @return
	  */
	 public boolean Find3(int target, int[][] array){
		 //ѡȡ���½ǵ�Ԫ��
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

