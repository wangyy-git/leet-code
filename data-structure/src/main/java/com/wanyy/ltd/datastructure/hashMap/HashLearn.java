package com.wanyy.ltd.datastructure.hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashLearn {

    public static void main(String[] args) {
//        HashMap<String,String> map = new HashMap<>();
//        map.put("2","k22");
//        map.put("1","k11");
//        map.put("3","k33");
        
//        for (String k:map.keySet()){
//            if (k.equals("2")){
//                map.remove("2");
//            }
//        }
//        System.out.println("put -> " + map.put("k1","k2"));
//        
//        Node[] arr = new Node[8];
//        
//        //插入新值
//        Node newHead = new Node("n",arr[2]);
//        arr[2] = newHead;
//        
////        Map.Entry<String,String> entry = new Map.Entry<>(k,v);
////        table[index] = entry;
////        table[index] = new Map.Entry<>(k,v,table[index]);
//
//        System.out.println(1 << 4);
//        System.out.println(1 >>> 2);
//        System.out.println(Integer.highestOneBit(10));
        
        Map<String,String> cmap = new ConcurrentHashMap<>();
        for (int i=0;;){
            if (i == 0){
                System.out.println("i = 1");
                i++;
                break;
            }
            
            if (i == 1){
                System.out.println("已经break");
            }
        }
    }
    
    
    
}

class Node{
    String value;
    Node next;

    public Node(String value,Node next) {
        this.value = value;
        this.next = next;
    }
}

class EntryNode{
    String value;
    EntryNode next;

    public EntryNode(String value,EntryNode next) {
        this.value = value;
        this.next = next;
    }
}
