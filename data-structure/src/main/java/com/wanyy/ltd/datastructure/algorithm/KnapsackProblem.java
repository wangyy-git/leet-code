package com.wanyy.ltd.datastructure.algorithm;

import java.util.Arrays;

/**
 * 1）	v[i][0]=v[0][j]=0; //表示填入表第一行和第一列是0;
 * 2）	//当准备加入新增的商品的容量大于当前背包的容量时，就直接使用上一个单元格的装入策略;
 *      当w[i]> j 时：v[i][j]=v[i-1][j]
 * 3）	当准备加入的新增的商品的容量小于等于当前背包的容量,装入的方式:
 *      w[i] <= j 时：v[i][j]=max{v[i-1][j], v[i]+v[i-1][j-w[i]]}
 *      v[i-1][j] //表示按照上一个方案来放置物品获得的值
 *      v[i]+v[i-1][j-w[i]] //放入当前行基本物品v[i] 以及剩余匹配到的最优解
 *      因为当前的步骤的之前步骤都已经是最优解了
 */
public class KnapsackProblem {

    public static void main(String[] args) {
        //记录各个物品的重量
        int[] w = {1,4,3};
        //记录对应的价值
        int[] value = {1500,3000,2000};
        int packageWeight = 4; //背包容量
        int n = value.length;
        //创建二维数组
        //v[i][j] 表示在前i个物品中能够装入容量为j的背包的最大价值
        int[][] v = new int[n+1][packageWeight+1];
        //为了记录放如商品的情况 所以用二维数组来记录
        int[][] store = new int[n+1][packageWeight+1];
        
        //初始化第一行和第一列
        //此处可以无需处理 默认为0 但是遇到有些情况可能需要处理
        
        //不处理第一行 全为0
        for (int i=1;i<v.length;i++){
            for (int j = 1; j < v[0].length; j++) {
                //公式
                //1 v[i][0]=v[0][j]=0; 已处理
                //当准备加入新增的商品的容量大于当前背包的容量时，就直接使用上一个单元格的装入策略;
                //当w[i]> j 时：v[i][j]=v[i-1][j]
                //因为此处循环是从1开始的 所以-1
                if (w[i-1] > j) {
                    v[i][j] = v[i-1][j];
//                    store[i][j] = store[i-1][j];
                } else {
                    //注意 此处因为从1循环 所以value[i-1]，v[i-1][j-w[i-1]]中的w[i-1]也要-1
                    //v[i][j]=max{v[i-1][j], v[i]+v[i-1][j-w[i]]}
                    v[i][j]=v[i-1][j]>(value[i-1]+v[i-1][j-w[i-1]])?v[i-1][j]:(value[i-1]+v[i-1][j-w[i-1]]);
                    
                    //此处是为了记录商品的存放
                    
                    if (v[i-1][j]<(value[i-1]+v[i-1][j-w[i-1]])){
                        //存放的是v[i-1][j] 只记录最有情况
                        store[i][j] = 1;
                    }
                }
            }
        }

        Arrays.stream(v).forEach(vv -> System.out.println(Arrays.toString(vv)));

        System.out.println("商品放入背包的情况");
        int i = store.length - 1,j=store[0].length-1;
        while (i>0 && j>0){
            if (store[i][j] == 1){
                System.out.printf("第%d个商品放入背包\n",i);
                j -= w[i-1];
            }
            i--;
        }
    }
}
