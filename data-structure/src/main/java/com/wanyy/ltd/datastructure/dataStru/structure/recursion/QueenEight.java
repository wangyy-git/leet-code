package com.wanyy.ltd.datastructure.dataStru.structure.recursion;

/**
 * 八皇后问题
 */
public class QueenEight {
    public static void main(String[] args) {
        QueenEight queen = new QueenEight();
        queen.check(0); //相当于放置第一个皇后
    }
    
    private final static int max = 8; //定义max 表示几个皇后
    //定义数组表示最后保存的位置
    private final static int[] array = new int[max];

    /**
     * 放置对应的皇后
     * @param n 放置第n+个皇后  但是n是从0开始的
     */
    private void check(int n){
        if (n == max){ //表示当前所有的都已放置完成
            print();
            return;
        }

        for (int i = 0; i < max; i++) {
            //先把当前这个皇后放置在第一列  依次往后试
            array[n] = i; //注意此处表示位置所处行数的 n 是没有变化的  变化的是对应列位置 i
            if (judge(n)){ //judge不冲突返回true
                //接着放n+1个皇后
                check(n+1);
            }
            //如果冲突了 继续执行了array[n] = i相当于此时将列位置移动了1
        }
    }

    /**
     * 检测当前皇后的放置位置与之前的是否有冲突
     * @param n 表示第n个皇后
     * @return  当前位置是否合适
     */
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //用一维数组因为必然不会是在同一行 array[i]对应的就是所在当前行的列数
            //所以array[i]==array[n] 表示放在同一列了  不对
            //Math.abs(n-i) == Math.abs(array[n]-array[i]) 正方形对角线 结合理解
            if (array[i]==array[n]
            || Math.abs(n-i) == Math.abs(array[n]-array[i])){
                return false;
            }
        }
        
        return true;
    }
    
    private void print(){
        System.out.print("放置位置(额外jia了1)：");
        for (int i:array){
            System.out.print((i+1) + "\t");
        }
        System.out.println();
    }
}
