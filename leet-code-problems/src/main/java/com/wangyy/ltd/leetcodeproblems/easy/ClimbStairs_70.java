package com.wangyy.ltd.leetcodeproblems.easy;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 输入： 3  输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 算法总结：
 * 自己前期做算法的时候有一个误区，以为遍历等手段来实现最终的目的
 * 但是其实应该是用数学思维去实现最终的解题目的，最终使用代码来表达出来
 * 以这个问题来举例，解题思路如下：
 * 爬到n层楼，则由两种可能：
 * 1. 从n-1层楼再爬 1阶 到达第n层台阶
 * 2. 从n-2层楼再爬 2阶 到达第n层台阶
 * 以此往前推，则可以获取实际爬楼所需要的步数
 * 自己最初的思路是通过遍历获取实际需要的步数
 */
public class ClimbStairs_70 {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
    
    private static int climbStairs(int n){
        int[] steps = new int[n];
        if (n>=1) steps[0] = 1;
        if (n>=2) steps[1] = 2;
        for (int i = 3; i <= n; i++) {
            steps[i-1] = steps[i-2] + steps[i-3];
        }
        
        return steps[n-1];
    }
}
