package com.wanyy.ltd.datastructure.sort;


import java.util.Arrays;

public class Sort {
    
    private static int[] array = {1,2,4,3,7,5};
    public static void main(String[] args) {
        bubbleTeacher();
        System.out.println(Arrays.toString(array));
    }

    /**
     * 冒泡排序
     */
    private static void bubble(){
        //i j 可以理解为指针
        for (int i=0;i<array.length;i++){
            for (int j = 0; j < i; j++) {
                //j在i的前面 这是从大往小排
                System.out.printf("i->%d,j->%d\n",i,j);
//                System.out.println();
                if (array[i] < array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * 这种排序可以优化
     * 当某次排序未做更改 则表示排序完成 加flag优化
     * 这种是越排越少 
     */
    private static void bubbleTeacher(){
        boolean flag = false;
        for (int i=0;i<array.length-1;i++){
            
            for (int j = 0; j < array.length-1-i; j++) {
                //j在i的前面 这是从大往小排
//                System.out.printf("i->%d,j->%d\n",i,j);
//                System.out.println();
                if (array[j] < array[j+1]){
                    flag = true;
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            System.out.println(flag);
            if (!flag){
                break;
            } else {
                flag = false;
            }
            
        }
    }
    
    
    
}
