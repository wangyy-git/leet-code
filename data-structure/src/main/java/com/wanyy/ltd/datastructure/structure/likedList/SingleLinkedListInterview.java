package com.wanyy.ltd.datastructure.structure.likedList;

public class SingleLinkedListInterview {
    
    /**
     * 获取倒数第K个节点
     */
    private static void getBackNode(SingleLinkedList linkedList,int k){
        HeroNode headNode = linkedList.headNode;
        
    }
    
    private static int getNodeCount(SingleLinkedList linkedList){
        HeroNode temp = linkedList.headNode.next;
        int count = 0;
        while (temp != null){
            count++;
            temp = temp.next;
        }
        
        return count;
    }
}
