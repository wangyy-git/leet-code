package com.wanyy.ltd.datastructure.dataStru.structure.likedList.singleCircle;

import java.util.Arrays;

public class SingleCircleList {
    HeroNode first = new HeroNode(0);
    
    void addNode(HeroNode newNode){
        //这里需要标出第一次添加节点的特殊情况
        //约定no>0
        if (newNode.no < 1){
            System.out.println("编号不正确");
            return;
        }
        
        //所有node的节点no是连续的
        HeroNode current = null;
        for (int i = 1; i <= newNode.no; i++) {
            HeroNode heroNode = new HeroNode(i);
            
            if (i==1){
               first = heroNode;
               heroNode.next = heroNode;
//               current = heroNode;
               current = first;
            } else {
                current.next = heroNode;
                heroNode.next = first;
                current = heroNode;
            }
        }
        
    }
    
    void iterator(){
        HeroNode temp = this.first;
        
        if (temp.next == null) {
            System.out.println("kong ...................");
            return;
        }
        while (true) {
            System.out.println(temp);
            if (temp.next == first) {
                return;
            }
            temp = temp.next;
        }
    }

    int countNodeNum(){
        HeroNode temp = this.first;

        if (temp.next == null) {
            System.out.println("kong ...................");
            return 0;
        }
        int count = 0;
        while (true) {
//            System.out.println(temp);
            count++;
            if (temp.next == first) {
                return count;
            }
            temp = temp.next;
        }
    }
    /**
     * 约瑟夫问题  丢手绢
     * @param start 从start开始数数
     * @param count 数到count的节点退出
     * @return      退出节点列表
     */
    String joseph(int start,int count){
        HeroNode temp = this.first;
        int orginNodeNum = this.countNodeNum();
        int[] nums = new int[orginNodeNum];
        for (int i = 1; i < start; i++) {
            temp = temp.next;
        }
        HeroNode pre = null;
        int countNum = 1;
        int i = 0;
        while (true){
            if (temp.next == temp){
                nums[orginNodeNum-1] = temp.no;
                break;
            }
//            int nodeNum = this.countNodeNum();
            if (countNum % count == 0) {
                nums[i++] = temp.no;
                //将改节点移除
//                pre.next = temp.next;  //这样赋值导致整体是2-1-2-1-2  去掉3后应该是1-2-1-2

                temp = temp.next;
                assert pre != null;
                pre.next = temp;
                continue;
            } 
            countNum++;
            pre = temp;
            temp = temp.next;
        }

        return Arrays.toString(nums);
    }


    void joseph_teacher(int start,int count){
        if (this.first == null || start < 1){
            System.out.println("输入参数错误");
            return;
        }
        
        //辅助 指向first的next
        HeroNode helper = this.first;

        while (helper.next != first) {
            helper = helper.next;
        }
        //两者同时后移至指定位置 start-1次
        for (int i = 1; i < start; i++) {
            helper = helper.next;
            first = first.next;
        }
        
        //开始报数 移动m-1次 出圈  直到只有一个
        while (true){
            if (helper == first){
                System.out.println("最后留在圈中的 -> " + first.no);
                break;
            }

            for (int i = 0; i < count -1; i++) {
                helper = helper.next;
                first = first.next;
            }

            System.out.println(first.no + "出圈");
            first = first.next;
            helper.next = first;
        }
        
    }
}

class HeroNode{
    int no;
    //自己当时理解的是存的地址的具体信息
    //其实存的就是对象 他本身就是一个地址
    HeroNode next;

    HeroNode(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                '}';
    }
}