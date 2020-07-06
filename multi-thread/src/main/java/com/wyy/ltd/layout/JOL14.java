package com.wyy.ltd.layout;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

public class JOL14 {

    static A a;
    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        a = new A();
        System.out.println("before ...");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        
        Thread t1 = new Thread(()->{
            synchronized (a){
                System.out.println(ClassLayout.parseInstance(a).toPrintable());
            }
        });
        t1.start();t1.join();

        Thread t2 = new Thread(()->{
            synchronized (a){
                System.out.println(ClassLayout.parseInstance(a).toPrintable());
            }
        });
        t2.start();t2.join();

        Thread t3 = new Thread(()->{
            synchronized (a){
                System.out.println("3");
                System.out.println(ClassLayout.parseInstance(a).toPrintable());
            }
        });
        t3.start();
//        t3.join();
//
//        Thread t4 = new Thread(()->{
//            synchronized (a){
//                System.out.println("4");
//                System.out.println(ClassLayout.parseInstance(a).toPrintable());
//            }
//        });
//        t4.start();
    }
}
