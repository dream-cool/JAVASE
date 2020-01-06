package reflection;

/**
 * 测试java.lang.Class对象的获取方式
 */
public class RefTest1 {
    public static void main(String[] args) {
        String path="reflection.User";
        try {
            Class cls=Class.forName(path);
            System.out.println(cls);
            System.out.println(cls.hashCode());
            Class cls2=Class.forName(path);
            System.out.println(cls2);
            System.out.println(cls2.hashCode());
            Class scls1=String.class;
            Class scls2=path.getClass();
            System.out.println(scls1);
            System.out.println(scls2);

            int[] arr1=new int[10];
            int[] arr2=new int[20];
            System.out.println(arr1.getClass().hashCode());
            System.out.println(arr2.getClass().hashCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
