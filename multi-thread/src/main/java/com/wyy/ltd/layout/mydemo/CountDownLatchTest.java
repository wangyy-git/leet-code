package com.wyy.ltd.layout.mydemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
 
    static CountDownLatch latch = new CountDownLatch(1);
    public static void main(String[] args) throws InterruptedException {
        runPool();
    }

    static CountDownLatch latch2 = new CountDownLatch(10);
    private static void runPool() throws InterruptedException {
        ExecutorService ser = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            ser.execute(()->{
                try {
                    TimeUnit.SECONDS.sleep(5); 
                } catch (InterruptedException e) {}
                System.out.println(Thread.currentThread().getName() + " -> " + finalI);
                latch2.countDown();
            });
        }
        latch2.await();
        System.out.println("shut");
//        ser.shutdownNow();

    }
    private static void runTogether() throws InterruptedException {
        new Thread(()->{
            try {
//                latch.await();
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1");
            latch.countDown();
        }).start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2");
            latch.countDown();
        }).start();
        new Thread(()->{
            try {
//                latch.await();
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3");
            latch.countDown();
        }).start();
        latch.await();
        System.out.println("end");
    }
    
    static List<String> a = new ArrayList<>();
    static {
        for (int i = 0; i < 9; i++) {
            a.add("a" + i);
        }
    }
    private static void test(){
        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 9; i++) {
            int finalI = i;
            service.execute(()->{
                System.out.println(Thread.currentThread().getName() + a.get(finalI));
                a.add(a.get(finalI) + "exe");
            });
        }
//        for (String s:a) {
//            
//        }
    }
}
