package com.wangyy.ltd.leetcodeproblems.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class TwoLinkSum {
    public static void main(String[] args) {
        int i1 = 3425; 
        int i2 = 0; 
//        System.out.println(Integer.reverse(i1) + Integer.reverse(i2));
        ListNode listNode1 = parseToListNode(i1 + "");
        ListNode listNode2 = parseToListNode(i2 + "");
        System.out.println("l1 -> " + listNode1);
        System.out.println("l2 -> " + listNode2);
        System.out.println("我的 --> " + addTwoNumbersByStack(listNode1, listNode2));
        System.out.println("答案 --> " + answer(listNode1, listNode2));
    }

    //最终完善版本  只计算当前位数的数字
    private static ListNode addTwoNumbersByStack(ListNode l1, ListNode l2){
        List<Integer> s1 = new ArrayList<>();
        ListNode temp = l1;
        //此两处获取值并相加是可以合并的
        while (temp != null){
            s1.add(temp.val);
            temp = temp.next;
        }
        List<Integer> s2 = new ArrayList<>();
        temp = l2;
        while (temp != null){
            s2.add(temp.val);
            temp = temp.next;
        }

        ListNode head = new ListNode(0);
        temp = head;
        int ten = 0;
        int index = 0;
        while (!(index >= s1.size() && index >= s2.size())){
            int i1 = 0;
            if (index < s1.size()) {
                i1 = s1.get(index);
            }
            int i2 = 0;
            if (index < s2.size()) {
                i2 = s2.get(index);
            }
            index++;

            int sum = ten + i1 + i2;
            int mold = sum % 10;    //记录各位的值
            ten = sum / 10;     //记录当前相加十位的值
            
            temp.next = new ListNode(mold);
            temp = temp.next;
            //少了一位
            if((ten != 0) && (index >= s1.size() && index >= s2.size())){
                temp.next = new ListNode(ten);
            }
        }
        
        return head.next;
    }
    /**
     * 最初使用的是StringBuilder 然后使用reverse解析成int
     * 自己这个做法是实现了表面的计算  但是是不对的
     * 因为对于大位数的计算是总是会失效的 EG:超过了Integer的最大值
     * 只有实现自动进位才是最正确的
     */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int index = 0;
        int intL1 = 0;
        ListNode temp1 = l1;
        while (true){
            intL1 = temp1.val * (int)Math.pow(10,index++) + intL1;
            if (temp1.next == null){
                break;
            }
            temp1 = temp1.next;
        }

        ListNode temp2 = l2;
        index = 0;
        int intL2 = 0;
        while (true){
            intL2 = temp2.val * (int)Math.pow(10,index++) + intL2;
            if (temp2.next == null){
                break;
            }
            temp2 = temp2.next;
        }
        
        int sum = intL1 + intL2;
        StringBuilder sbResult = new StringBuilder(sum + "");
        String[] split = sbResult.reverse().toString().split("");
        ListNode head = new ListNode(Integer.parseInt(split[0]));
        for (int i = 1; i < split.length; i++) {
            ListNode temp = head;
            while (true) {
                if (temp.next == null) {
                    temp.next = new ListNode(Integer.parseInt(split[i]));
                    break;
                }
                temp = temp.next;
            }
        }

        return head;
    }
    
    public static ListNode answer(ListNode l1, ListNode l2){
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
    
    static ListNode parseToListNode(String str){
        ListNode head = new ListNode(0);
        String[] split = str.split("");
        ListNode temp = head;
        for (int i=split.length-1;i>=0;i--){
            temp.next = new ListNode(Integer.parseInt(split[i]));
            temp = temp.next;
        }
        
        return head.next;
    }
}

class ListNode { 
    int val;
    ListNode next;
    ListNode(int x) { 
        val = x; 
    }
    
    void add(ListNode node){
        this.next = node;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}