package com.wanyy.ltd.datastructure.dataStru.search;

import java.util.Arrays;

/**
 * 同二分查找，只是更改了middle的位置，是其位于黄金分割的位置：
 * middle=low+F(k-1)-1; F(k-1) - 表示斐波那契数列
 */
public class FibonacciSearch {

    private static final int fiboSize = 20;
    public static void main(String[] args) {
        int[] array = {1,3,3,3,3,4,5,7,8,9,11,13};
        int find = 11;
        System.out.println(fiboSearch(array,find));
    }
    
    private static int[] fibo(){
        int[] fibo = new int[fiboSize];
        fibo[0] = 1;
        fibo[1] = 1;

        for (int i = 2; i < fiboSize; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
        }
        
        return fibo;
    }
    
    private static int fiboSearch(int[] array,int key){
        int low = 0;int high = array.length - 1;
        int k = 0;int middle;
        int[] fibo = fibo();
        
        // 获取满足条件的斐波那契数列的下标
        // high <= fibo[k] -1 才满足条件找到下标
        while (high > fibo[k] -1){
            k++;
        }
        
        //因为fibo[k]的值可能大于array的长度，需要补长原有的array
        //不足的部分用0填充
        int[] temp = Arrays.copyOf(array,fibo[k]);
        for (int i = high+1;i<temp.length;i++){
            temp[i] = array[high];//用最大值来填充数组
        }
        
        //开始查找
        while (low <= high){
            middle = low + fibo[k-1] - 1;
            if (key < temp[middle]){
                high = middle - 1;
                //全部元素 = 前面的元素 + 后边元素
                //f[k] = f[k-1] + f[k-2]
                //因为 前面有 f[k-1]个元素,所以可以继续拆分 f[k-1] = f[k-2] + f[k-3]
                //即 在 f[k-1] 的前面继续查找 k--
                //即下次循环 mid = f[k-1-1]-1
                k--;
            } else if (key > temp[middle]) {
                low = middle + 1;
                //全部元素 = 前面的元素 + 后边元素
                //f[k] = f[k-1] + f[k-2]
                //因为后面我们有f[k-2] 所以可以继续拆分 f[k-1] = f[k-3] + f[k-4]
                //即在f[k-2] 的前面进行查找 k -=2
                //即下次循环 mid = f[k - 1 - 2] - 1
                k-=2;
            } else {
                //需要确定，返回的是哪个下标
                if(middle <= high) {
                    return middle;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
