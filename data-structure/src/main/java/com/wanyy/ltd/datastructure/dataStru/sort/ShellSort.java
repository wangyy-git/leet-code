package com.wanyy.ltd.datastructure.dataStru.sort;

import java.util.Arrays;

public class ShellSort {
    private static int[] array = {8,9,1,7,2,3,5,4,6,0};
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int length = 8;
        array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int)(Math.random()*length*10);
        }
        shellInsert();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
//        shellInsert();
//        shellDemo();

//        System.out.println(Arrays.toString(args));
        System.out.println(Arrays.toString(array));
    }
    
    
    private static void shellInsert(){
        for (int gap = array.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                int temp = array[j];
                while (j-gap>=0 && temp < array[j-gap]){
                    //当前arr[j-gap]移动导[j]
                    array[j] = array[j-gap];
                    j -= gap;
                }
                array[j] = temp;
            }
        }
        
    }
    
    private static void shell(){
        for (int gap = array.length / 2; gap > 0; gap = gap / 2) {
            //在组里面进行了冒泡排序
            for (int i = gap; i < array.length; i++) {
                for (int j = i-gap; j >= 0; j-=gap) {
                    if (array[j] > array[j+gap]){
                        int temp = array[j];
                        array[j] = array[j+gap];
                        array[j+gap] = temp;
                    }
                }
            }
        }
    }
    
    private static void shellDemo(){
        for (int i = 5; i < array.length; i++) {
            for (int j = i-5; j >= 0; j-=5) {
                if (array[j] > array[j+5]){
                    int temp = array[j];
                    array[j] = array[j+5];
                    array[j+5] = temp;
                }
            }
        }

        System.out.println("" + Arrays.toString(array));
        //step = 5/2 = 2
        for (int i = 2; i < array.length; i++) {
            for (int j = i-2; j >= 0; j-=2/*5 3 1*/) {
                System.out.println("i"+ i + "对比 j ->" +j + " j+2->"+(j+2));
                if (array[j] > array[j+2]){
                    int temp = array[j];
                    array[j] = array[j+2];
                    array[j+2] = temp;
                }
            }

//            System.out.println("对比 i ->" +i + "i-2->"+(i-2));
//            if (array[i] < array[i-2]) {
//                int temp = array[i];
//                array[i] = array[i-2];
//                array[i-2] = temp;
//            }
        }

        System.out.println("" + Arrays.toString(array));

        //step = 2/1
        for (int i = 1; i < array.length; i++) {
//            for (int j = i-1; j >= 0; j-=1) {
//                if (array[j] > array[j+1]){
//                    int temp = array[j];
//                    array[j] = array[j+1];
//                    array[j+1] = temp;
//                }
//            }
            if (array[i] < array[i-1]) {
                int temp = array[i];
                array[i] = array[i-1];
                array[i-1] = temp;
            }
//            System.out.println("" + Arrays.toString(array));
        }

        System.out.println("" + Arrays.toString(array));
    }
}
