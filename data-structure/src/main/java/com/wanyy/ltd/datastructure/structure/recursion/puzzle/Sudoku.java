package com.wanyy.ltd.datastructure.structure.recursion.puzzle;

import java.util.*;

public class Sudoku {

    public static void main(String[] args) {
        Set<Integer> allNum = new HashSet<>();
        for (int s=0;s<=9;s++){
            allNum.add(s);
        }
        Set<Integer> haveNum = new HashSet<>();
        for (int s=0;s<=9;s=s+2){
            haveNum.add(s);
        }
        System.out.println(haveNum);
        allNum.removeAll(haveNum);

        System.out.println(allNum);
        Sudoku sudoku = new Sudoku();
        int[][] originSudoku = sudoku.generateOriginSudoku();
        sudoku.showSudoku(originSudoku);
//        for (int i=0;i<9;i++){
//            for (int j=0;j<9;j++){
//                if (originSudoku[i][j] == 0){
//                    sudoku.calSudoku(originSudoku,i,j);
//                }
//            }
//        }
    }

    //应该是当前行 列 方块不包含所有的候选值  且值不重复 且不为0
    //当前方格填入后  后面的方格没有合适的值 false
    public boolean calSudoku(int[][] sudoku,int i,int j){
        if (sudoku[i][j] != 0){
            return true;
        } else if(sudoku[i][j] == 0){ //此处需要计算
            
            
            return false;
        }
        
        return true;
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
        Scanner sc = new Scanner(System.in);
        for (int i=0;i<9;i++){
            System.out.printf("请输入%d行的值：",i+1);
            String next = sc.next();
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
