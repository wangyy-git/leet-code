package com.wyy.ltd.layout.mydemo;

import com.wyy.ltd.layout.A;
import com.wyy.ltd.layout.B;
import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 验证一下重偏向两个参数 批量重偏向
 * BiasedLockingBulkRebiasThreshold =20 偏向锁批量重偏向阈值
 * BiasedLockingBulkRevokeThreshold =40 偏向锁批量撤销的阈值
 */
public class BiasVerify {
    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        final List<A> listA = new ArrayList<>();
        List<B> listB = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listA.add(new A());
            listB.add(new B());
        }
        
        new Thread(() -> {
            for (A a:listA){
                synchronized (a){
                    if (a == listA.get(10)){
                        System.out.println("t1线程 i=10 -->");
                        System.out.println(ClassLayout.parseInstance(a).toPrintable());
                    }
                }
            }
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();
        TimeUnit.SECONDS.sleep(5);
        //此处应该还是偏向 因为偏向锁退出不撤销
        System.out.println("main 线程 -->");
        System.out.println(ClassLayout.parseInstance(listA.get(10)).toPrintable());
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                A a = listA.get(i);
                if (i == 20) a = listA.get(9);
                synchronized (a){
                    if (a == listA.get(10)){
                        //应该是轻量级锁
                        System.out.println("t2线程 i=0 预期为轻量级锁-->");//因为1已经变成轻量级锁然后释放 所以此处是无锁状态
                        System.out.println(ClassLayout.parseInstance(listA.get(1)).toPrintable());
                        System.out.println("t2线程 i=10 -->");//轻量级锁
                        System.out.println(ClassLayout.parseInstance(a).toPrintable());
                    }
                    if (a == listA.get(19)){
                        System.out.println("撤销20次 t2线程 i=10 -->");
                        System.out.println(ClassLayout.parseInstance(listA.get(10)).toPrintable());
                        System.out.println("撤销20次 t2线程 i=19 应为重偏向 -->");
                        System.out.println(ClassLayout.parseInstance(a).toPrintable());
                        System.out.println("撤销20次 t2线程 i=40 还未撤销但应也为重偏向 -->");//还是偏向t1
                        System.out.println(ClassLayout.parseInstance(listA.get(40)).toPrintable());
                    }
                    
                    if (i == 20){
                        System.out.println("撤销20次 t2线程 i=20 此处获取的是index = 9");
                        System.out.println(ClassLayout.parseInstance(a).toPrintable());
                    }

//                    if (i == 45){
//                        System.out.println("撤销20次 t2线程 i=40 还未撤销但应也为重偏向 -->");
//                        System.out.println(ClassLayout.parseInstance(listA.get(40)).toPrintable());
//                        System.out.println("撤销45次 t2线程 i=45");
//                        System.out.println(ClassLayout.parseInstance(a).toPrintable());
//                    }
                }
            }
        },"t2").start();
        TimeUnit.SECONDS.sleep(10);
        new Thread(()->{
            for (int i = 30; i < 100; i++) {
                A a = listA.get(i);
                if (i == 50){
                    System.out.println("撤销20次 t3线程 i=20 此处获取的是index = 9");
                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
                }

                if (i == 70){
                    System.out.println("撤销20次 t3线程 i=20 此处获取的是index = 9");
                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
                }


            }
        }).start();
        TimeUnit.SECONDS.sleep(10);
    }
}
