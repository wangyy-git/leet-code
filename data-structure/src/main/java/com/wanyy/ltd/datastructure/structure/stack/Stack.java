package com.wanyy.ltd.datastructure.structure.stack;

public class Stack<T> {
    private int maxSize = 8;
    private int top = -1;
    private Object[] array;;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        array = new Object[maxSize];
    }
    
    public Stack(){
        array = new Object[maxSize];
    }

    boolean isFull(){
        return top == maxSize-1;
    }
    
    boolean isEmpty(){
        return top == -1;
    }

    public void push(T value){
        if (isFull()){
            System.out.println("已经要溢出了");
            return;
        }
        array[++top] = value;
    }
    
    @SuppressWarnings("unchecked")
    public T pop(){
        if (isEmpty()) {
            throw new RuntimeException("一滴也没有了。。。");
        }
        return (T)array[top--];
    }

    public void iter(){
        for (int i=0;i<=top;i++){
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
    
    
}
