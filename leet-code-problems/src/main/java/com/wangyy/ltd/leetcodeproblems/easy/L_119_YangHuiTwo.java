package com.wangyy.ltd.leetcodeproblems.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 */
public class L_119_YangHuiTwo {

    public static void main(String[] args) {
        getRow(0).forEach(l -> System.out.print(l + " - "));
    }

    public static List<Integer> getRow(int rowIndex) {
        
        List<List<Integer>> yang = new ArrayList<>();
        if (rowIndex >= 0) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            yang.add(list);
        }

        if (rowIndex >= 1) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(1);
            yang.add(list);
        }

        for (int i = 2; i <= rowIndex; i++) {
            List<Integer> list = yang.get(i-1);
            List<Integer> nextRow = new ArrayList<>();
            nextRow.add(1);
            for (int j = 0; j < list.size()-1; j++){
                int next = list.get(j) + list.get(j+1);
                nextRow.add(next);
            }
            nextRow.add(1);
            yang.add(nextRow);
        }
        return yang.get(rowIndex);
    }
    
//    public static List<Integer> yang(int rowIndex){
//        
//    }
}
