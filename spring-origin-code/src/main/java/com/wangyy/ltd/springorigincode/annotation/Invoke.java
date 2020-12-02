package com.wangyy.ltd.springorigincode.annotation;

import java.lang.reflect.Field;

public class Invoke<T> {
    
    public void setGeneric(T t){
        Class clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
    }

    public static void main(String[] args) {
        Invoke<Person> invoke = new Invoke<>();
        invoke.setGeneric(new Person());
    }
}
