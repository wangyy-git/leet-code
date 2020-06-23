package com.wyy.ltd.multiThread;

public class MultiThreadDemo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start0 核心方法");
            }
        }).start();
    }
}
