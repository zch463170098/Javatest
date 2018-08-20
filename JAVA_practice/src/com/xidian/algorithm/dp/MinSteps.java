package com.xidian.algorithm.dp;

/**
 * ��̬�滮
2  * ����һ������m�������Ͻǿ�ʼÿ��ֻ�������߻���������
3  * ���ﵽ���½ǵ�λ�ã�·�������������ۼ���������·���ͣ�
4  * ��������·������С·����
5  */
public class MinSteps {
    
    public static int[][] steps=new int[4][4];
    
    public static void main(String[] args) {
        int[][] arr = {{4,1,5,3},{3,2,7,7},{6,5,2,8},{8,9,4,5}};
        steps[3][3] = minSteps(arr, 3, 3);
        print(steps);
    }
    
    
    public static int minSteps(int[][] arr,int row,int col){
        //���Ϊ��ʼλ�ã���ֱ�ӷ���
        if(row==0&&col==0){
            steps[row][col] = arr[row][col];
            return steps[row][col];
        }
        
        //���㵽arr[row][col]������λ�õ�ֵ
        if(col>=1&&steps[row][col-1]==0){
            steps[row][col-1]=minSteps(arr, row, col-1);
        }
        //���㵽arr[row][col]������λ�õ�ֵ
        if(row>=1&&steps[row-1][col]==0){
            steps[row-1][col]=minSteps(arr, row-1, col);
        }
        //���Ϊ��һ�У���ֱ�Ӽ�����λ���ϵ�ֵ
        if(row==0&&col!=0){
            steps[row][col] = arr[row][col]+steps[row][col-1];
        }else if(col == 0&&row!=0){
            //���Ϊ��һ�У���ֱ�Ӽ�������λ���ϵ�ֵ
            steps[row][col] = arr[row][col]+steps[row-1][col];
        }else{
            //�Ƚϵ�������λ�ú͵�������λ�õ�ֵ�Ĵ�С���������ߵ����ֵ
            steps[row][col] =arr[row][col]+min(steps[row][col-1],steps[row-1][col]);
        }
        return steps[row][col];
    }
    
    private static int min(int minSteps, int minSteps2) {
        return minSteps>minSteps2?minSteps:minSteps2;
    }


    static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("����arr["+i+"]["+j+"]�����·����"+arr[i][j]);
            }
        }
    }
}