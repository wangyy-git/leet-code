package com.wyy.ltd.aqs;

import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class SpinLock {
    //表示是否有代码在同步块
    volatile int status = 0;
    Queue<Thread> parkQueue;
    void lock(){
        while (!compareAndSet(0,1)){
            park();
        }
        //执行lock操作
        
    }
    void unlock(){
        lock_notify();
    }
    boolean compareAndSet(int except,int newValue){
        //执行CAS操作
        return true;
    }
    void park(){
        //将当前线程加入等待队列
        parkQueue.add(Thread.currentThread());
        //当前线程释放CPU 阻塞
        releaseCpu();
    }
    void lock_notify(){
        //获取当前队列第一个线程 头部线程
        Thread thread = parkQueue.poll();
        //唤醒等待线程
        unpark(thread);
    }
    
    void releaseCpu(){}
    void unpark(Thread t){}
}
