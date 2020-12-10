package com.wangyy.ltd.leetcodeproblems.easy;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */

public class L_66_PlusOne {

    public static void main(String[] args) {
        System.out.println(10 % 10);
        int[] digits = {9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
    
    //考虑进位的情况 
    //加入直接相加  是不行的  会溢出
    private static int[] plusOne(int[] digits){
        int sum = digits[digits.length -1] + 1;
        if (sum < 10){
            digits[digits.length -1] = sum;
            return digits;
        }
        if (digits.length == 1 && digits[0] == 9) return new int[]{1,0};
        for (int i = digits.length -2; i >= 0; i--) {
//            sum = digits[i] + 1;
            int div = sum / 10;
            if (div > 0){
                digits[i+1] = sum % 10;
                sum = digits[i] + sum/10;
                digits[i] = sum;
            }
        }
        if (sum>9){
            int[] result = new int[digits.length+1];
            result[0] = sum / 10;
            for (int i = 0; i < digits.length; i++) {
                result[i+1] = digits[i]%10;
            }
            
            return result;
        }
        return digits;
    }

    public static int[] answer(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        //注意其实只有全是9 才能走到这一步  这样必然是1 后面全是0
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
