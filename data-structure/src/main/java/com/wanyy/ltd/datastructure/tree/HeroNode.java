package com.wanyy.ltd.datastructure.tree;

public class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode() {
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    /**
     * 1)	先输出当前节点(初始的时候是root节点)；
     * 2)	如果左子节点不为空，则递归继续前序遍历；
     * 3)	如果右子节点不为空，则递归继续前序遍历；
     */
    public void preOrderIterator(){
        System.out.println(this);
        //递归向左遍历
        if (this.left != null){
            this.left.preOrderIterator();
        }
        //递归向右遍历
        if (this.right != null){
            this.right.preOrderIterator();
        }
    }

    public HeroNode preOrderSearch(int no){
        
        if (this.no == no){
            return this;
        }
        //递归向左遍历
        HeroNode heroNode = null;
        if (this.left != null){
            heroNode = this.left.preOrderSearch(no);
        }
        System.out.println("执行了前序查找...");
        if (heroNode != null){
            return heroNode;
        }
        
        //递归向右遍历
        if (this.right != null){
            heroNode = this.right.preOrderSearch(no);
        }
        return heroNode;
    }
    
    /**
     * 1)	如果当前节点的左子节点不为空，递归中序遍历；
     * 2)	输出当前节点；
     * 3)	如果当前节点的右子节点不为空，递归中序遍历；
     */
    public void infixOrderIterator(){
        //递归向左遍历
        if (this.left != null){
            this.left.infixOrderIterator();
        }
        System.out.println(this);
        //递归向右遍历
        if (this.right != null){
            this.right.infixOrderIterator();
        }
    }

    public HeroNode infixOrderSearch(int no){
        
        //递归向左遍历
        HeroNode heroNode = null;
        if (this.left != null){
//            System.out.println("左");
            heroNode = this.left.infixOrderSearch(no);
        }
        if (heroNode != null){
            return heroNode;
        }
        System.out.println("执行了中序查找...");
        if (this.no == no){
            return this;
        }
        //递归向右遍历
        if (this.right != null){
//            System.out.println("右");
            heroNode = this.right.infixOrderSearch(no);
        }
        return heroNode;
    }

    /**
     * 1)	如果当前节点的左子节点不为空，递归后序遍历；
     * 2)	如果当前节点的右子节点不为空，递归后序遍历；
     * 3)	输出当前节点
     */
    public void afterOrderIterator(){

        //递归向左遍历
        if (this.left != null){
            this.left.afterOrderIterator();
        }
        //递归向右遍历
        if (this.right != null){
            this.right.afterOrderIterator();
        }
        System.out.println(this);
    }

    public HeroNode afterOrderSearch(int no){
        
        //递归向左遍历
        HeroNode heroNode = null;
        if (this.left != null){
            heroNode = this.left.afterOrderSearch(no);
        }
        if (heroNode != null){
            return heroNode;
        }
        
        //递归向右遍历
        if (this.right != null){
            heroNode = this.right.afterOrderSearch(no);
        }
        
        if (heroNode != null){
            return heroNode;
        }

        System.out.println("执行了后序查找...");
        if (this.no == no){
            return this;
        }
        return null;
    }
    
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
