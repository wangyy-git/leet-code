package com.wanyy.ltd.datastructure.dataStru.structure.queue;

public class QueueTest {
    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(3);
        queue.addQueue(0);
        queue.addQueue(1);
        queue.addQueue(2);
        
//        System.out.println("fetch -> " + queue.fetchQueue());
//        System.out.println(queue.toString());
//        System.out.println("fetch -> " + queue.fetchQueue());
//        System.out.println("fetch -> " + queue.fetchQueue());
//        System.out.println("fetch" + queue.fetchQueue());
//        queue.addQueue(3);
        System.out.println("fetch -> " + queue.fetchQueue());
        System.out.println("fetch -> " + queue.fetchQueue());
        System.out.println("fetch -> " + queue.fetchQueue());
        System.out.println(queue.toString());
    }
}
