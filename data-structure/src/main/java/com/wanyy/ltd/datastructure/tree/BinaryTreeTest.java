package com.wanyy.ltd.datastructure.tree;

public class BinaryTreeTest {

    public static void main(String[] args) {
        HeroNode head = new HeroNode(0,"Roshan");
        HeroNode l1 = new HeroNode(1,"L-SF");
        HeroNode l2 = new HeroNode(2,"L-JUGG");
        HeroNode l3 = new HeroNode(3,"L-FW");
        HeroNode l4 = new HeroNode(4,"L-QP");

        HeroNode r1 = new HeroNode(5,"R-VS");
        HeroNode r2 = new HeroNode(26,"R-EH");
        HeroNode r3 = new HeroNode(27,"R-ES");
        HeroNode r4 = new HeroNode(28,"R-SA");
        
        head.setLeft(l1);
        head.setRight(l2);
        
        l2.setRight(l4);
        l2.setLeft(l3);

//        l1.setLeft(l2);
////        l1.setRight(r2);
//
//        r1.setLeft(l3);
//        r1.setRight(r3);
//
//        l3.setLeft(l4);
//        l3.setRight(r4);

        BinaryTree tree = new BinaryTree();
        tree.setRoot(head);
        tree.preOrderIterator();
        System.out.println(tree.deleteAndReplace(2));
        System.out.println("--------------------------");
        tree.preOrderIterator();
//        System.out.println(tree.preOrderSearch(5));
//        System.out.println(tree.infixOrderSearch(5));
//        System.out.println(tree.afterOrderSearch(5));

//        System.out.println(tree.deleteAll(11));
//        tree.preOrderIterator();
//        System.out.println("------------------");
//        tree.infixOrderIterator();
//        System.out.println("------------------");
//        tree.afterOrderIterator();
    }
    
}
