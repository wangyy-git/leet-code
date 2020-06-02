package com.wangyy.ltd.leetcodeproblems.easy;

/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        while (temp1.next != null){
            ListNode temp2 = l2;
            while (temp2.next != null){

                ListNode pre = temp1;
                if (temp1.val > temp2.val){
                    pre.next = temp2;
                }

                temp2 = temp2.next;
                temp1 = temp1.next;
            }
            temp1 = temp1.next; 
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
