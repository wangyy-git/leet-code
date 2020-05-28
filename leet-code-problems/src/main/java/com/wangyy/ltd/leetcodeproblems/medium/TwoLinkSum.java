package com.wangyy.ltd.leetcodeproblems.medium;

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
        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(3);
        l1.next = l11;
        l11.next = l12;

        ListNode l2 = new ListNode(3);
//        ListNode l21 = new ListNode(6);
//        ListNode l22 = new ListNode(4);
//        l2.next = l21;
//        l21.next = l22;

        System.out.println(Math.pow(10,1));
        TwoLinkSum tw = new TwoLinkSum();
        ListNode listNode = tw.answer(l1, l2);
        System.out.println(listNode);
    }

    private ListNode addTwoNumbersByStack(ListNode l1, ListNode l2){
        Stack<Integer> s1 = new Stack<>();
        ListNode temp1 = l1;
        while (true){
            if (temp1.next == null){
                s1.add(temp1.val);
                break;
            }
            s1.add(temp1.val);
            temp1 = temp1.next;
        }

        int intL1 = 0;
        int size1 = s1.size();
        for (int i = 0; i < size1; i++) {
            intL1 = s1.pop()*(int)Math.pow(10,size1--) + intL1;
        }

        StringBuilder sb2 = new StringBuilder();
        ListNode temp2 = l2;
        while (true){
            if (temp2.next == null){
                sb2.append(temp2.val);
                break;
            }
            sb2.append(temp2.val);
            temp2 = temp2.next;
        }
        int intL2 = Integer.parseInt(sb2.reverse().toString());
        int i1 = intL1 + intL2;
        StringBuilder sbResult = new StringBuilder(i1 + "");
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
    
    public ListNode answer(ListNode l1, ListNode l2){
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