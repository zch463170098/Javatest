package com.xidian.struct;

import java.util.Arrays;

/**
 * 
 * @author Administrator
 *�ַ���ƥ��
 *
 */
public class StringTest {
	
	
	/**
	 * ����ƥ��
	 * ʱ�临�Ӷ�O(n*m)
	 * @param ss
	 * @param st
	 * @return
	 */
	public static int simplicity(String ss,String st) {
		int position = -1;
		char[] s = ss.toCharArray();
		char[] t = st.toCharArray();
		for(int i =0;i<s.length;i++) {
			int j = 0;
			for(;j<t.length;) {
				if(s[i]==t[j]) {
					i++;
					j++;
				}else {
					j = 0;
					i = i-j+1;
				}
			}
			if(j==t.length) {
				position = i-j;
				break;
			}
		}
		return position;
	}
	public static int KMP(String ss,String st) {
		char[] s = ss.toCharArray();
		char[] t = st.toCharArray();
		int p = -1;
		int[] next = get_next(st);
		int i = 0;
		int j = 0;
		while(i<s.length&&j<t.length) {
			if(j==-1||s[i]==t[j]) {
				i++;
				j++;
			}else {
				j = next[j];
			}
		}
		if(j==t.length) {
			p =i-j;
		}
		return p;
		
	}
	
	public static int[] get_next(String st) {
		char[] s = st.toCharArray();
		int[] next = new int[s.length];
		next[0] = -1;   //��ʼֵ  -1��ʼ����Ϊ������±��Ǵ�0��ʼ
		int j = 0;
		int k = -1;  //��ʼֵ
		while(j<s.length-1) {
			if(k == -1 || s[j]==s[k]) {
				next[++j] = ++k;
			}else {
				k = next[k];
			}
		}
		return next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ss= "ababcabcacbab";
		String st = "abcac";
		String s = "abaabcac";
		System.out.println(simplicity(ss,st));
//		System.out.println(Arrays.toString(get_next(s)));
		System.out.println(KMP(ss,st));
		
	}

}
