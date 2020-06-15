package com.wangyy.ltd.leetcodeproblems.medium;

import java.util.*;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(isRepeat("pwwkew"));
        System.out.println(answer("pwwkew"));
        System.out.println(selfUnderStand("pww"));
        System.out.println(selfUnderStand("add"));
    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * 示例 1:
     * 输入: "abcabcbb"
     * 输出: 3 
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * ------------超时了-------------
     */
    private static int selfUnderStand(String s){
        if (s == null || s.isEmpty()){
            return 0;
        }
        //记录字符出现的下标
        int maxSize = 0;
        int start = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            //判断是否出现过  没有出现返回-1 出现过返回下标
            Integer hasRepeatIndex = map.getOrDefault(charAt, -1); 
            //可能整体没有重复过 一直都不进入
            //所有记录一个起始位置
            if (hasRepeatIndex >= start){
                int length = i - start;
                //需要记录一下最大的值
                maxSize = maxSize>length?maxSize:length;
                start = hasRepeatIndex + 1;
            }
            map.put(charAt,i);
        }
        maxSize = maxSize > s.length()-start?maxSize:s.length()-start;
        return maxSize;
    }
    private static int lengthOfLongestSubstring(String s){
        if (s == null || s.isEmpty()){
            return 0;
        }
        if (s.length() == 1){ 
            return 1;
        }
        List<Integer> lengths = new ArrayList<>();
        for (int i=0;i<s.length();i++){
            for (int j=1;j<s.length() -i+1;j++){
                String sub = s.substring(i, i + j);
                if (isRepeat(sub)){
                    break;
                } else {
                    lengths.add(sub.length());
                }
            }
        }
        lengths.sort((o1, o2) -> o2 - o1);
        return lengths.get(0);
    }
    private static boolean isRepeat(String str){
        char[] chars = str.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char ch:chars){
            if (list.contains(ch)){
                return true;
            }
            list.add(ch);
        }
        return false;
    }
    
    
    private static int answer(String s){
        if (s == null || s.length() == 0) {
            return 0;
        }

        int max = 0;

        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            Character cur = s.charAt(i);
            int index = map.getOrDefault(cur, -1);
            if (start <= index) { //说明字符没有出现过
                int curMax = i - start;
                max = max > curMax ? max : curMax;
                start = index + 1;
            }
            map.put(cur, i);
        }
        int endMax = s.length() - start;
        max = max > endMax ? max : endMax;
        return max;
    }
}
