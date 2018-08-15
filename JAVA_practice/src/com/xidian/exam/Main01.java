package com.xidian.exam;
import java.util.ArrayList;
import java.util.Scanner;

public class Main01 {
	

	public static int deleteNumber(ArrayList<Integer> arrays){
		int count = 0;
		int min = 0;
		int minIndex = 0;
		int max = 0;
		int maxIndex = 0;
		while(arrays.size()!=0){
			min = max = arrays.get(0);
			minIndex = maxIndex = 0;
			for(int i = 0;i<arrays.size();i++){
				if(arrays.get(i)<min){
					min = arrays.get(i);
					minIndex = i;
				}else if(arrays.get(i)>max){
					max = arrays.get(i);
					maxIndex = i;
				}
			}
			
			if(minIndex<maxIndex){
				arrays.remove(minIndex);
//				if(arrays.size()==0){
//					return count++;
//				}
				for(int i = minIndex;i<arrays.size();i++){
					if(arrays.get(i)>min){
						arrays.remove(i);	
						i--;
					}
				}
			}else if(minIndex>maxIndex){
				arrays.remove(maxIndex);
//				if(arrays.size()==0){
//					return count++;
//				}
				for(int i = maxIndex;i<arrays.size();i++){
					if(arrays.get(i)<max){
						arrays.remove(i);
						i--;
					}
				}
			}else{
				arrays.remove(minIndex);
			}
			count++;
			
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		ArrayList<Integer> arrays = new ArrayList<>();
		for(int i = 0;i<num;i++){
			arrays.add(scanner.nextInt());	
		}
		scanner.close();
		
		System.out.println(deleteNumber(arrays));

	}

}
