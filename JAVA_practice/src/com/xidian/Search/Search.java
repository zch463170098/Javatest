package com.xidian.Search;

public class Search {
	
	/**
	 * ˳�����
	 * @param nums ��������
	 * @param target Ŀ��
	 * @return -1��ʾ����ʧ�� �ɹ������±�
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
	 * �۰����Ҫ�����Ա��������
	 * �������̴�������м�Ԫ�ؿ�ʼ������м�Ԫ��������Ҫ���ҵ�Ԫ�أ����������̽�����
	 * ���ĳһ�ض�Ԫ�ش��ڻ���С���м�Ԫ�أ�����������ڻ�С���м�Ԫ�ص���һ���в��ң����Ҹ���ʼһ�����м�Ԫ�ؿ�ʼ�Ƚϡ�
	 * �����ĳһ��������Ϊ�գ�������Ҳ�����
	 * ���������㷨ÿһ�αȽ϶�ʹ������Χ��Сһ�롣
	 * �۰�����ÿ�ΰ������������һ�룬ʱ�临�Ӷ�ΪO(log n)��
	 * @param nums
	 * @param target
	 * @return
	 * ���Խ��������ж�������۰���ҵ�ƽ�����ҳ��ȣ�log2(n+1)-1��
	 * �۰������ʧ��ʱ����ȽϵĹؼ��ָ����������ж�������ȣ�
	 * n��Ԫ�ص��ж�������Ⱥ�n��Ԫ�ص���ȫ�������������ͬlog2(n)+1
	 */
	public static int binarySearch(int[] nums,int target) {
		if(nums.length<=0) {
			return -1;       //-1�������ʧ��
		}
		int index = -1;
		int start = 0;
		int end = nums.length -1;
		while(start<=end) {   //ע�� 
			//�����start < end����ô��target����num[num.length-1]ʱ�����Ҳ�����ֵ
			int mid = (start+end)/2;
			if(nums[mid] == target) {
				return mid;
			}else if(nums[mid]>target){
				end = mid-1;   //ע��  �����ڱ߽�ֵ����������ѭ��
			}else {
				start = mid+1;  //ע��
			}
		}
		
		return -1;
	}
	
	/**
	 * �ֿ����
	 * �ֿ�����ֳ�����˳����ң�����һ�����ܽ���˳����Һ��۰����֮��Ĳ��ҷ�����
	 * �ֿ��������ֻҪ��������������ģ��Կ��ڽڵ�û������Ҫ������ر��ʺ��ڽڵ㶯̬�仯�������
	 * �ֿ����Ҫ���һ��������Ա�ֽ�����ɿ飬ÿ���еĽڵ���������ţ��������֮���������
	 * step1 ��ѡȡ�����е����ؼ��ֹ���һ��������
	 * step2 ���ҷ��������֣��ȶ���������ж��ֲ��һ�˳����ң���ȷ�������¼����һ���У�
	 * step3 Ȼ������ȷ���Ŀ�����˳�򷨽��в���
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
        System.out.println("˳����ң�"+orderSearch(nums,5));
        System.out.println("�����ң�"+binarySearch(nums,5));
	}

}
