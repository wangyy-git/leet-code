package com.wyy.ltd.multiThread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class SellTicket {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);
        TicketWindow tw = new TicketWindow();
        Thread t1 = new Thread(()->{
            try {
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 20; i++) {
                tw.sell();
            }
        }, "A 窗口");
        Thread t2 = new Thread(()->{
            try {
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 20; i++) {
                tw.sell();
            }
        }, "C 窗口");
        Thread t3 = new Thread(()->{
            try {
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 20; i++) {
                tw.sell();
            }
        }, "B 窗口");
        t1.start();
        t2.start();
        t3.start();
    }
}

class TicketWindow {
    private int count = 200;
    public synchronized void sell(){
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        if (count > 0){
            System.out.println(Thread.currentThread().getName() + " sell ->" + count--);
        }
    }
}
