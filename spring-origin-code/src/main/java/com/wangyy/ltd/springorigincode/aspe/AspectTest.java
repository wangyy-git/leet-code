package com.wangyy.ltd.springorigincode.aspe;

import org.springframework.stereotype.Component;

@Component
public class AspectTest implements AopInterface {
    
    public void print(){
        System.out.println("aspect ....");
    }

    public void print(String args){
        System.out.println("aspect .... " + args);
    }
}
