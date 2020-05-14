package com.wanyy.ltd.datastructure.structure.likedList;

public class LinkedListTest {

    public static void main(String[] args) {
        HeroNode h1 = new HeroNode(1,"影魔");
        HeroNode h2 = new HeroNode(2,"斧王");
        HeroNode h3 = new HeroNode(3,"巨魔");
        HeroNode h4 = new HeroNode(4,"先知");
        SingleLinkedList single = new SingleLinkedList();
//        single.addNode(h1);
//        single.addNode(h2);
//        single.addNode(h3);
//        single.addNode(h4);
//        single.iterList();
//        System.out.println("----------------");
//        single.deleteNode(h2);
        
        single.addNodeByOrder(h3);
        single.addNodeByOrder(h1);
        single.addNodeByOrder(h4);
        single.addNodeByOrder(h2);
        
        single.iterList();
    }
}
