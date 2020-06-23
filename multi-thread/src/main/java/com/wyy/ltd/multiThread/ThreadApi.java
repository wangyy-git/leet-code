package com.wyy.ltd.multiThread;

import java.util.concurrent.TimeUnit;

public class ThreadApi {

    private static Thread thread;
    private static boolean running = false;
    public static void main(String[] args) throws InterruptedException {
        run();
        TimeUnit.MILLISECONDS.sleep(100);
//        thread.interrupt();
        running = true;
    }
    public static void run() {
        thread = new Thread(new Runnable() {
//            boolean temp = running;
            public void run() {
                while (!running){}
            }
        });
        thread.start();
    }
}
