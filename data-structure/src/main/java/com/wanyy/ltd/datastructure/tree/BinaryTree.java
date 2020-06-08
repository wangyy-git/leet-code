package com.wanyy.ltd.datastructure.tree;

public class BinaryTree {
    
    private HeroNode root;

    public void preOrderIterator(){
        if (this.root != null){
            this.root.preOrderIterator();
        } else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    public HeroNode preOrderSearch(int no){
        if (this.root != null){
            return this.root.preOrderSearch(no);
        } else {
            System.out.println("当前二叉树为空，无法找到");
            return null;
        }
    }

    public HeroNode infixOrderSearch(int no){
        if (this.root != null){
            return this.root.infixOrderSearch(no);
        } else {
            System.out.println("当前二叉树为空，无法找到");
            return null;
        }
    }

    public HeroNode afterOrderSearch(int no){
        if (this.root != null){
            return this.root.afterOrderSearch(no);
        } else {
            System.out.println("当前二叉树为空，无法找到");
            return null;
        }
    }

    public void infixOrderIterator(){
        if (this.root != null){
            this.root.infixOrderIterator();
        } else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    public void afterOrderIterator(){
        if (this.root != null){
            this.root.afterOrderIterator();
        } else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }
    
    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }
}
