package com.wanyy.ltd.datastructure.structure.recursion.puzzle;

import java.util.*;

public class Sudoku {

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        int[][] originSudoku = sudoku.generateOriginSudoku();
        
        sudoku.calSudoku(originSudoku);
    }

    //应该是当前行 列 方块不包含所有的候选值  且值不重复 且不为0
    //当前方格填入后  后面的方格没有合适的值 false
    //按照方格来计算
    public boolean calSudoku(int[][] sudoku){
        showSudoku(sudoku);
        for (int k = 0; k < 9; k++) {
            for (int l = 0; l < 9; l++) {
                if (sudoku[k][l] == 0){
                    int[] remainNum = getRemainNum(sudoku, k, l);
                    System.out.println("remainNum -> " + Arrays.toString(remainNum));
                    if (remainNum.length == 0){
                        return false;
                    }
                    for (int v:remainNum){
                        sudoku[k][l] = v;
                        System.out.println("=====================");
                        //可能是第一个值就让他return false了  应该一直算完
                        if(calSudoku(sudoku)){
                           break; 
                        } else {
                            System.out.printf("第%d行第%d列",k,l);
                            sudoku[k][l] = 0; //这样是无法回溯到最初始的位置 关键是回溯的思路
//                            return false;
                        }
                       
                    }
                }
            }
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
//        Scanner sc = new Scanner(System.in);
        String[] origin = new String[9];
//        origin[0] = "902183457";
//        origin[1] = "005209063";
//        origin[2] = "170460890";
//        origin[3] = "850020630";
//        origin[4] = "097604001";
//        origin[5] = "030050204";
//        origin[6] = "000010940";
//        origin[7] = "506302718";
//        origin[8] = "000000000";
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
//            System.out.printf("请输入%d行的值：",i+1);
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
