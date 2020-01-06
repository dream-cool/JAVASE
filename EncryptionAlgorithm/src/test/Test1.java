package test;

/**
 * @author ：clt
 * @Date ：Created in 16:20 2019/9/20
 */
public class Test1 {

    public static void main(String[] args) {
//        ()nn.test();

        String s1 = "hello";
        String s2 = "he" + new String("llo");
        String s3 = "he" + "llo";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        int i;
        int count = 0;
        for (i = 1; i > 0; i = i + i) {
            count++;
        }

        System.out.println(i+ "---------" +count);
        System.err.println("1111");

        byte b = 126;
        System.out.println(b++);
        System.out.println(b++);
        System.out.println(b++);
        System.out.println(b++);
        b += 254;
        System.out.println(b);
    }

    public static void test(){
        System.out.println("test");
    }
}
