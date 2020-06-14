package com.wanyy.ltd.datastructure.dataStru.search;

import java.util.ArrayList;
import java.util.List;

public class InsertSearch {

    public static void main(String[] args) {

        int[] array = {1,3,3,3,3,4,5,7,8,9,11,13};
        int find = 1;
        System.out.println(fiandAll(array,0,array.length-1,find));
    }

    private static List<Integer> fiandAll(int[] array, int left, int right, int find){
        System.out.println("查找...");
        List<Integer> indeies = new ArrayList<>();
        int middle = left + ((find-array[left])/(array[right] - array[left]))*(right-left);
        if (left > right || find < array[0] || find > array[array.length-1]) {
            return indeies;
        }
        //对left和right值要做相应的移动
        //因为middle已经参与过比较，所以不需要重复，对其+-1即可
        if (array[middle] == find) {

            int index = 1;
            while (middle-index>=0 && array[middle - index] == find) {
                indeies.add(middle - (index++));
            }
            indeies.add(middle);
            index = 1;
            while (middle+index<array.length && array[middle+index] == find) {
                indeies.add(middle + (index++));
            }
            return indeies;
        } else if (array[middle] > find) {
            return fiandAll(array, left, middle-1, find);
        } else {
            return fiandAll(array, middle+1, right, find);
        }
    }
    
}
