package com.wanyy.ltd.datastructure.structure.queue;

/**
 * 环形队列
 * eg：0 1 2 3 ：maxSize=3  当3这个位置放数据以后再放就是0这个位置
 * front：初始值0，指向队列的第一个元素的当前位置
 * rear： 初始值0，指向队列后一个元素的后面一个位置
 */
public class CircleArrayQueue {

    private int maxSize;
    private int rear;
    private int front;
    private int[] queue;
    
    public CircleArrayQueue(int maxSize){
        this.maxSize = maxSize;
        queue = new int[maxSize];
    }
    
    public void addQueue(int value){
        //在上一次放过之后 再次放入要验证是否已满
        if (isFull()){
            System.out.println("放满了");
            return;
        }
        queue[rear] = value;
        rear = (rear+1) % maxSize;
    }
    
    public int fetchQueue(){
        if (isEmpty()){
            throw new RuntimeException("没有了");
        }
        int front = this.front;
        this.front = (this.front + 1) % maxSize;
        return queue[front];
    }
    private boolean isFull(){
        return (rear+1)%maxSize == front;
    }
    
    private boolean isEmpty(){
        return front == rear;
    }
}
