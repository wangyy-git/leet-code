package com.wanyy.ltd.datastructure.sort;

import java.util.Arrays;

/**
 * 归并排序是利用归并的思想实现的排序方法，采用了分治策略(divide-and-conquer)策略；
 * 分治法是问题分divide成一些小问题，然后递归求解，而治conquer的阶段则是将分的阶段得到的各答案修补在一起，即分而治之；
 */
public class MergeSort {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int length = 8;
        int[] array = new int[length];
        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int)(Math.random()*length*10);
        }
        System.out.println(Arrays.toString(array));
        mergeSort(array,0,array.length-1,temp);
        System.out.println(Arrays.toString(array));
//        quick(array,0,array.length-1);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void mergeSort(int[] array,int left,int right,int[] temp){
        if (left < right){
            int middle = (left+right)/2;
            //向左递归拆解
            mergeSort(array,left,middle,temp);
            //向右递归拆解
            mergeSort(array,middle+1,right,temp);
            
            //合并
            merge(array,left,middle,right,temp);
        }
    }
    /**
     * 先写归并的方法 先写治
     * @param array     待排序数组
     * @param left      左边有序数列的初始索引
     * @param middle    中间位置
     * @param right     右边有序数列的最右侧索引
     * @param temp      临时数组 搬到这里
     */
    private static void merge(int[] array,int left,int middle,int right,int[] temp){
        int i =left;
        int j = middle + 1; //右边的起始索引
        int t = 0;//temp的索引记录
        
        /* 第一步
         * 先把左右两边(已经有序)的数组按照规则填充到temp数组
         * 直到左右两边其中一边移动完成 (则另一边剩余的也是有序排列的)
         */
        while (i<=middle && j <= right){
            if (array[i] <= array[j]){
                //只用搬就行
                temp[t] = array[i];
                t+= 1;
                i+= 1;
            } else {
                temp[t] = array[j];
                t+= 1;
                j+= 1;
            }
        }

        /* 第二步
         * 左边有剩余
         */
        while (i<=middle){
            temp[t] = array[i];
            t+= 1;
            i+= 1;
        }
        /* 第二步
         * 或者右边有剩余
         */
        while (j<=right){
            temp[t] = array[j];
            t+= 1;
            j+= 1;
        }
        /* 第三步
         * 将temp copy到array
         * 注意 此处并不是全部都需要copy
         */
        t=0;
        int tempLeft = left;
        while (tempLeft < right){
            array[tempLeft] = temp[t];
            t+= 1;
            tempLeft+= 1;
        }
        
        
        
    }
}
