package com.wyy.ltd.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {
    public static void main(String[] args) {
        ReadWriteLock rw = new ReadWriteLock();
        for (int i = 0; i < 10; i++) {
            final int v = i;            
            new Thread(()-> rw.put(v + (int)(Math.random()*100)),"W"+v).start();
            new Thread(rw::get,"R"+v).start();
        }
    }
    private int data = 0;//模拟数据
    ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    public void get() {
        rwLock.readLock().lock();
        System.out.println(Thread.currentThread().getName() + " ready to read ...");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " read -> " + data);
        rwLock.readLock().unlock();
    }
    public void put(int data) {
        rwLock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + " ready to write ...");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.data = data;
        System.out.println(Thread.currentThread().getName() + " write -> " + this.data);
        rwLock.writeLock().unlock();
    }
}
