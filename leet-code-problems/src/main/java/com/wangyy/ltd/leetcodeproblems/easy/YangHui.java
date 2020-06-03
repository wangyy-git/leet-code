package com.wangyy.ltd.leetcodeproblems.easy;

import java.util.ArrayList;
import java.util.List;

public class YangHui {

    public static void main(String[] args) {
        
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i=2;i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            List<Integer> integerList = result.get(i - 1);
            
//            for (int j=0;j<integerList.size()+1;j++){
//                integerList.get(j)
//            }

        }
        
        return result;
    }
}
