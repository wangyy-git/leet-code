package com.wanyy.ltd.datastructure.dataStru.structure.queue;

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
     * 实现初始数组的环形使用
     */
    public int fetchRoundQueue(){
        if (this.front >= this.rear) throw new RuntimeException("取完了");
        int head = this.queue[0];
        
        for (int i=1;i<queue.length;i++){
            this.queue[i-1] = this.queue[i];
        }
//        if (rear - 1 >= 0) System.arraycopy(this.queue, 0, this.queue, 1, rear - 1);
        rear--;
        return head;
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
//        if (rear<0) return "[]";
        int length = rear - front;
        int[] queue = new int[length];
        for (int i=0;i<length;i++){
            queue[i] = this.queue[++front];
        }
        System.out.println("queue -> " + Arrays.toString(this.queue));
        return "queue array -> " + Arrays.toString(queue);
    }
    
}
