package com.wangyy.ltd.springorigincode.annotation;

import java.util.ArrayList;
import java.util.List;

public class InterfTest {
    public static void main(String[] args) {
        List<a> aList = new ArrayList<>();
        aList.add(new A());
        aList.add(new B());

        System.out.println(new A() instanceof b);
    }
}

interface a{}
interface b extends a{}
class B implements b{}
class A implements a{}