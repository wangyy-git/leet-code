package com.wangyy.ltd.leetcodeproblems.easy;

public class AddBinary_67 {

    public static void main(String[] args) {
        System.out.println(addBinary("111","111"));
    }

    public static String addBinary(String a, String b) {
//        StringBuilder sb = new StringBuilder();
//        int i = 0;String aChar = null,bChar = null;
//        String carry = null;
//        while (i<a.length() || i<b.length()){
//            if (i < a.length()) aChar = a.substring(i,i+1);
//            if (i < b.length()) bChar = b.substring(i,i+1);
//            if ("1".equals(aChar) && "1".equals(bChar))
//        }
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }
}
