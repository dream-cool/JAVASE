package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *应用反射的API 获取类的信息（类的名字、属性、方法、构造器）
 */

public class RefTest2 {
    public static void main(String[] args) {
        String path="reflection.User";
        try {
            Class cls=Class.forName(path);
            //获取类的名字
            System.out.println(cls.getName());//获取类名+包名
            System.out.println(cls.getSimpleName());//获取类名User
            //获取属性信息
            Field[] fields1=cls.getFields();//只能获取public属性
            Field[] fields2=cls.getDeclaredFields();
            System.out.println(fields2.length);
            Field f=cls.getDeclaredField("uname");
            for (Field temp:fields2
                 ) {
                System.out.println("属性："+temp);
            }
            //获取方法信息
            Method[] methods=cls.getMethods();//获取public方法
            Method method1=cls.getDeclaredMethod("getUname",null);
            Method method2=cls.getDeclaredMethod("setUname", String.class);
            for (Method m:methods
                 ) {
                System.out.println("方法："+m);
            }
            Constructor[] constructors=cls.getDeclaredConstructors();
            Constructor constructor1=cls.getDeclaredConstructor(null);
            Constructor constructor2=cls.getDeclaredConstructor(int.class,int.class,String.class);
            for (Constructor c:constructors
                 ) {
                System.out.println("构造器:"+c);
            }



            //获取构造器信息
        } catch (ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
