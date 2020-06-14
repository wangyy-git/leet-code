package com.wanyy.ltd.datastructure.dataStru.structure.array;

import java.util.Arrays;

/**
 * 稀疏数组
 */
public class SparseArray {
    public static void main(String[] args) {
        int[][] sparse = new int[9][3];
        sparse[0][0] = 6;
        sparse[0][1] = 7;
        sparse[0][2] = 8;
        sparse[1][0] = 0;
        sparse[1][1] = 3;
        sparse[1][2] = 22;
        sparse[2][0] = 0;
        sparse[2][1] = 6;
        sparse[2][2] = 15;
        sparse[3][0] = 1;
        sparse[3][1] = 1;
        sparse[3][2] = 11;
        sparse[4][0] = 1;
        sparse[4][1] = 5;
        sparse[4][2] = 17;

        int[][] originArray = toOriginArray(sparse);
        System.out.println("---------------------------");
        int[][] sparseArray = toSparseArray(originArray);
        
        for (int[] s:sparseArray){
            System.out.println(Arrays.toString(s));
        }

    }
    
    private static int[][] toOriginArray(int [][] sparseArray){
        
        int[][] origin = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i=1;i<sparseArray.length;i++){
            int[] coloumn = sparseArray[i];
            origin[coloumn[0]][coloumn[1]] = coloumn[2];
        }
        
        for (int[] row:origin){
            for (int v:row){
                System.out.print(v + "\t");
            }
            System.out.println();
        }
        
        return origin;
    }

    private static int[][] toSparseArray(int[][] originArray){
        int sum = 0;
        for (int[] col:originArray){
            for (int v:col){
                if (v != 0){
                    sum++;
                }
            }
        }
        int[][] sparseArray = new int[sum+1][3];

        sparseArray[0][0] = originArray.length;
        sparseArray[0][1] = originArray[0].length;
        sparseArray[0][2] = sum;

        int row=0;//sparseArray的第一个下标
//        int col=0;//sparseArray的第一个下标
        for (int i=0;i<originArray.length;i++){
//            row++; //因为第0 0 位置已经被赋值
//            col = 1;
            for (int j=0;j<originArray[i].length;j++){
                int value = originArray[i][j];
                if (value != 0){
                    row++; //注意row的位置
                    sparseArray[row][0] = i;
                    sparseArray[row][1] = j;
                    sparseArray[row][2] = value;
                }
            }
            
        }
        return sparseArray;
    }
}
