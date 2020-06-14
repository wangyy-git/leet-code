package com.wanyy.ltd.datastructure.dataStru.structure.likedList.twoway;

public class TwoWayLinkedList {
    
    HeroNode headNode(){
        return new HeroNode(0,"dota");
    }

    HeroNode headNode = new HeroNode(0,"dota");

    

    void addNode(HeroNode newNode){
        HeroNode temp = this.headNode;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.pre = temp;
    }
    
    void addNodeByOrder(HeroNode newNode){
        HeroNode current = this.headNode;
        HeroNode currentNext;
        HeroNode currentPre;
        while (true){
            if (current.next == null){
                System.out.println("新插入节点为最后一位....");
                newNode.pre = current;
                current.next = newNode;
                break;
            }
            if (current.next.no > newNode.no){
                //应该是current.next将原地址给了currentNext
                //然后获取了一个新地址
                currentNext = current.next;
                currentPre = current.pre;
                
                current.next = newNode;
                newNode.next = currentNext;
                
                newNode.pre = current;
                currentPre.pre = newNode;
                break;
            }
            current = current.next;
        }
    }
    
    void deleteNode(HeroNode delNode){
        HeroNode temp = this.headNode.next;
        
        if (temp == null){
            System.out.println("该链表为空，无法删除");
            return;
        }
        
        while (true){
            //相比单链的一个额外判断 要不就temp.next.pre = temp.pre报空指针
            if (temp.no == delNode.no && temp.next == null){
                System.out.println("待删除节点为最后一个节点");
                temp.pre.next = temp.next;
                break;
            }
            
            if (temp.no == delNode.no){
                temp.pre.next = temp.next;
                temp.next.pre = temp.pre;
                break;
            }
            if (temp.next == null){
                System.out.println("未找到待删除的节点");
                break;
            }
            temp = temp.next;
        }
    }
    
    void iteratorByHead(){
        HeroNode headNode = this.headNode;
        HeroNode temp = headNode.next;
        if (temp == null){
            System.out.println("这是一个空链表....");
            return;
        }
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;

        }
    }
}


class HeroNode{
    int no;
    String name;
    //自己当时理解的是存的地址的具体信息
    //其实存的就是对象 他本身就是一个地址
    HeroNode next;
    HeroNode pre;

    HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    /**
     * 最初toString方法因为pre和next都打印了  导致是一个死循环 造成了栈溢出
     */
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}