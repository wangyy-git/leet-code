package com.wangyy.ltd.leetcodeproblems.easy;

public class L_35_SearchInsert {

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 4;
        System.out.println(searchInsert(nums,target));
        System.out.println(answer(nums,target));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        
        if (target <= nums[0]) return 0;
        
        for (int i=0;i<nums.length;i++){
            if (nums[i] >= target) return i;
        }
        
        if (nums[nums.length-1] < target) return nums.length;
        return -1;
    }

    public static int answer(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;

        while (left <= right){
            int middle = (left+right)/2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        
        //自己当时没想到return left; 感觉找不到小于的情况
        return left;
    }
}
