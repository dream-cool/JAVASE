package test;

import java.util.Scanner;

/**
 * @author ：clt
 * @Date ：Created in 16:42 2019/9/20
 */
public class Test2 {

    public String name = "name1";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入m");
        String m = sc.nextLine();
        System.out.println("请输入m1");
        String m1 = sc.nextLine();
    }

}

class Test21 extends Test2{

    public String name = "name2";

    public static void main(String[] args) {

        Test21 t = new Test21();
        System.out.println(t.name);

    }

}
