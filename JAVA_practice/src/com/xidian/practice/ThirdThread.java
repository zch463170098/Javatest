package com.xidian.practice;

/**
 * @author Zhang Chenghui
 * E-mail: 463170098@qq.com
 * @version 1.0 
 * ����ʱ�䣺2018��5��10�� ����4:27:23
 * ˵����
 */
import java.util.concurrent.*;


public class ThirdThread
{
	public static void main(String[] args)
	{
		// ����Callable����
//		ThirdThread rt = new ThirdThread();
		// ��ʹ��Lambda���ʽ����Callable<Integer>����
		// ʹ��FutureTask����װCallable����
		FutureTask<Integer> task = new FutureTask<Integer>((Callable<Integer>)() -> {
			int i = 0;
			for ( ; i < 100 ; i++ )
			{
				System.out.println(Thread.currentThread().getName()
					+ " ��ѭ������i��ֵ��" + i);
			}
			// call()���������з���ֵ
			return i;
		});
		for (int i = 0 ; i < 100 ; i++)
		{
			System.out.println(Thread.currentThread().getName()
				+ " ��ѭ������i��ֵ��" + i);
			if (i == 20)
			{
				// ʵ�ʻ�����Callable�������������������߳�
				new Thread(task , "�з���ֵ���߳�").start();
			}
		}
		try
		{
			// ��ȡ�̷߳���ֵ
			System.out.println("���̵߳ķ���ֵ��" + task.get());
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}

