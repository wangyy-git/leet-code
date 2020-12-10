package com.wangyy.ltd.leetcodeproblems.easy;

import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出：[1,2,2,3,5,6]
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1.length == m + n
 * nums2.length == n
 */
public class MergeTwoArray_88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1,nums1.length,nums2,nums2.length);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0,index2 = 0,n1 = 0,n2 = 0;
        while (true){
            if (index1 < m) n1 = nums1[index1];
            if (index2 < n) n2 = nums2[index2];
            if (index2 >= n) break;
            
            if (n1 == 0 && index2 < nums2.length){
                nums1[index1++] = n2;
                index2++;
                continue;
            }
            if (n1 > n2){
                index1++;
            } else if (n1 == n2){
                int temp = nums1[index1+1];
                nums1[index1+1] = n2;
                nums2[index2] = temp;
                index1 = index1+2;
            } else/* if (n1 < n2) */{
                int temp = nums1[index1+1];
                nums1[index1+1] = n2;
                nums2[index2] = temp;
                index1 = index1+1;
            }
            
        }

        System.out.println(Arrays.toString(nums1));
    }
    
    private static void mergeArray(){
        
    }
}
