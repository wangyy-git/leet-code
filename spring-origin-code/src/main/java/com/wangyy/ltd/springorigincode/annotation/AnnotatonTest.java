package com.wangyy.ltd.springorigincode.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@MyClassAnnotation("aa")
public class AnnotatonTest {

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public AnnotatonTest() {
        super();
    }

    public static void main(String[] args) throws Exception {
        List<Person> people = new ArrayList<>();
        people.add(new Son("",1));
        
        List<Son> sons = new ArrayList<>();
//        sons.add(new Person());

    }
    
    
    public void test(Map<String,Person> map){
        System.out.println("test ");
    }
}

@MyClassAnnotation("class")
class Person{
    
    @MyFieldAnnotation("field")
    private String a;
    int b;

    public Person() {
    }

    public Person(String a, int b) {
        this.a = a;
        this.b = b;
        System.out.println(a + " --> " + b);
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getA() {
        return a;
    }
}

class Son extends Person{
    static {
        System.out.println("Son 静态代码块");
    }

    public Son(String a, int b) {
        super(a, b);
    }
}

