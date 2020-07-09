package com.wyy.ltd.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockApi {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("park t1 before ..");
            LockSupport.park();
            System.out.println("park notify t1 ...");
        });
        t1.start();
        ReentrantLock reentrantLock = new ReentrantLock();
        
        reentrantLock.unlock();
        System.out.println("main notify t1 ... ");
        TimeUnit.SECONDS.sleep(5);
        //唤醒t1
        LockSupport.unpark(t1);
        TimeUnit.SECONDS.sleep(2);
        System.out.println("main notify t1 after ... ");
    }
}
