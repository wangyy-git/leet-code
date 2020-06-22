package com.wangyy.ltd.leetcodeproblems.easy;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray_53 {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
        System.out.println(violence(nums));
    }
    
    //这个也是贪心算法  每一步都去实现最优解
    private static int maxSubArray(int[] nums) {
        int max = nums[0];
        int i = 0;
        int sum = 0;
        while (i < nums.length){
            sum += nums[i];
            max = Math.max(max,sum);
            //重点就在这
            if (sum < 0){
                sum = 0;
            }
            i++;
        }
        
        return max;
    }
    
    private static int violence(int[] nums){
        int max = nums[0];
        for (int i=0;i<nums.length;i++){
            int sum = 0;
           
            for (int j=0;j<=i;j++){
                sum += nums[j];
                max = max>sum?max:sum;
                //<0的值被加上去肯定是会变小的
                if (sum < 0) sum = 0;
            }
            //在这里判断就错了 这样每次都是加到了最后
            //关键点还是sum归0的问题
//            max = max>sum?max:sum;
        }
        
        return max;
    }
}
