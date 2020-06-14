package com.wanyy.ltd.datastructure.dataStru.tree;

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

    public boolean deleteAll(int no){
        if (root == null){
            System.out.println("该二叉树为空");
            return false;
        }
        if (this.root.getNo() == no){
            this.root = null;
            return true;
        }
        return this.root.deleteAll(no);
    }
    
    public boolean deleteAndReplace(int no){
        if (root == null){
            System.out.println("该二叉树为空");
            return false;
        }
        if (this.root.getNo() == no){
            if (root.getLeft() != null){
                HeroNode right = this.root.getRight();
                this.root = root.getLeft();
                this.root.setRight(right);
            } else {
                this.root = this.root.getRight();
            }
            return true;
        }
        
        return this.root.deleteAndReplace(no);
    }

    public void infixOrderIterator(){
        if (this.root != null){
            this.root.infixOrderIterator();
        } else {
            System.out.println("当前二叉树为空，无法遍历");
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
    
    public void afterOrderIterator(){
        if (this.root != null){
            this.root.afterOrderIterator();
        } else {
            System.out.println("当前二叉树为空，无法遍历");
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
    
    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }
}
