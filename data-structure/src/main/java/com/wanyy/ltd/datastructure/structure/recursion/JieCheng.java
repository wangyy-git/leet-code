package com.wanyy.ltd.datastructure.structure.recursion;

public class JieCheng {

    public static void main(String[] args) {
        System.out.println(jicheng(20));
        
    }
    
    public static long jicheng(long n){
        if (n == 1){
            return n;
        } else {
            return n*jicheng(--n);
        }
    }
}
