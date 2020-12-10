package com.wangyy.ltd.leetcodeproblems.easy;


/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * node的定义@See MergeTwoLists
 */
public class L_83_DeleteDuplicateNode {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
//        ListNode l4 = new ListNode(5);
//        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
        System.out.println(deleteDuplicates(l1));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null){
            if (temp.val == temp.next.val){
                temp.next = temp.next.next;
                continue;
            }
            temp = temp.next;
        }
        return head;
    }
}
