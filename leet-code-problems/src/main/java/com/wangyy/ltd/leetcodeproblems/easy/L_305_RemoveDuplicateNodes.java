package com.wangyy.ltd.leetcodeproblems.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 *
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 * 如果不得使用临时缓冲区，该怎么解决？
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    
public class L_305_RemoveDuplicateNodes {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(1);
        
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode listNode = removeDuplicateNodes(l1);
        System.out.println(listNode);
    }

    public static ListNode removeDuplicateNodes(ListNode head) {
        ListNode pre = new ListNode(-1);
        ListNode temPre = pre;
        List<Integer> nums = new ArrayList<>();
        ListNode temp = head;
        while (temp != null){
            int val = temp.val;
            if (temPre.val != val && !nums.contains(val)){
                nums.add(val);
                temPre.next = new ListNode(val);
                temPre = temPre.next;
            }
            temp = temp.next;
        }
        return pre.next;
    }

    public static ListNode removeDuplicateNodesNoTepPre(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur;
            while (temp.next != null) {
                if (temp.next.val == cur.val) {
                    //移除当前重复的节点
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
            cur = cur.next;
        }
        return head;
    }
}
