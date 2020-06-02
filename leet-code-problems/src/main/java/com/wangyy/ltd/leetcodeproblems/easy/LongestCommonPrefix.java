package com.wangyy.ltd.leetcodeproblems.easy;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"d"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String str = strs[0];
        String prefix = null;
        for (int i = 0; i < str.length(); i++) {
            prefix = str.substring(0, i + 1);
            for (int j = 1; j < strs.length; j++){
                if (!strs[j].startsWith(prefix)){
                    return prefix.substring(0,prefix.length()-1);
                }
                
            }
            
        }

        return prefix == null?"":prefix;
    }
    
    //可以使用二分查找法增加效率
}
