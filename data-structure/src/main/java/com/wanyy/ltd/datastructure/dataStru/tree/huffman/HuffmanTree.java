package com.wanyy.ltd.datastructure.dataStru.tree.huffman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {

    public static void main(String[] args) {
        int[] array = {1,13,3,8,6,7,29};
        createHuffman(array);
    }
    
    private static void createHuffman(int[] array){
        //将array每个值都构造成一个node，并将其放入List中
        List<Node> nodes = new ArrayList<>();
        Arrays.stream(array).forEach(a -> nodes.add(new Node(a)));
        while (nodes.size() > 1){
            Collections.sort(nodes);
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node parent = new Node(left.value + right.value);
            nodes.remove(left);
            nodes.remove(right);
            parent.left = left;
            parent.right = right;
            nodes.add(parent);
        }
    }
}

//为了让Node可以比较大小 实现Compareable接口
class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排
        return this.value - o.value;
    }
}
