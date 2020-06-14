package com.wanyy.ltd.datastructure.dataStru.tree;

import java.util.Arrays;

public class HeapSort {


    /**
     *         0 4
     *     1 6       2 8
     *  3 5     4 9
     */
    public static void main(String[] args) {
        int[] array = {4,6,8,5,9,1,11,2,33,45,55,67};
        //第一次调整
//        adjustHeap(array,1,array.length);
//        //第一次并未调整彻底 最顶元素还为更改
//        adjustHeap(array,0,array.length);
        //至此 再做调整

        heapSort(array);
        System.out.println(Arrays.toString(array));
        
    }

    public static void heapSort(int[] array){
        //将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for (int i=array.length/2-1;i>=0;i--){
            adjustHeap(array,i,array.length);
        }
        /*
         * 将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
         * 重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素
         * 反复执行调整+交换步骤，直到整个序列有序。
         */
        for (int j=array.length-1;j>0;j--){
            int temp = array[0];
            array[0] = array[j];
            array[j] = temp;
            adjustHeap(array,0,j);
        }
    }
    /**
     * 将以i为顶的对变成了大顶堆
     */
    public static void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i];
        //n=2*i+1 根据当前指定节点来判断其子节点 2*i+1 左子节点
        for (int n=2*i+1;n<length;n=n*2+1){
            //存在右子节点 且右>左 替换为右子节点
            if (n+1 < length && arr[n] < arr[n+1]){
                n++; //就让当前指向右子节点
            }
            if (arr[n] > temp){
                arr[i] = arr[n]; //大的值移到父节点
                i = n; //继续循环比较
            } else {
                break; //使用此处的前提就是他下面的节点都已经比较过了
            }
            arr[i] = temp;
        }
    }
    //递归计算 i--判断错误
    private static void heapSortRecur(int[] array,int length){
        if (length <= 2){
            return;
        }
        for (int i=length/2 - 1;i>=0;i--){
            //当前i为父节点 2i+1 2i+2 左右子节点
            
            if (2*i+2 < length && array[i] < (array[2*i+1] > array[2*i+2]?array[2*i+1]:array[2*i+2])){
                int temp = array[i];
                if (array[2*i+1] >= array[2*i+2]){
                    array[i] = array[2*i+1];
                    array[2*i+1] = temp;
                } else {
                    array[i] = array[2*i+2];
                    array[2*i+2] = temp;
                }
            } else if (2*i+2 > length && array[i] < array[2*i+1]) {
                int temp = array[i];
                if (array[i] <= array[2*i+1]){
                    array[i] = array[2*i+1];
                    array[2*i+1] = temp;
                }
            }
//            System.out.println(Arrays.toString(array));
        }
        int temp = array[0];
        array[0] = array[length - 1];
        array[length - 1] = temp;
//        System.out.println(Arrays.toString(array));
//        if (length == 3){
//            System.out.println();
//        }
        heapSortRecur(array,length-1);
    }

    
    private static void heapSortError(int[] array){
        for (int len = array.length;len>1;len--){
            //i--这个条件错了
            for (int i=len/2-1;i>=0;i--){
                
                if (2*i+2 < len &&(array[i]<array[2*i+1] || array[i]<array[2*i+2])) { //存在右子节点
                    int temp = -1;
                    int index = -1;
                    if (array[2*i+1] > array[2*i+2]) {
                        temp = array[2*i+1];
                        index = 2*i+1;
                    } else{
                        temp = array[2*i+2];
                        index = 2*i+2;
                    }
                    
                    array[i] = temp;
                }
//                if (2*i+2 < h && array[i] < (array[2*i+1] > array[2*i+2]?array[2*i+1]:array[2*i+2])){
//                    int temp = array[i];
//                    if (array[2*i+1] >= array[2*i+2]){
//                        array[i] = array[2*i+1];
//                        array[2*i+1] = temp;
//                    } else {
//                        array[i] = array[2*i+2];
//                        array[2*i+2] = temp;
//                    }
//                } else if (2*i+2 > h && array[i] < array[2*i+1]) {
//                    int temp = array[i];
//                    if (array[i] <= array[2*i+1]){
//                        array[i] = array[2*i+1];
//                        array[2*i+1] = temp;
//                    }
//                }
//                System.out.println(Arrays.toString(array));
            }
            int temp = array[0];
            array[0] = array[len - 1];
            array[len - 1] = temp;
            System.out.println(Arrays.toString(array));
        }
    }
}
