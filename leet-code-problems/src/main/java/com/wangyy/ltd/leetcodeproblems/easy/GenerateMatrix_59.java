package com.wangyy.ltd.leetcodeproblems.easy;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class GenerateMatrix_59 {

    public static void main(String[] args) {
        int[][] ints = generateMatrix(7);
        for (int[] a:ints){
            for (int num:a){
                System.out.printf("%d\t",num);
            }
            System.out.println();
        }
    }

    //右 下 左 上 一次循环
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int value = 1;
        int left=0,right=n-1,top=0,bottom=n- 1;
        while (value <= n*n){
            for (int i = left; i <= right; i++) { matrix[top][i] = value++;} //l->r
            top++;
            for (int j = top;j<=bottom;j++){ matrix[j][right] = value++;} //t -> b
            right--;
            for (int m = right; m >= left; m--) { matrix[bottom][m] = value++; } //r->l
            bottom--;
            for (int k = bottom; k >= top; k--) { matrix[k][left] = value++; } //b -> t
            left++;
//            value++;
        }
        
        return matrix;
    }
}
