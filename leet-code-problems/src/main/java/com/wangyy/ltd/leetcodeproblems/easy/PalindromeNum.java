package com.wangyy.ltd.leetcodeproblems.easy;

/**
 * 判断是否是回文数
 */
public class PalindromeNum {
    public static void main(String[] args) {
        System.out.println(answer(112211));
    }

    public static boolean isPalindrome(int x) {
        int origin = x;
        if (x < 0) return false;
        int mold;
        long reverse = 0;
        while (x >= 10) {
            mold = x % 10;
            x = x / 10;
            reverse = reverse * 10 + mold;
        }
        reverse = reverse * 10 + x;
        
        return reverse == origin;
    }

    public static boolean answer(int x) {
        //思考：这里大家可以思考一下，为什么末尾为 0 就可以直接返回 false
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        //return对应奇偶两种位数情况
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
