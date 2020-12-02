package com.wangyy.ltd.springorigincode.proxy.mybatis;

//import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBatisProxyFactory {
    //这里传进来的就是被代理的接口类
//    public Object getMapper(Class clazz){
//        Class[] classes = new Class[]{clazz};
//        Object o = Proxy.newProxyInstance(MyBatisProxyFactory.class.getClassLoader(), 
//                classes, new MyInvocationHandler());
//        
//        return o;
//    }
}
//class MyInvocationHandler implements InvocationHandler{
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println("实现代理连接数据库");
//        System.out.println(proxy.getClass());//com.sun.proxy.$Proxy0
//        Select annotation = method.getAnnotation(Select.class);
//        String sql = annotation.value()[0];
//        System.out.println(sql);
//        return null;
//    }
//}