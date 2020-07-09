package com.wyy.ltd.layout.mydemo;

import com.wyy.ltd.layout.A;
import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
 
    static CountDownLatch latch = new CountDownLatch(1);
    public static void main(String[] args) throws InterruptedException {
        CountDownLatchTest t = new CountDownLatchTest();
        t.runTogether();
//        runTogether();
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
    static A a = new A();
    private void runTogether() throws InterruptedException {
        new Thread(()->{
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            run();
        }).start();
        new Thread(()->{
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            run();
        }).start();
        new Thread(()->{
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            run();
        }).start();
        latch.countDown();
        System.out.println("end");
    }
    
    static List<String> list = new ArrayList<>();
    static {
        for (int i = 0; i < 9; i++) {
            list.add("a" + i);
        }
    }
    private static void test(){
        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 9; i++) {
            int finalI = i;
            service.execute(()->{
                System.out.println(Thread.currentThread().getName() + list.get(finalI));
                list.add(list.get(finalI) + "exe");
            });
        }
//        for (String s:a) {
//            
//        }
    }

    private int tickets = 10;

    public synchronized void run() {
        while (true) {
            if (tickets > 0) {
//                System.out.println("还剩余票:" + tickets + "张");
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tickets--;
                System.out.println(Thread.currentThread().getName() + "卖出第" + tickets + "张");
            } else {
                System.out.println("余票不足,暂停出售!");
//                wait，notify和notifyAll只能在同步控制方法或者同步控制块里面使用，而sleep可以在任何地方使用
                try {
                    Thread.sleep(1000 * 60 * 5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
