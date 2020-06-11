package com.wanyy.ltd.datastructure.tree.sortTree;

public class BSTTest {

    public static void main(String[] args) {
        int[] array = {7, 3, 10, 12, 5, 1, 9,2};
        SortNode root = new SortNode(array[0]);
        BinarySortTree bst = new BinarySortTree(root);
        for (int i = 1; i < array.length; i++) {
            bst.add(new SortNode(array[i]));
        }

        root.infixList();
        System.out.println("----------------");
        System.out.println(root.searchParentNode(9));

        System.out.println("----------------");
//        System.out.println(root.searchParentNode(12).getRightBranchSmallestNode());
        bst.delete(1);
        bst.delete(7);
        bst.delete(3);
        bst.delete(10);
        bst.delete(12);
        bst.delete(5);
//        bst.delete();
        System.out.println("-------------");
        bst.delete(9);
        System.out.println("-------------");

        bst.infixList();
//        root.infixList();


    }
}
