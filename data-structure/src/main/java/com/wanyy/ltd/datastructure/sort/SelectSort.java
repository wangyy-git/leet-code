package com.wanyy.ltd.datastructure.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 选择排序是从欲排序的数据中，按照指定的规则选出某一元素，再依规定交换位置后达到排序的目的；
 * 基本思路：
 * n=arr.length
 * 第一次从arr[0]到arr[n-1]中选取最小值，与arr[0]进行交换；
 * 第二次从arr[1]到arr[n-1]中选取最小值，与arr[1]进行交换；
 * 依次类推...
 * 第n-1次从arr[n-2]到arr[n-1]中选取最小值，与arr[n-2]进行交换；
 * 总共n-1次；
 */
public class SelectSort {
    private static final int[] array = {12,2,4,3,7,11,6,8,5};

    public static void main(String[] args) {
        int length = array.length;
//        boolean flag = false;
        for (int i = 0; i < length; i++) {
            int min = array[i];
            int index = i;
            for (int j = i + 1; j < length; j++) {
                if (min > array[j]) {
//                    flag = true;
                    min = array[j];
                    index = j;
                }
            }

            if (index != i) {
                int temp = array[i];
                array[i] = min;
                array[index] = temp;
            }
            System.out.println(Arrays.toString(array));
        }

        System.out.println(Arrays.toString(array));
    }

    private void selectSort() {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    index = j;
                }
            }
            if (index != i) {
                int temp = array[i];
                array[i] = min;
                array[index] = temp;
            }
        }
    }
}
