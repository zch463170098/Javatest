package com.xidian.practice;

/**
 * ��дһ����ΪOuter���࣬������һ����ΪInner���ࡣ��Outer�������һ��������
 * ������һ��Inner���͵Ķ�����main()�У���������ʼ��һ��ָ��ĳ��Inner�����
 * ���á�
 */
public class Excrise1 {
	/*����һ���ڲ���*/
	class Inner{
		Inner(){
			System.out.println("�õ�һ���ڲ��������");
		}
	}
	/*�ⲿ���ж���һ������Inner���Ͷ���ķ���*/
	public Inner getInner(){
		return new Inner();
	}
	public static void main(String[] args){
		Excrise1 e = new Excrise1();
		/*��main()�У���������ʼ��һ��ָ��ĳ��Inner���������*/
		Excrise1.Inner i = e.getInner();//����һ��ͨ�������ⲿ�෵���ڲ������õķ���
		Excrise1.Inner i2 = e.new Inner();//�������������ⲿ���������½�һ���ڲ����������
	}
}
