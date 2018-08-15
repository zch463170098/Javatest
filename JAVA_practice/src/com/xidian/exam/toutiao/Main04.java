package com.xidian.exam.toutiao;

import java.util.Scanner;

public class Main04 {
    public static void main(String[] args) {
    	
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        
        for(int i = 0; i < n; i++){
            a[i]=scanner.nextInt();
        }
        
        for(int i = 0; i < n; i++){
            b[i]=scanner.nextInt();
        }
        
        int count=0;
        
        for(int l = 0; l < n; l++){
            int amax=a[l];
            int bmin=b[l];
            for(int r = l; r < n; r++){
                if(amax<a[r])
                    amax=a[r];
                if(bmin>b[r])
                    bmin=b[r];
                if(amax<bmin){
                    count++;
                }
                else {
                    break;
                }
            }
        }
        
        System.out.println(count);
    }

}
