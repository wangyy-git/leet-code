package com.wangyy.ltd.leetcodeproblems.medium;

/**
 * 求 1+2+...+n 
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class SumNums {
    public static void main(String[] args) {
        System.out.println(sumNums(10));
    }

    public static int sumNums(int n) {
//        if (n == 1){
//            return n;
//        } else {
//            return n + sumNums(n-1);
//        }
        //简写
        return n == 1 ? 1 : n + sumNums(n-1);
    }
}
