package com.wanyy.ltd.datastructure.structure.recursion.puzzle;

/**
 * 参考八皇后问题来解决
 * 横的叫行 row 竖的叫列 column
 */
public class NewSudoku {
    public static void main(String[] args) {
        NewSudoku sudoku = new NewSudoku();
        sudoku.generateOriginSudoku();
        sudoku.showSudoku();
//        sudoku.cal(1);
        System.out.println("==================");
        sudoku.showSudoku();
    }
    
    private final static int ROW_COLUMN_NUM = 9;
    private final static int[][] sudokuArray = new int[ROW_COLUMN_NUM][ROW_COLUMN_NUM];
    
    private void cal(int row,int column,int value){
        if (value > 9){
            return;
        }
        if (judge(row, column, value)){
            sudokuArray[row][column] = value;
        } else {
            cal(row, column, value++);
        }
        
    }
    //其实这里等同于获取可选数字为0个应为会存在所有数字都不合适则向前回溯
    //但judge方法仅判断当前这个数字是否合适
    private boolean judge(int row,int column,int value){
//        System.out.println(sudokuArray[row][column]);
        //当前位置不为0 直接return false；
        if (sudokuArray[row][column] != 0){
            return false;
        }
        //获取判断当前行是否合适
        int[] rowArray = sudokuArray[row]; 
        for (int r:rowArray){
            if (r == value){
                return false;
            }
        }

        //校验当前列是否合适
        for (int i = 0; i < ROW_COLUMN_NUM; i++) {
            int colNum = sudokuArray[i][column];
            if (colNum == value){
                return false;
            }
        }
        
        //判断所在方块
        for (int m=(row/3)*3;m<(row/3+1)*3;m++){
            for (int n=(column/3)*3;n<(column/3+1)*3;n++){
                if (sudokuArray[m][n] == value){
                    return false;
                }
            }
        }
        
        return true;
    }

    public void generateOriginSudoku(){
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
                sudokuArray[i][n] = Integer.parseInt(split[n]);
            }
        }
    }


    public void showSudoku(){
        for (int[] m:sudokuArray){
            for (int v:m){
                System.out.print(v + "\t");
            }
            System.out.println();
        }
    }
}
