package com.wanyy.ltd.datastructure.structure.likedList.single;

import java.util.Stack;

class SingleLinkedListInterview {
    
    /**
     * 获取倒数第K个节点
     */
    static void getBackNode(SingleLinkedList linkedList,int k){
        HeroNode headNode = linkedList.headNode;
        int nodeCount = getNodeCount(linkedList);
        if (nodeCount < k){
            System.out.println("链表过短，没有满足条件的节点...");
        }

        int m = nodeCount - k + 1;
        HeroNode temp = headNode.next;
        for (int i = 0;i<nodeCount-k;i++){
            temp = temp.next;
        }
        System.out.println("倒数第 " + k + "个节点为 -> " + temp);
    }

    static int getNodeCount(SingleLinkedList linkedList){
        HeroNode temp = linkedList.headNode.next;
        int count = 0;
        while (temp != null){
            count++;
            temp = temp.next;
        }
        
        return count;
    }
    
    static void reverseLinkedList(HeroNode headNode){
        //两个next相互赋值  这个就不会改变temp
        //之前类似将temp直接赋给newNode  导致newNode更改导致temp也发生了更改
//        newNode.next = temp.next;
        if (headNode.next == null){
            System.out.println("链表为空...");
            return;
        }
        if (headNode.next.next == null){
            System.out.println("链表只有一个节点...");
            return;
        }
        HeroNode current = headNode.next;
        HeroNode curNext;
        HeroNode newHeadNode = new HeroNode(0,"");
        //自己之前没有保存current.next 导致current被重新赋值后其next的丢失
        //注意此处涉及到内存地址的相互指向
        //所以要注意赋值的形式
        while (current != null){
            curNext = current.next;
            current.next = newHeadNode.next;
            newHeadNode.next = current;
            current = curNext;
        }
        
        headNode.next = newHeadNode.next;
        
    }

    /**
     * 利用Stack的特点 先进后出
     * 然后打印
     */
    static void reversePrintLink(HeroNode headNode){
        if (headNode.next == null){
            System.out.println("链表为空");
            return;
        }

        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = headNode.next;
        while (temp != null){
            stack.add(temp);
            temp = temp.next;
        }
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }

    /**
     * 将mergeLink合并到master上 要求仍热有序
     * @param masterLink    主Link
     * @param mergeLink     待合并的Link
     */
    static void mergeOrderLinkedList(SingleLinkedList masterLink,SingleLinkedList mergeLink){
        HeroNode mergeHead = mergeLink.headNode;
        
        if (mergeHead.next == null){
            System.out.println("待合并LinkedList为空...");
            return;
        }
        
        HeroNode mergeCurrent = mergeHead.next;
        HeroNode mergeCurNext;
        
        while (mergeCurrent != null){
            mergeCurNext = mergeCurrent.next;
            
            masterLink.addNodeByOrder(mergeCurrent);
            
            mergeCurrent = mergeCurNext;
        }
    }
}
