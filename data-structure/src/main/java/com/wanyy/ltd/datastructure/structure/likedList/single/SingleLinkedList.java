package com.wanyy.ltd.datastructure.structure.likedList.single;

public class SingleLinkedList {
    
    HeroNode headNode = new HeroNode(0,"");
    public void addNode(HeroNode newNode){
        HeroNode temp = headNode;
        while (true) {
            //标志找到了当前队列的最后一个元素
            if (temp.next == null) {
                temp.next = newNode;
                break;
            }
            //否则就一直往后走
            //以为将当前元素的内存地址赋予了temp，那么更改temp就是更改对应的LinkedList的最后一个元素
            temp = temp.next;
        }
    }
    
    public void addNodeByOrder(HeroNode newNode){
        HeroNode temp = headNode;//0
        while (true) {
            //此处tempNext是一个新对象，与temp.next的地址是不一样的
            //此处node.next虽然与node的类型是一样的，但是性质是不一样的
            //一个是变量  一个是变量的属性  所以不能相互替换
            HeroNode tempNext = temp.next;
            if (tempNext == null || temp.next.no > newNode.no){
                newNode.next = tempNext;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
    }
    
    public void deleteNode(HeroNode delete){
        HeroNode next = delete.next;
        HeroNode temp = headNode.next;
        while (true){
            if (temp.next == delete){
                temp.next = next;
                break;
            }
            temp = temp.next;
        }
    }
    
    public void iterList(){
        HeroNode temp = headNode.next;
        if (temp == null){
            System.out.println("链表为空");
            return;
        }
        while (true) {
            System.out.println(temp);
            if (temp.next == null) {
                break;
            }
            
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

    HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", name='" + next + '\'' +
                '}';
    }
}