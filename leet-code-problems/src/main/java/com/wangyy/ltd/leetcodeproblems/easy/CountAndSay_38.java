package com.wangyy.ltd.leetcodeproblems.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountAndSay_38 {
    public static void main(String[] args) {
//        for (int i = 1; i < 11; i++) {
//            System.out.println(countAndSay(i));
//        }

        System.out.println("result --> " + countAndSayByMap(5));
    }

    public static String countAndSayByMap(int n){
        
        String result = "1";
        
        for (int i = 1; i < n; i++) {
            Map<String,Integer> map = new HashMap<>();
            String[] split = result.split("");
            for (String s:split){
                s = "s" + s;
                Integer orDefault = map.getOrDefault(s, -1);
                if (orDefault == -1) {
                    map.put(s,1);
                } else {
                    map.put(s,orDefault+1);
                }
            }

            Set<String> keySet = map.keySet();
            StringBuilder sb = new StringBuilder();
            for (String s:keySet){
                sb.append(map.get(s)).append(s.substring(1));
            }
            result = sb.toString();
            System.out.println(result);
        }
        return result;
    }
    public static String countAndSay(int n) {
        String result = "1";
        
        for (int i = 1; i < n; i++) {
            result = say(result);
        }
        
        return result;
    }
    
    public static String say(String str){
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        int i = 0;
        int j = 0;
        int num = 0;
        while (j<chars.length){
            if (chars[i] == chars[j]){
                j++;
                num++;
            } else {
                sb.append(num).append(chars[i]);
//                System.out.printf("%d个%s",num,chars[i]);
                i = j;
                num = 0;
            }
        }
        sb.append(j-i).append(chars[i]);
//        System.out.printf("%d个%s",j-i,chars[i]);
        return sb.toString();
    }
}
