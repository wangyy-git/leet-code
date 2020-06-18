package com.wanyy.ltd.datastructure.hashMap;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                lock.lock();
                System.out.println("线程1获取到锁" + System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(2);
                lock.unlock();
            }
        }).start();
        
        //保证上面一定成功
        TimeUnit.SECONDS.sleep(1);
        
        new Thread(() -> {
//            lock.lock(); //就会阻塞住等上面释放锁
            //
            while (!lock.tryLock()){
                //可以处理其他逻辑
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("try ... ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程2获取到锁" + System.currentTimeMillis());
            lock.unlock();
        }).start();
    }
}
