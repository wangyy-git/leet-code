package com.wyy.ltd.layout;
import org.openjdk.jol.info.ClassLayout;

import static java.lang.System.out;

public class JOLExample11 {
    static A a;
    public static void main(String[] args) throws Exception {
        //Thread.sleep(5000);
        a = new A();
        out.println("before lock");
        out.println(ClassLayout.parseInstance(a).toPrintable());

        Thread t1= new Thread(() -> {
            synchronized (a){
                try {
                    synchronized (a) {
                        out.println("before wait");
                        out.println(ClassLayout.parseInstance(a).toPrintable());
                        a.wait();
                        out.println(" after wait");
                        out.println(ClassLayout.parseInstance(a).toPrintable());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        Thread.sleep(4000);
        synchronized (a) {
            a.notifyAll();
        }
//        t1.join();
//        out.println(" after notify");
//        out.println(ClassLayout.parseInstance(a).toPrintable());
        
    }
}