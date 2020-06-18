package com.wanyy.ltd.datastructure.hashMap;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * UNSAFE实现CAS
 */
public class Person {
    int i = 0;
    private static sun.misc.Unsafe UNSAFE;
    private static long I_OFFSET;
    private String[] talbe = {"测试", "2", "3", "4", "4"};
    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            UNSAFE = (Unsafe) field.get(null);
            I_OFFSET = UNSAFE.objectFieldOffset(Person.class.getDeclaredField("i"));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        final Person person = new Person();
        
        //数组中存储的对象的对象头大小 //获取数组中一个元素的大小
        int ns = UNSAFE.arrayIndexScale(String[].class);  
        //数组中第一个元素的起始位置
        int base = UNSAFE.arrayBaseOffset(String[].class);

        System.out.printf("ns : %d  base : %d",ns,base);
        System.out.println(UNSAFE.getObject(person.talbe, base+1*ns));
//
//        int j = 3;
//        System.out.println(j << (31 - Integer.numberOfLeadingZeros(ss)));
//        System.out.println(j*ss);

    }

}
