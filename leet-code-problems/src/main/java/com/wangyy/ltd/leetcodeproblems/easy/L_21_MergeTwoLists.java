package com.wangyy.ltd.leetcodeproblems.easy;

import java.util.List;

/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class L_21_MergeTwoLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l11 = new ListNode(11);
        ListNode l12 = new ListNode(22);
        
        l1.next = l11;
        l11.next = l12;
//        System.out.println(l1);
        ListNode l2 = new ListNode(2);
        ListNode l21 = new ListNode(21);
        ListNode l22 = new ListNode(22);

        l2.next = l21;
        l21.next = l22;
        System.out.println(violetMergeTwoLists(l1, l2));
        ListNode answer = answer(l1, l2);
        System.out.println(answer);
//        System.out.println(mergeTwoLists(l1, l2));

    }

    public static ListNode violetMergeTwoLists(ListNode l1, ListNode l2) {

        if (l2 == null){
            return l1;
        }else if(l1 == null){
            return l2;
        }
        
        ListNode pre = new ListNode(-1);
        ListNode preHead = pre;
        
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                preHead.next = l1;
                preHead = preHead.next;
                l1 = l1.next;
            } else {
                preHead.next = l2;
                preHead = preHead.next;
                l2 = l2.next;
            }
        }

        preHead.next = l1 == null ? l2 : l1;
        
        return pre.next;
    }
    
    public static ListNode answer(ListNode l1, ListNode l2){
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    
    public String toString(){
        return "{val->" + val + ",next->" + next + "}";
    }
 }
