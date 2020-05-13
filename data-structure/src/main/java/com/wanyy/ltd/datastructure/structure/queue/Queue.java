package com.wanyy.ltd.datastructure.structure.queue;

import java.util.Arrays;

public class Queue {

    
    private int maxSize;
    private int rear = -1;
    private int front = -1;
    private int[] queue;
    
    public Queue(int maxSize){
        this.maxSize = maxSize;
        this.queue = new int[maxSize];
    }
    
    
    public Queue addQueue(int value){
//        System.out.println(rear);
        ++this.rear;
        if (this.rear == this.maxSize - 1){
            throw new RuntimeException("存满了");
        }
        System.out.println("front -> " + front);
        this.queue[this.rear] = value;
        return this;
    }

    public int fetchQueue(){
        if (this.front == this.rear) throw new RuntimeException("取完了");
        return this.queue[++this.front];
    }

    public String toString(){
        if (rear<0) return "[]";
        int length = rear - front;
        int[] queue = new int[length];
        for (int i=0;i<length;i++){
            queue[i] = this.queue[++front];
        }
        System.out.println("queue -> " + Arrays.toString(this.queue));
        return "queue array -> " + Arrays.toString(queue);
    }
    
}
