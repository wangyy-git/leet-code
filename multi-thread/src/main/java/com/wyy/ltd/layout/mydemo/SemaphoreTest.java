package com.wyy.ltd.layout.mydemo;

import java.util.concurrent.*;

public class SemaphoreTest {
    public static void main(String[] args) throws InterruptedException {
        SemaphoreTest test = new SemaphoreTest();
        test.tryAcq();
        System.out.println("main ... ...");
        
    }

    ExecutorService service = Executors.newFixedThreadPool(5);
    Semaphore semaphore = new Semaphore(3);
    public void test() throws InterruptedException {
        for (int i = 0; i < 12; i++) {
            final int k = i;
            service.execute(()->{
                try {
                    semaphore.acquire();
                    tt(k);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
//        if(semaphore.tryAcquire()){
//            
//        }
//        semaphore.acquire();
//        service.shutdownNow();
//        semaphore.release();
        
    }

    public void tryAcq(){
        for (int i = 0; i < 12; i++) {
            final int k = i;
            service.execute(()->{
                try {
                    if (semaphore.tryAcquire(3)){
                        tt(k);
                        semaphore.release(3);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        service.shutdownNow();
//        if(semaphore.tryAcquire()){
//            
//            semaphore.release();
//        }
    }
    
    public void tt(int k) throws InterruptedException {
//        TimeUnit.SECONDS.sleep(1);
        System.out.println(k + " -> " + System.currentTimeMillis());
    }
}
