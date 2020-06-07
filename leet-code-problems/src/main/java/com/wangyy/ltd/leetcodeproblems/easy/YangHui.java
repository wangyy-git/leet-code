package com.wangyy.ltd.leetcodeproblems.easy;

import java.util.ArrayList;
import java.util.List;

public class YangHui {

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(6);
        for (List<Integer> g:generate){
            System.out.println(g.toString());
        }
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (numRows < 1) return result;
        List<Integer> first = new ArrayList<>();
        first.add(1);
        List<Integer> second = new ArrayList<>();
        second.add(1);
        second.add(1);
        result.add(first);
        if (numRows == 1) {
            return result;
        }
        
        result.add(second);
        if (numRows == 2) return result;
        
        for (int i = 2;i<numRows;i++){
            List<Integer> preList = result.get(i - 1);
            List<Integer> now = new ArrayList<>();
            now.add(1);
            for (int j = 0; j < preList.size()-1; j++) {
                int value = preList.get(j) + preList.get(j + 1);
                now.add(value);
            }
            now.add(1);
            
            result.add(now);
        }
        return result;
    }
}
