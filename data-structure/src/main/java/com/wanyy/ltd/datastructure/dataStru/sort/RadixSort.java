package com.wanyy.ltd.datastructure.dataStru.sort;

/**
 * 将所有带比较的数值统一为同样的数位长度，数位较短的前面补0，然后从低位开始，依次进行依次排序。
 * 这样从最底位排序一直到最高位排序完成以后变成了一个有序序列；
 */
public class RadixSort {
    public static void main(String[] args) {
//        int[] array = {112,22,45,3,72,11,6,8,5};
//        radixSort(array);

        long start = System.currentTimeMillis();
        int length = 8000000;
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int)(Math.random()*length*10);
        }
        radixSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

//        System.out.println(Arrays.toString(array));
        
    }
    
    private static void radixSort(int[] array){
        //设置10个桶
        int[][] bucket = new int[10][array.length];
        //记录各个桶放置几个有效数字
        int[] bucketSize = new int[10];
        int max = 0;
        for (int a:array){
            if (max < a) max = a;
        }
        int maxSize = (max + "").length();
        for (int i=0,n=1;i<maxSize;i++,n=n*10){
            for (int a:array){
                //这一步存数是重点
                int digital = a / n % 10;
                bucket[digital][bucketSize[digital]] = a;
                bucketSize[digital]++;
            }
            //将桶中的元素一次取出
            int index = 0;
            for (int k = 0; k < 10; k++) {
                int size = bucketSize[k];
                if (size > 0){
                    for (int j = 0; j < size; j++) {
                        array[index++] = bucket[k][j];
                    }
                }
                //这一步必须清除为0  防止后面被重复取
                //而bucket不需要清除 应为只要bucketSize[i]==0就不用去对应的桶中取数据
                bucketSize[k] = 0;
            }
        }
    }
}
