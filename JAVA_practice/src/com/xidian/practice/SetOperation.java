package com.xidian.practice;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

public class SetOperation {

	public static <E> void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner  = new Scanner(System.in);
	
		while(scanner.hasNext()) {
			int size1 = 0,size2 = 0;
			size1 = scanner.nextInt();
			size2 = scanner.nextInt();
			Set<Integer> set3 = new TreeSet<Integer>();
			for(int i =0;i<(size1+size2);i++) {
				set3.add(scanner.nextInt());
			}
		
			for(Iterator<Integer> it = set3.iterator();it.hasNext();) {
				System.out.println(it.next()+" ");
			}
		
		}
		scanner.close();
        
	}

}
