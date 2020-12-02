package com.wangyy.ltd.leetcodeproblems.easy;

import java.util.ArrayList;
import java.util.Arrays;
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

class Fibo{
    public static void main(String[] args) {
        int[] array = new int[]{2,5,7,3,4,1,9};
        sort(array);
        System.out.println(fibo2(200));
    }
    
    
    public static int fibo(int n){
        if (n == 1 || n == 2) return 1;
        return fibo(n-1) + fibo(n-2);
    }

    public static int fibo2(int n){
        int[] array = new int[n];
        if (n >= 2) {
            array[0] = 1;
            array[1] = 1;
        }
        for (int i=2;i<n;i++){
            array[i] = array[i-1] + array[i-2];
        }
        return n>=2?array[n-1]:1;
    }

    public static void sort(int[] array){
        
        int length = array.length;
        for (int i = 0;i<length;i++){
            for (int j = i; j < length; j++) {
               if (array[i] < array [j]){
                   int temp = array[i];
                   array[i] = array[j];
                   array[j] = temp;
               }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
