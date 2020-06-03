package com.wanyy.ltd.datastructure.structure.recursion.puzzle;

import java.util.*;

public class Sudoku {

    public static void main(String[] args) {
        int[] remainNum = new int[9];
        Sudoku sudoku = new Sudoku();
        int[][] originSudoku = sudoku.generateOriginSudoku();
        
        sudoku.calSudoku(originSudoku);
    }

    //应该是当前行 列 方块不包含所有的候选值  且值不重复 且不为0
    //当前方格填入后  后面的方格没有合适的值 false
    //按照方格来计算
    //把赋值给回溯应该单独拆分成一个方法来实现
    public boolean calSudoku(int[][] sudoku){
        showSudoku(sudoku);
        int[] remainNum = null;
        int iPosition = 0;
        int jPosition = 0;
        boolean flag = false;//记录是否找到当前位置为0
        for (int k = 0; k < 9; k++) {
            for (int l = 0; l < 9; l++) {
                if (sudoku[k][l] == 0){
                    remainNum = getRemainNum(sudoku, k, l);
                    iPosition = k;
                    jPosition = l;
                    System.out.println("位置remainNum -> " + Arrays.toString(remainNum));
                    flag = true;
                    break;
                }
            }
            
            if (flag){
                System.out.println("找到位置");
//                flag = false;
                break;
            }
            
        }
        if (remainNum == null || remainNum.length == 0){
            return false;
        }
        
        if (iPosition == 8 && jPosition == 8 && sudoku[8][8] != 0){ //到最后一个位置且如果不为空 
            return true;
        }
        
        //觉得参考迷宫回溯问题  需要设置一个特殊的标志位  说明该数字是走不通的
        int remainIndex = 0;
        
//        while (remainIndex < remainNum.length){ }
        //开始赋值
        sudoku[iPosition][jPosition] = remainNum[remainIndex];
        remainIndex++;
        System.out.println("=====================");
        //可能是第一个值就让他return false了  应该一直算完
        //在这一步之前
        if(calSudoku(sudoku)){
            calSudoku(sudoku);
            return true;
        } else {
            System.out.printf("第%d行第%d列",iPosition,jPosition);
            sudoku[iPosition][jPosition] = 0; //回溯至最初的位置
            //所以回溯至此需要进行重新计算来保证方法的持续  问题是如何将源头候选值继续赋给
//              记录一个不受影响的初始位置 //关键就是在回溯到初始位置后不会再进入运算
            return false; //不return false就无法实现回溯
        }
    }
    
    
    private int[] getRemainNum(int[][] sudoku,int i,int j){
        Set<Integer> allNum = new HashSet<>();
        for (int s=0;s<=9;s++){
            allNum.add(s);
        }
        Set<Integer> haveNum = new HashSet<>();
        int[] row = sudoku[i]; //行
        for (int r:row){
            haveNum.add(r);
        }

        System.out.println("row -> " + Arrays.toString(row));
        int[] column = new int[9]; //列
        for (int m=0;m<9;m++){
            column[m] = sudoku[m][j];
            haveNum.add(sudoku[m][j]);
        }
        
        System.out.println("column -> " + Arrays.toString(column));
        
        int[] square = new int[9];
        int index = 0;
        //获取当前方格
        //开始的位置 (i/3)*3  结束位置 (i/3-1)*3-1 j一样
        for (int m=(i/3)*3;m<(i/3+1)*3;m++){
            for (int n=(j/3)*3;n<(j/3+1)*3;n++){
                square[index++] = sudoku[m][n];
                haveNum.add(sudoku[m][n]);
            }
        }
        System.out.println("square -> " + Arrays.toString(square));
        
        //获取候选数字
        allNum.removeAll(haveNum);
        int[] remain = new int[allNum.size()];
        int reIndex = 0;
        for (Integer integer : allNum) {
            remain[reIndex++] = integer;
        }
        
        return remain;
    }
    public int[][] generateOriginSudoku(){
        int[][] sudoku = new int[9][9];
        String[] origin = new String[9];
        origin[0] = "308000000";
        origin[1] = "000060009";
        origin[2] = "200000000";
        origin[3] = "000051600";
        origin[4] = "800000020";
        origin[5] = "000090000";
        origin[6] = "007300040";
        origin[7] = "000200000";
        origin[8] = "090000005";
        for (int i=0;i<9;i++){
            String next = origin[i];
            String[] split = next.split("");
            for (int n=0;n<9;n++){
                sudoku[i][n] = Integer.parseInt(split[n]);
            }
        }
        return sudoku;
    }
    public void showSudoku(int[][] mazeMap){
        for (int[] m:mazeMap){
            for (int v:m){
                System.out.print(v + "\t");
            }
            System.out.println();
        }
    }
}
