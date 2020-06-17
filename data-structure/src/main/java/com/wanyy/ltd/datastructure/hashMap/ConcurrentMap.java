package com.wanyy.ltd.datastructure.hashMap;

import sun.misc.Unsafe;
import sun.reflect.Reflection;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

public class ConcurrentMap {

    private static sun.misc.Unsafe UNSAFE;
    private static  Long AGE_OFFSET;
    
    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            UNSAFE = (Unsafe) field.get(null);
            //获取Person对象的age字段的偏移量
            AGE_OFFSET = UNSAFE.objectFieldOffset(Person.class.getDeclaredField("age"));
        } catch (NoSuchFieldException | IllegalAccessException e){
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        Person person = new Person();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    //实现直接操作内存中的值而不是线程内存缓存的值 保证线程安全
                    //CAS操作 先比较 后计算
                    // 先比较内存中的person.age一致后计算 ++ 
                    boolean b = UNSAFE.compareAndSwapInt(person, AGE_OFFSET, person.age, person.age+1);
                    
//                    person.age++;
                    if(b)
                    System.out.println(Thread.currentThread().getName() + " ->" + UNSAFE.getIntVolatile(person,AGE_OFFSET));
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
              }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
//                    person.age++;
                    boolean b = UNSAFE.compareAndSwapInt(person, AGE_OFFSET, person.age, person.age+1);
//                    System.out.println(b);
                    if(b)
                    System.out.println(Thread.currentThread().getName() + " ->" + UNSAFE.getIntVolatile(person,AGE_OFFSET));
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
class Person{
    //Integer UNSAFE无法操作
    int age = 0;
    
    static {
//        Class<?> callerClass = Reflection.getCallerClass();
//        System.out.println("callerClass" + callerClass);
    }
}