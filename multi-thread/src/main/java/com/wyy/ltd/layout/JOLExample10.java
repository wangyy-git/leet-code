package com.wyy.ltd.layout;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

public class JOLExample10 {
    static A a;
//    static int i = 0;
    public static void main(String[] args) throws Exception {
        TimeUnit.SECONDS.sleep(5);
        a= new A();
        new Thread(() -> {
            synchronized (a){
                out.println("t1 lock ing");
                out.println(ClassLayout.parseInstance(a).toPrintable());
            }
        }).start();
        Thread.sleep(7000);
        System.gc();
        synchronized (a){//a b c c+++
            out.println("main lock ing");
            out.println(ClassLayout.parseInstance(a).toPrintable());
        }
//        new Thread(() -> {
//            synchronized (a){
//                i++;
//                out.println("t2 lock ing");
//                out.println(ClassLayout.parseInstance(a).toPrintable());
//            }
////        }).start();
//        out.println("after lock");
//        out.println(ClassLayout.parseInstance(a).toPrintable());
    }
}
