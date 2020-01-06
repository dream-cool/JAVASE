package com.dynamiccompile.clt;

import com.sun.org.apache.xpath.internal.operations.String;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Demo {
    public static void main(String[] args) throws Exception {
        URL[] urls=new URL[]{new URL("file:/"+"F:/mytest/")};
        URLClassLoader loader=new URLClassLoader(urls);
        Class c=loader.loadClass("HelloWorld");
        //调用加载类main方法
        Method m=c.getMethod("main",String[].class);
        m.invoke(null,(Object)new String[]{});
    }
}
