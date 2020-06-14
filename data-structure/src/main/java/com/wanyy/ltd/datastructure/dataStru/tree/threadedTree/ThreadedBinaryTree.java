package com.wanyy.ltd.datastructure.dataStru.tree.threadedTree;

public class ThreadedBinaryTree {
    private HeroNode root;

    //为了实现线索化 需要创建一个指向当前节点的前驱节点的指针
    //在运算过程中 pre始终保存前一个节点
    private HeroNode pre = null;
    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void infixList(){
        if (root == null){
            System.out.println("root节点为空");
            return;
        }
        
        this.root.infixList();
    }
    public void infixThreadedNode(){
        this.infixThreadedNode(root);
    }
    /**
     * 中序线索化二叉树
     * node 待线索化的节点
     */
    public void infixThreadedNode(HeroNode node){
        if (node == null){ return; }
        //先线索化左子树
        infixThreadedNode(node.getLeft());
        /*
         *           1
         *       3       6
         *     8   10 14 
         */
        //线索化当前节点 仅在当前节点的左/右子节点为null才处理
        if (node.getLeft() == null){
            //让当前左指针指向前驱节点
            node.setLeft(pre);
            //修改当前节点做指针的类型
            node.setLeftType(1);
        }
        //处理后继节点
        //应该是在递归后的下一次才执行 的
        //因为第一次进入这个判断是进不去的
        //以8节点为例 执行到这时 是对于3节点的判断
        //node ->HeroNode{no=3, name='FW', leftType=0, rightType=0}
        //pre ->HeroNode{no=8, name='QP', leftType=1, rightType=0}
        if (pre != null && pre.getRight() == null){
            System.out.println("node ->" + node);
            System.out.println("pre ->" + pre);
            System.out.println("---------------");
            pre.setRight(node);
            pre.setRightType(1);
        }
        //!!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;
        //线索化右子树
        infixThreadedNode(node.getRight());
        
    }
}


class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    
    //0 表示指向的是左子节点 1 表示指向的是前驱节点
    private int leftType;
    //0 表示指向的是右子节点 1 表示指向的是后继节点
    private int rightType;

    public void infixList(){
        if (this.getLeft() != null && this.getLeftType() == 0){
            this.getLeft().infixList();
        }
        System.out.println(this);
        if (this.getRight() != null && this.getRightType() == 0){
            this.getRight().infixList();
        }
    }
    
    public HeroNode() {
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
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

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", leftType=" + leftType +
                ", rightType=" + rightType +
                '}';
    }
}