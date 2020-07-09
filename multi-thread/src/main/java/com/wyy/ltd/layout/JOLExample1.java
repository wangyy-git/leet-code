package com.wyy.ltd.layout;

public class JOLExample1 {
    
    public static void main(String[] args) {
        JOLExample1 j1 = new JOLExample1();
        //jvm的信息
        Ticket ticket = new Ticket();
        
        new Thread(ticket,"t1").start();
        new Thread(ticket,"t2").start();
        new Thread(ticket,"t3").start();
        
        
    }
    
    
}
class Ticket implements Runnable{

    int count = 10;

    @Override
    public void run() {
        while (true){
            synchronized (this){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (count>0){
                    System.out.println(Thread.currentThread().getName() + " sell票 -> " + count--);
                }
            }
        }
    }
//    int ticket  = 10;
//    public void run() {
//        //method(); //method是实现了同步方法，可以解决火车票出现的问题，
//        while(true) {
//            synchronized (this) {  //也可以在run()里面采用同步代码块的形式，来解决出现的异常
//                if(ticket > 0) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + " sell票 -> " + count--);
//                }
//            }
//        }
//
//    }
}
