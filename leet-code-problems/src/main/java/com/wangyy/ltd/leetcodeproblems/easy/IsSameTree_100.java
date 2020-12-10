package com.wangyy.ltd.leetcodeproblems.easy;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class IsSameTree_100 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        
        root1.left = n1;
        root1.right = n2;
//        n1.left = n3;
//        n1.right = n4;
//        n2.right = n5;
        root2.left = n2;
        root2.right = n1;
        
        preList(root1,root2);
        System.out.println(isSameTree(root1, root2));
    }
    
    public static boolean isSameTree(TreeNode p, TreeNode q){
        if (p.val != q.val) return false;
        if (p.left != null){
            if (q.left == null) return false;
            else isSameTree(p.left,q.left);
        } else if (p.right != null){
            if (q.right == null) return false;
            else isSameTree(p.right,q.right);
        } 
        return true;
    }

    public static void preList(TreeNode p, TreeNode q){
        System.out.println(p.val + " --> " + q.val);
        if (p.left != null){
            preList(p.left,q.left);
        }

        if (p.right != null){
            preList(p.right,q.right);
        }
    }
    public static void preList(TreeNode p){
        System.out.print(p.val + " --> ");
        if (p.left != null){
            preList(p.left);
        }
        
        if (p.right != null){
            preList(p.right);
        }
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) { 
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void preOrderIterator(){
        System.out.println(this);
        //递归向左遍历
        if (this.left != null){
            System.out.println("l");
            this.left.preOrderIterator();
        }
        //递归向右遍历
        if (this.right != null){
            System.out.println("r");
            this.right.preOrderIterator();
        }
    }
}