package com.wanyy.ltd.datastructure.dataStru.structure.likedList.singleCircle;

public class CircleTest {

    public static void main(String[] args) {
        HeroNode h1 = new HeroNode(6);
        
        SingleCircleList circle = new SingleCircleList();
        circle.addNode(h1);
        
        circle.iterator();
        System.out.println("==================================");
        System.out.println("count --> " + circle.countNodeNum());
        System.out.println("==================================");
        System.out.println(circle.joseph(2, 2));
        
        circle.joseph_teacher(2,2);
    }
}
