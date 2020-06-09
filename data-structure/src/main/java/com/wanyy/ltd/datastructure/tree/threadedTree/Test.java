package com.wanyy.ltd.datastructure.tree.threadedTree;

public class Test {
    /**
     *           1
     *       3       6
     *     8   10 14 
     */
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1,"SF");
        HeroNode n1 = new HeroNode(3,"FW");
        HeroNode n2 = new HeroNode(6,"SV");
        HeroNode n3 = new HeroNode(8,"QP");
        HeroNode n4 = new HeroNode(10,"SA");
        HeroNode n5 = new HeroNode(14,"QA");
        
        root.setLeft(n1);
        root.setRight(n2);
        
        n1.setLeft(n3);
        n1.setRight(n4);
        
        n2.setLeft(n5);
        
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.infixThreadedNode();

        System.out.println("list=========");
        threadedBinaryTree.infixList();
        System.out.println(n3.getLeft());
        System.out.println(n3.getRight());
    }
}
