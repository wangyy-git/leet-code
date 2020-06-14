package com.wanyy.ltd.datastructure.dataStru.structure.likedList.single;


public class LinkedListTest {

    
    public static void main(String[] args) {
        HeroNode h1 = new HeroNode(1,"影魔");
        HeroNode h2 = new HeroNode(2,"小黑");
        HeroNode h3 = new HeroNode(3,"巨魔");
        HeroNode h4 = new HeroNode(4,"剑圣");

        HeroNode h5 = new HeroNode(5,"影魔");
        HeroNode h6 = new HeroNode(6,"刚被");
        HeroNode h7 = new HeroNode(7,"屠夫");
        HeroNode h8 = new HeroNode(8,"混沌");
        SingleLinkedList single = new SingleLinkedList();
        
        single.addNodeByOrder(h3);
        single.addNodeByOrder(h1);
        single.addNodeByOrder(h4);
        single.addNodeByOrder(h2);
//        iteratorByHead(single.headNode);
        
        SingleLinkedList merge = new SingleLinkedList();

        merge.addNodeByOrder(h5);
        merge.addNodeByOrder(h6);
        merge.addNodeByOrder(h7);
        merge.addNodeByOrder(h8);
        
        SingleLinkedListInterview.mergeOrderLinkedList(single,merge);
        iteratorByHead(single.headNode);
        
//        SingleLinkedListInterview.reversePrintLink(single.headNode);
        
        
    }
    
    private static void iteratorByHead(HeroNode headNode){
        HeroNode temp = headNode.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
    
}
