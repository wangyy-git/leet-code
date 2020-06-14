package com.wanyy.ltd.datastructure.dataStru.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 前提数组必然有序：
 * 下面的思路是从小到大排序；反之相反；
 * 1、	首先确定数组中间的下标mid=(left+right)/2；
 * 2、	然后对比待查找的值findVal与array[mid]的大小比较：
 * 2.1. findVal > array[mid]，说明要往右边找；
 * 2.2. findVal < array[mid]，说明要往左边找；
 * 2.3. findVal = array[mid]，查找；
 * 3、	递归的结束条件：
 * 3.1.	找到了对应的值；
 * 3.2.	未找到：则left > right退出；
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {1,3,3,3,3,4,5,7,8,9,11,13};
        int find = 1;
        System.out.println(binary(array,0,array.length-1,find));

        System.out.println(fiandAll(array,0,array.length-1,find).toString());
    }
    
    //从小到大排序
    private static int binary(int[] array, int left, int right, int find) {
        int middle = (left + right) / 2;
        if (left > right) {
            return -1;
        }
        //对left和right值要做相应的移动
        //因为middle已经参与过比较，所以不需要重复，对其+-1即可
        if (array[middle] == find) {
            return middle;
        } else if (array[middle] > find) {
            return binary(array, left, middle-1, find);
        } else {
            return binary(array, middle+1, right, find);
        }
        
    }

    /**
     * 找到所有满足条件的值
     * 找到后想左/右分别进行扫描，满足则加入下标
     */
    private static List<Integer> fiandAll(int[] array, int left, int right, int find){
        System.out.println("查找...");
        List<Integer> indeies = new ArrayList<>();
        int middle = (left + right) / 2;
        if (left > right) {
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
