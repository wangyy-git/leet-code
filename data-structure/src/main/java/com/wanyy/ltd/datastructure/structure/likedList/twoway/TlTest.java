package com.wanyy.ltd.datastructure.structure.likedList.twoway;

public class TlTest {

    public static void main(String[] args) {
        HeroNode h1 = new HeroNode(1,"影魔");
        HeroNode h2 = new HeroNode(2,"小黑");
        HeroNode h3 = new HeroNode(3,"巨魔");
        HeroNode h4 = new HeroNode(4,"剑圣");

        HeroNode h5 = new HeroNode(5,"影魔");
        HeroNode h6 = new HeroNode(6,"刚被");
        HeroNode h7 = new HeroNode(7,"屠夫");
        HeroNode h8 = new HeroNode(8,"混沌");
        
        TwoWayLinkedList linkedList = new TwoWayLinkedList();
        linkedList.addNodeByOrder(h1);
        linkedList.addNodeByOrder(h6);
        linkedList.addNodeByOrder(h3);
        linkedList.addNodeByOrder(h4);
        linkedList.addNodeByOrder(h2);
        
        
//        linkedList.addNode(h3);
//        linkedList.deleteNode(h4);
        linkedList.iteratorByHead();
    }
}
