package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过反射API动态地操作：构造器、方法、属性
 */

public class RefTest3 {
    public static void main(String[] args) {
        String path="reflection.User";
        try {
            Class cls=Class.forName(path);
            //通过反射API调用构造方法、构造对象
            User u=(User)cls.newInstance();//调用了无参构造方法
            System.out.println(u);
            Constructor<User> c=cls.getDeclaredConstructor(int.class,int.class,String.class);
            User u2=c.newInstance(1001,10,"陈留涛");
            System.out.println(u2);
            System.out.println(u2.getUname());
            //通过反射API调用普通方法
            User u3= (User) cls.newInstance();
            Method method=cls.getDeclaredMethod("setUname", String.class);
            method.invoke(u3,"陈涛");
            System.out.println(u3.getUname());
            //通过反射API操作属性
            Field field=cls.getDeclaredField("tel");
            Field f=cls.getDeclaredField("uname");
            f.setAccessible(true);
            f.set(u2,"涛");
            field.set(u2,"151");
            System.out.println(u2.getUname());
            System.out.println(u2.tel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
