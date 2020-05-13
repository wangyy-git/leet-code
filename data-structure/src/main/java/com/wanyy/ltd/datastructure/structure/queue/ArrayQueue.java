package com.wanyy.ltd.datastructure.structure.queue;

import java.util.Arrays;

public class ArrayQueue {

    
    private int maxSize;
    //rear指向队列尾部，就是队列的最后一个数据
    private int rear = -1;
    //front指向的是头部的前一个位置
    private int front = -1;
    private int[] queue;
    
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        this.queue = new int[maxSize];
    }
    
    
    public ArrayQueue addQueue(int value){
       
        if (this.rear == this.maxSize - 1){
            throw new RuntimeException("存满了");
        }
        this.queue[++rear] = value;
        return this;
    }

    public int fetchQueue(){
        if (this.front >= this.rear) throw new RuntimeException("取完了");
        return this.queue[++this.front];
    }

    /**
     * for (int i=0;i<length;i++){
     *    queue[i] = this.queue[++front];
     * }
     * 前期在toString方法这里直接++this.front，导致报错
     */
    public String toString(){
        int rear = this.rear;
        int front = this.front;
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
