package com.wanyy.ltd.datastructure.tree.balance;

import java.util.Arrays;

public class AVLTreeTest {

    public static void main(String[] args) {
        int[] array = {10,11,7,6,8,9};
        SelfBlanceTree sbTree = new SelfBlanceTree();
        Arrays.stream(array).forEach(a->sbTree.add(new AVLNode(a)));

        AVLNode root = sbTree.getRoot();
        System.out.println(root);

        System.out.println("left hight -> " + root.getLeftHight());
        System.out.println("right hight -> " + root.getRightHight());
//        root.leftRotate();
        System.out.println(root);
    }
}
