package com.wangyy.ltd.leetcodeproblems.easy;

import java.util.Arrays;

public class AddBinary_67 {

    public static void main(String[] args) {
       
        System.out.println(addBinary("1010","1011"));
        System.out.println(addBinary2("1010","1011"));
    }

    public static String addBinary(String a, String b) {
        System.out.println(Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2)));
        String[] strs1 = a.split("");
        String[] strs2 = b.split("");
        int maxLength = strs1.length >= strs2.length?strs1.length:strs2.length;
        String[] result = new String[maxLength];
        
        String carry = "0"; //进位
        for (int i = 0; i < maxLength; i++) {
            //计算逻辑
            String s1;
            if(i < strs1.length) s1 = strs1[strs1.length - i - 1];
            else s1 = "0";

            String s2;
            if(i < strs2.length) s2 = strs2[strs2.length - i - 1];
            else s2 = "0";
            
            String re = carry + s1 + s2;
            switch (re) {
                case "111":
                    carry = "1";
                    result[maxLength-i-1] = "1";
                    break;
                case "110":
                case "011":
                case "101":
                    carry = "1";
                    result[maxLength-i-1] = "0";
                    break;
                case "100":
                case "010":
                case "001":
                    carry = "0";
                    result[maxLength-i-1] = "1";
                    break;
                default:
                    carry = "0";
                    result[maxLength-i-1] = "0";
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (carry.equals("1")) sb.append("1");
//        if (carry.equals("0")) s = s.substring(1);
        for (String s : result) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static String addBinary2(String a, String b) {
        String[] strs1 = a.split("");
        String[] strs2 = b.split("");
        int maxLength = strs1.length >= strs2.length?strs1.length:strs2.length;
        
        StringBuilder str = new StringBuilder();
        String carry = "0"; //进位
        for (int i = 0; i < maxLength; i++) {
            //计算逻辑
            String s1;
            if(i < strs1.length) s1 = strs1[strs1.length - i - 1];
            else s1 = "0";

            String s2;
            if(i < strs2.length) s2 = strs2[strs2.length - i - 1];
            else s2 = "0";

            String re = carry + s1 + s2;
            switch (re) {
                case "111":
                    carry = "1";
                    str.insert(0, "1");
                    break;
                case "110":
                case "011":
                case "101":
                    carry = "1";
                    str.insert(0, "0");
                    break;
                case "100":
                case "010":
                case "001":
                    carry = "0";
                    str.insert(0, "1");
                    break;
                default:
                    carry = "0";
                    str.insert(0, "0");
                    break;
            }
        }
        if (carry.equals("1")) str.insert(0, "1");

        return str.toString();
    }
}
