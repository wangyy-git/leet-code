package com.wanyy.ltd.datastructure.structure.stack;

public class Stack<T> {
    private int maxSize;
    private int top = -1;
    private Object[] array;;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        array = new Object[maxSize];
    }

    boolean isFull(){
        return top == maxSize-1;
    }
    
    boolean isEmpty(){
        return top == -1;
    }
    
    void push(T value){
        if (isFull()){
            System.out.println("已经要溢出了");
            return;
        }
        array[++top] = value;
    }
    
    @SuppressWarnings("unchecked")
    T pop(){
        if (isEmpty()) {
            throw new RuntimeException("一滴也没有了。。。");
        }
        return (T)array[top--];
    }
    
    void iter(){
        for (int i=0;i<=top;i++){
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
    
    
}
