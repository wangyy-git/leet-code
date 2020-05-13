package com.wanyy.ltd.datastructure.structure.queue;

public class QueueTest {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        queue.addQueue(1);
        queue.addQueue(2);
        queue.addQueue(3);
        
        System.out.println("fetch -> " + queue.fetchQueue());
        System.out.println(queue.toString());
        System.out.println("fetch -> " + queue.fetchQueue());
        System.out.println("fetch -> " + queue.fetchQueue());
//        System.out.println("fetch" + queue.fetchQueue());
//        queue.addQueue(3);
        System.out.println(queue.toString());
    }
}
