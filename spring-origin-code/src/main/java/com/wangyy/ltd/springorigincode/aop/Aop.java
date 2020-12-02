package com.wangyy.ltd.springorigincode.aop;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//@Aspect
//@Component
public class Aop {

    @Before("execution(* com.wangyy.ltd.springorigincode.aspe.*.print*(..)) && args(args,..)")
    public void printAop(String args){
        System.out.println("aop before agrs -->" + args);
    }
    
    
    @Pointcut("within(com.wangyy.ltd.springorigincode.aspe.*)")
    public void pointCut(){}
    
    
    @Before("pointCut()")
    public void pointCutWithIn(){
        System.out.println("within ....");
    }
}
