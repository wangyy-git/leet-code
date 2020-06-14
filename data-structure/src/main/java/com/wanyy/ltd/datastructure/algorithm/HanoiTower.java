package com.wanyy.ltd.datastructure.algorithm;

/**
 * 使用分治算法解决汉诺塔问题
 */
public class HanoiTower {

    private static long step = 0;
    public static void main(String[] args) {
        hanoi(4,"A","B","C");
        System.out.println(step);
        
    }

    /**
     * @param num   总共几个盘子
     * @param a     a柱
     * @param b     b柱
     * @param c     b柱
     */
    public static void hanoi(int num,String a,String b,String c){
        if (num == 1){
            System.out.println("第 1 个盘从 " + a + " -> " + c);
            step++;
        } else {
            //一直分到最后是两个盘来解决问题
            //如果n>=2，总是将其看做事两个盘，上面是1，下面是2
            //1 先把最上面所有盘 a->b 移动过程用到c
            hanoi(num-1,a,c,b);
            //2 把下边的盘a->c
            System.out.println("第 " + num + " 个盘从 " + a + " -> " + c);
            step++;
            //3 把B塔所有的盘 b -> c,移动过程中使用到a
            hanoi(num-1,b,a,c);
        }
    }
}
