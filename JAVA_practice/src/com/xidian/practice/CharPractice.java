package com.xidian.practice;
import java.util.Arrays;

/**
 * @author Zhang Chenghui
 * E-mail: 463170098@qq.com
 * @version 1.0 
 * ����ʱ�䣺2017��11��16�� ����11:40:56
 * ˵����
 */
public class CharPractice {
	public static void main(String[] args){
		String AAID = "0001#2121";
		String[] AAIDs = {"0001#2121","0002#2121"};
		int[] att = {12345,1234,1345};
	    int attTest =12345;
		char[] mVendorID = new char[4];
		AAID.getChars(0, 4, mVendorID, 0);
		System.out.println(String.valueOf(mVendorID));
		if(AAID.contains(String.valueOf(mVendorID))){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
		
		for(int i =0;i<AAIDs.length;i++){
			if(AAID.equals(AAIDs[i])){
				System.out.println("matched");
				break;
			}
		}
		 Transaction transaction = new Transaction();
		 Transaction[] transactions = new Transaction[1];
//		 String contentType = "text/plain";
//	     transaction[0].contentType = contentType;
//	     transaction[0].content = "this is a transcation demo";
		 transactions[0] = transaction;
	     System.out.println(transactions[0].contentType);

		
	}


}

