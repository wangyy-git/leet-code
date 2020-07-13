package com.wyy.ltd.aqs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeapGCTest {

    public static void main(String[] args) throws InterruptedException {
        List<HeapGCTest> lt = new ArrayList<>();
        while (true){
            lt.add(new HeapGCTest());
            Thread.sleep(500);
        }
    }
    int x,y;
    public void reIntsruct(){
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i <1000; i++) {
            x=0;y=0;
            map.clear();
            Thread t1 = new Thread(() -> {
                int a = y;
                x = 1;
                map.put("a", a);
            });
            Thread t2 = new Thread(() -> {
                int b = x;
                y = 1;
                map.put("b", b);
            });
            t1.start();t2.start();
//            t1.join();t2.join();
        }
    }
}
