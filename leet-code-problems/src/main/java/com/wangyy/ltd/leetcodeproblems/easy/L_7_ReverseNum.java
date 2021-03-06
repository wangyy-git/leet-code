package com.wangyy.ltd.leetcodeproblems.easy;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * 输入: 123   输出: 321
 * 示例 2:
 * 输入: -123  输出: -321
 * 示例 3:
 * 输入: 120   输出: 21
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class L_7_ReverseNum {
    public static void main(String[] args) {
        System.out.println(reverseNum(Integer.MAX_VALUE));
    }
    
    
    private static int reverseNum(int x){
        System.out.println("x -> " + x);
        int mold;
        long reverse = 0;
        while (x >= 10 || x <= -10) {
            mold = x % 10;
            x = x / 10;
            reverse = reverse * 10 + mold;
        }
        reverse = reverse * 10 + x;

        if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) return 0;
        return (int)reverse;
    }
}
