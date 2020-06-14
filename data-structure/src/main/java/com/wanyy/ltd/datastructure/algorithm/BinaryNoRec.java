package com.wanyy.ltd.datastructure.algorithm;

/**
 * 非递归二分查找
 */
public class BinaryNoRec {
    public static void main(String[] args) {
        int[] array = {1,2,3,5,6,7};
        System.out.println(binarySearch(array,6));
    }
    
    //array升序排列
    public static int binarySearch(int[] array,int value){
        
        int left = 0;
        int right = array.length - 1;
        while (left <= right){
            int middle = (left + right) / 2;
            if (array[middle] == value){
                return middle;
            } else if (array[middle] < value){
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
