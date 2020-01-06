package com.test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class Demo1 {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {
        //获得脚本引擎对象
        ScriptEngineManager sem= new ScriptEngineManager();
        ScriptEngine engine=sem.getEngineByName("javascript");
        //定义变量，存储到引擎上下文中
        engine.put("msg","good");
        String str = "var user = {name:'clt',age:18 ,schools:['清华大学','北京大学']};";
        str += "print(user.name);";
        engine.eval(str);

        engine.eval("msg = 'bad';");
        System.out.println(engine.get("msg"));
        System.out.println("#######################");

        //定义函数
        engine.eval("function add(a,b){var sum=a+b; return sum;}");
        //取得调用接口
        Invocable jsInvoke =(Invocable) engine;
        //执行脚本中定义的函数
        Object result =jsInvoke.invokeFunction("add",new Object[]{13,20});
        System.out.println(result);

        //执行js文件
        URL url=Demo1.class.getClassLoader().getResource("a.js");
        FileReader fileReader =new FileReader(url.getPath());
        engine.eval(fileReader);
        fileReader.close();

    }
}
