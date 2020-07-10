package com.wangyy.ltd.leetcodeproblems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome_5 {
    public static void main(String[] args) {
        String s = "a";
//        System.out.println(longestPalindrome(s));
        LongestPalindrome_5 lo = new LongestPalindrome_5();
        System.out.println(lo.longestPalindrome(s));
    }

    //可以优化一下 只记录index begin end
    int longestLength = 0; //记录上一次的index
    String result;
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        int length = s.length();
        String[] split = s.split("");
        for (int i = (length%2==0?length/2:length/2+1); i >= longestLength/2; i--) {
            find(i, split);
        }

        for (int i = (length%2==0?length/2:length/2+1); i < length - longestLength/2; i++) {
            find(i, split);
        }
        return result;
    }
    
    
    private void find(int i,String[] split){
        int length = split.length;
        //往右移
        if (i+1 < length && split[i+1].equals(split[i])){
            StringBuilder sb = new StringBuilder();
            int index = 0;
            sb.append(split[i-index]).append(split[i+index+1]);
            while (true){
                index++;
                if (i + index + 1 == length || i - index < 0) {
                    if (longestLength < sb.length()){
                        longestLength = sb.length();
                        result = sb.toString();
                    }
                    break;
                }
                String rc = split[i + index + 1];//右侧的char
                String lc = split[i - index];//左侧

                if (rc.equals(lc)){
                    sb = (new StringBuilder(lc)).append(sb).append(rc);
                } else {
                    if (longestLength < sb.length()){
                        longestLength = sb.length();
                        result = sb.toString();
                    }
                    break;
                }
            }
        }

        if (i >= 1 && split[i-1].equals(split[i])){
            StringBuilder sb = new StringBuilder();
            int index = 0;
            //i+index-1 往左移 i-index 往右 index<0
            sb.append(split[i+index-1]).append(split[i-index]);
            while (true){
                index--;
                if (i + index - 1 < 0 || i-index == length) {
                    if (longestLength < sb.length()){
                        longestLength = sb.length();
                        result = sb.toString();
                    }
                    break;
                }
                String lc = split[i + index - 1];//左侧的char
                String rc = split[i - index];//right
                if (rc.equals(lc)){
                    sb = (new StringBuilder(lc)).append(sb).append(rc);
                } else {
                    if (longestLength < sb.length()){
                        longestLength = sb.length();
                        result = sb.toString();
                    }
                    break;
                }
            }
        }
        //最后一种情况
        StringBuilder sb = new StringBuilder();
        int index = 0;
        sb.append(split[i]);
        //这个地方还是要记录一下lastIndex
        while (true){
            index++;
            if (i + index == length || i-index < 0) {
                if (longestLength < sb.length()){
                    longestLength = sb.length();
                    result = sb.toString();
                }
                break;
            }
            String rc = split[i + index];//右侧的char
            String lc = split[i - index];//左侧
            if (rc.equals(lc)){
                sb = (new StringBuilder(lc)).append(sb).append(rc);
            } else {
                if (longestLength < sb.length()){
                    longestLength = sb.length();
                    result = sb.toString();
                }
                break;
            }
        }
        
    }

    private void find2(int i,String[] split){
        int length = split.length;
        //往右移
        if (i+1 < length && split[i+1].equals(split[i])){
            StringBuilder sb = new StringBuilder();
            int index = 0;
            sb.append(split[i-index]).append(split[i+index+1]);
            while (true){
                index++;
                if (i + index + 1 == length || i - index < 0) {
                    if (longestLength < sb.length()){
                        longestLength = sb.length();
                        result = sb.toString();
                    }
                    break;
                }
                String rc = split[i + index + 1];//右侧的char
                String lc = split[i - index];//左侧

                if (rc.equals(lc)){
                    sb = (new StringBuilder(lc)).append(sb).append(rc);
                } else {
                    if (longestLength < sb.length()){
                        longestLength = sb.length();
                        result = sb.toString();
                    }
                    break;
                }
            }
        }

        if (i >= 1 && split[i-1].equals(split[i])){
            StringBuilder sb = new StringBuilder();
            int index = 0;
            //i+index-1 往左移 i-index 往右 index<0
            sb.append(split[i+index-1]).append(split[i-index]);
            while (true){
                index--;
                if (i + index - 1 < 0 || i-index == length) {
                    if (longestLength < sb.length()){
                        longestLength = sb.length();
                        result = sb.toString();
                    }
                    break;
                }
                String lc = split[i + index - 1];//左侧的char
                String rc = split[i - index];//right
                if (rc.equals(lc)){
                    sb = (new StringBuilder(lc)).append(sb).append(rc);
                } else {
                    if (longestLength < sb.length()){
                        longestLength = sb.length();
                        result = sb.toString();
                    }
                    break;
                }
            }
        }
        //最后一种情况
        StringBuilder sb = new StringBuilder();
        int index = 0;
        sb.append(split[i]);
        //这个地方还是要记录一下lastIndex
        while (true){
            index++;
            if (i + index == length || i-index < 0) {
                if (longestLength < sb.length()){
                    longestLength = sb.length();
                    result = sb.toString();
                }
                break;
            }
            String rc = split[i + index];//右侧的char
            String lc = split[i - index];//左侧
            if (rc.equals(lc)){
                sb = (new StringBuilder(lc)).append(sb).append(rc);
            } else {
                if (longestLength < sb.length()){
                    longestLength = sb.length();
                    result = sb.toString();
                }
                break;
            }
        }

    }
}
