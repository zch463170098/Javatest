package com.xidian.offer;

/*
 * ʵ�ֵ���ģʽ
 * ��ĿҪ�����һ���࣬����ֻ�����ɸ����һ��ʵ�ࡣ
 * ���ģʽ�еĵ���ģʽ
 * ������
 */

public class Solution02 {
	//���캯������Ϊ˽�к���,
	//���ַ�ʽֻ�����ڵ��̻߳���
	private Solution02() {
		
	}
	
	private static Solution02 instance = null;
	
	//�����ڵ��߳�
	public static Solution02 getInstance() {
		if(instance == null ) {
			instance = new Solution02();
			return instance;
		}else {
			return instance;
		}
	}
	
	/**
	 * �����ڶ��̻߳���������ͬ����������Ч�ʲ���
	 * ��Ϊ���κ�ʱ��ֻ��һ���߳�ȥ����getInstance02����
	 * ͬʱ��������Ҳ��ʮ�ֺ�ʱ��
	 * @return
	 */
	public static synchronized Solution02 getInstance02() {
		if(instance == null) {
			instance = new Solution02();
			return instance;
		}
		return instance;
		
	}
	/**
	 * ��һ�θĽ�����ʵ��û�д���֮ǰ��������ֻ֤��һ���̴߳���ʵ��
	 * 
	 * @return
	 */
	public static Solution02 getInstance03() {
		if(instance == null) {
			synchronized (Solution02.class) {
				instance = new Solution02();
				return instance;
			}
			
		}
		return instance;
	}
	/*
	 * ǿ���Ƽ��ķ�������̬�ڲ���
	 * ��̬�ڲ���ֻ�ᱻ����һ�Σ��������̰߳�ȫ�ġ�
	 */
	private static class Holder{
		private static Solution02 instance = new Solution02();
	}
	
	public static Solution02 getInstance04() {
		return Holder.instance;
	} 
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
