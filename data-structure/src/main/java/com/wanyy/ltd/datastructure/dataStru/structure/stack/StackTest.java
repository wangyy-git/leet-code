package com.wanyy.ltd.datastructure.dataStru.structure.stack;


public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(4);
        
        stack.push(1);
        stack.push(2);
        stack.iter();
        System.out.println(stack.pop());
        System.out.println("-------");
        stack.iter();
        System.out.println("============");
        Stack<String> s = new Stack<>(4);
        s.push("ma");
        s.push("x");
        s.push("me");
        s.iter();
        System.out.println("-------" + s.pop());
        s.iter();
    }
}
