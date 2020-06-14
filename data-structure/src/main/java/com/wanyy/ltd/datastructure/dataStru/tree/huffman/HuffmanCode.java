package com.wanyy.ltd.datastructure.dataStru.tree.huffman;

import java.util.*;

/**
 * 赫夫曼编码
 * 	传输的字符串为：
 * i like like like java do you like a java
 * 	各个字符对应的个数
 * d:1 y:1 u:1 j:2  v:2  o:2  l:4  k:4  e:4 i:5  a:5  空格:9
 * 	按照上面字符出现的次数构建一颗赫夫曼树, 次数作为权值；
 * 	根据赫夫曼树，给各个字符,规定编码 (前缀编码)，向左的路径为0 ，向右的路径为1，编码
 */
public class HuffmanCode {
    private static final String str = "i like like like java do you like a java";

    public static void main(String[] args) {
        byte[] bytes = str.getBytes();
        System.out.println(getNodes(bytes).toString());
        System.out.println("-----------------------------");
//        createHuffmanTree(getNodes(bytes)).preList("");
//        huffmanCode(createHuffmanTree(getNodes(bytes)),"",new StringBuilder());
        huffmanCode(createHuffmanTree(getNodes(bytes)))
                .forEach((k, v) -> System.out.println((char) k.byteValue() + "\t:" + v));
        
        
    }

//    /**
//     * 将huffmanCodes每8位看做一个byte进行压缩
//     * 解压就可以将这个byte[] 反编译成二进制字符串然后去一一对应从而生成一个原字符串
//     * 返回赫夫曼编码对应的byte[]
//     * @param bytes         字符对应的
//     * @param huffmanCodes
//     */
//    private static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes){
//        
//    }
    private static Map<Byte,String> huffmanCode(HuffmanNode node){
        huffmanCode(node,"",new StringBuilder());
        return huffmanCodes;
    }
    /**
     * 根据赫夫曼树，给各个字符
     * 规定编码(前缀编码):向左的路径为0 ，向右的路径为1
     * o: 1000   u: 10010  d: 100110  y: 100111  i: 101  a:110
     * k: 1110   e: 1111    j: 0000   v: 0001    l: 001   :01
     */
    private static Map<Byte,String> huffmanCodes = new HashMap<>();

    /**
     * 将叶子节点生产编码放入map
     * @param node  传入的节点
     * @param code  路径：向左的路径为0 ，向右的路径为1
     * @param sb    用于拼接路径
     */
    private static void huffmanCode(HuffmanNode node,String code,StringBuilder sb){
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(code);
        if (node != null){
            //判断是否是叶子节点
            if (node.data == null){
                huffmanCode(node.left,"0",sb2);
                huffmanCode(node.right,"1",sb2);
            } else {
                //找到了叶子节点
                huffmanCodes.put(node.data,new String(sb2));
            }
        }
    }
    
    private static HuffmanNode createHuffmanTree(List<HuffmanNode> nodes){
        while (nodes.size() > 1){
            nodes.sort((Comparator.comparingInt(o -> o.weight)));
            HuffmanNode left = nodes.get(0);
            HuffmanNode right = nodes.get(1);
            HuffmanNode parent = new HuffmanNode(left.weight + right.weight,null);
            nodes.remove(left);
            nodes.remove(right);
            parent.left = left;
            parent.right = right;
            nodes.add(parent);
        }
        
        return nodes.get(0);
    }
    private static List<HuffmanNode> getNodes(byte[] bytes){
        List<HuffmanNode> nodes = new ArrayList<>();
        Map<Byte,Integer> map = new HashMap<>();
        for (Byte b:bytes){
            if (map.containsKey(b)){
                map.put(b,map.get(b) + 1);
            } else {
                map.put(b,1);
            }
        }
        map.forEach((k,v) -> {
            HuffmanNode node = new HuffmanNode(v, k);
            nodes.add(node);
        });
        return nodes;
    }
}

class HuffmanNode{
    int weight;     //存储每个字符出现的次数
    Byte data;      //字符的ASCII码
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(int weight, Byte data) {
        this.weight = weight;
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "\nHuffmanNode{" +
                "data=" + (data==null?null:(char)data.byteValue()) +
                ", weight=" + weight +
//                ", left=" + left +
//                ", right=" + right +
                '}';
    }
}
