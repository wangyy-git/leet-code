package com.wyy.ltd.layout;
import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

public class JOLExample12 {
    
    static volatile List<A> list = new ArrayList<A>();
    public static void main(String[] args) throws Exception {
        TimeUnit.SECONDS.sleep(5);
        Thread t1 = new Thread(() -> {
            for (int i=0;i<40;i++){
                A a = new A();
                
                synchronized (a){
                    if (i == 30){
                        try {
                            TimeUnit.SECONDS.sleep(100);
                        } catch (InterruptedException e) {
                            
                        }
                    }
                    list.add(a); 
                }
            }
        });
        t1.start();
//        t1.join();
        
        out.println("befre t2");
        while (true){
            if (list.size() == 30) break;
            out.println(list.size());
            TimeUnit.SECONDS.sleep(1);
        }
//        out.println(ClassLayout.parseInstance(list.get(18)).toPrintable());
        out.println("t1 25 --> ");
//        out.println(ClassLayout.parseInstance(list.get(25)).toPrintable());
        Thread t2 = new Thread() {
            int k=0;
            public void run() {
                for(A a:list){
                   synchronized (a){
                       out.println("t2 ing" + k);
                       if (k==30){
                           out.println("t2 ing");
                           out.println(ClassLayout.parseInstance(a).toPrintable());
                       }
                   }k++;
                }
            }
        };
        t2.start();
    }
}