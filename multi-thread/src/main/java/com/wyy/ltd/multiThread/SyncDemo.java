package com.wyy.ltd.multiThread;

import java.util.concurrent.TimeUnit;

public class SyncDemo {

    Object o = new Object();
    
    static {
        //本地方法C文件变异成.so文件对应的文件名
        System.loadLibrary("GetOSThraedIdNative");
    }
    //执行结果为 t1 t2两个线程轮流获取锁 依次执行
    public static void main(String[] args) {
        SyncDemo sync = new SyncDemo();
        sync.start();
        
    }
    //因为这两个匿名内部类 所以字节码文件是三个
    public void start(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    sync();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sync();
            }
        });
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
    
    //因为无法通过java代码获取OS层面的线程ID进行比较 所以增加一个本地方法
    public native void getOSThraedId();
    public void sync(){
        synchronized (o){
            getOSThraedId();
            System.out.println(Thread.currentThread().getName());
        }
        
    }
}
