package com.wanyy.ltd.datastructure.dataStru.sort;


/**
 * 快速排序
 * 快速排序是对冒泡排序的一种改进。
 * 基本思想：通过一趟排序将要排序的数据分割成独立的两部分，
 * 其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 然后再按此方法对这两部分的数据进行快速排序，整个排序过程可以递归进行，
 * 以此达到整个数据变成有序序列；
 */
public class Quick {

    public static void main(String[] args) {
//        int[] array = {8,9,1,7,2,3,5,4,6,0};
        long start = System.currentTimeMillis();
        int length = 8000000;
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int)(Math.random()*length*10);
        }
        quick(array,0,array.length-1);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

//        quickSort(array,0,array.length-1);
        
//        System.out.println(Arrays.toString(array));
    }
    
    private static void quick(int[] array,int left,int right){
        int l = left;
        int r = right;
        //中轴值  两侧与此值进行比较
        int pivot = array[(left+right)/2];
        //while循环的目的是将比pivot小的放在其左边，大的放右边
        while (l<r){
            //在pivot左边找>=pivot 并不一定是index也比其小
            while (array[l] < pivot){ l+=1;}
            //在pivot左边找<=pivot 跳出循环
            while (array[r] > pivot){ r-=1; }
            //l>=r说明pivot两侧的值已经排好了
            if (l>=r) break;
            //交换两者的值
            int temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            //交换玩之后发现array[l] == pivot r-- 前移
            if (array[l] == pivot) r-=1;
            //交换玩之后发现array[r] == pivot l++ 后移
            if (array[l] == pivot) l+=1 ;
        }

        if (l==r){
            l+=1;r-=1;
        }
        //向左递归
        if (left<r){
            quick(array,left,r);
        }

        //向右递归
        if (right > l){
            quick(array,l,right);
        }
        
    }


    public static void quickSort(int[] arr, int left, int right) {
        int l = left; //左下标
        int r = right; //右下标
        //pivot 中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0; //临时变量，作为交换时使用
        //while循环的目的是让比pivot 值小放到左边
        //比pivot 值大放到右边
        while (l < r) {
            //在pivot的左边一直找,找到大于等于pivot值,才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            //在pivot的右边一直找,找到小于等于pivot值,才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果l >= r说明pivot 的左右两的值，已经按照左边全部是
            //小于等于pivot值，右边全部是大于等于pivot值
            if (l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if (arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
