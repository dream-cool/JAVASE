import java.util.*;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 8:21 2019/6/15
 */
public class Test {

    public static void main(String[] args) {
//        int[] arr = {1,1,23,1,1,2,2,2,2,1};
//        System.out.println(MoreThanHalfNum_Solution(arr));(2,3),(2,4),(2,5),(3,4),(3,5),(4,5),(5,3)
        test14();
    }


    public static int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer,Integer> map = new HashMap<>(array.length);
        for (int i = 0; i < array.length; i++){
            Integer count = map.get(array[i]);
            map.put(array[i], count == null ? 1: ++count);
            if (map.get(array[i]) > array.length/2){
                return array[i];
            }
        }
        return 0;
    }

    public static void test(){
        for (int i = 0; i < 100; i++) {
            for (int j = 1; j < 100; j++) {
                if ((i & j) == 0){
                    System.out.println(i+"\t"+j);
                }
                j = j*j;
            }
        }
    }

    public static void test1(){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        String[] strs = new String[m];
        for(int i = 0; i < m; i++){
            strs[i] = sc.next();
        }
        System.out.println(strs.length);
    }

    public static void test2(){
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2= new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set2.add(1);
        set2.add(2);
        set2.add(3);

        for (Integer i:set1 ) {
            System.out.println(i);
        }
    }

    public static void test3(){
        System.out.println(Math.pow(0,0));

    }

    public static void test4(){
        for (int i = 0; i < 100; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; i < 10; i++) {
                Random random = new Random();
                sb.append((char)random.nextInt(656));
                System.out.print(sb.toString()+"\t");
                System.out.println(sb.toString().hashCode());
            }
        }
    }

    public static void test5(){
        String x = String.valueOf('a');
        String y = String.valueOf('b');
        System.out.println(x instanceof String);
//        Integer.parseInt(x);
        Integer.parseInt("1");
//        Integer.parseInt(y);
        System.out.println(x + 3);
//        Integer x = Integer.parseInt(String.valueOf('a'));
//        Integer y = Integer.parseInt(String.valueOf('b'));
        System.out.println(x);
        System.out.println(y);
    }

    public static void test6(){
        String str = "455+(654-15)*45+45/45*45/131";
//        String str = "454+153+455+4545+54";
        String[] strs = str.split("\\+|\\-|\\*|\\/|\\(|\\)");
        System.out.println(strs.length);
    }

    public static void test7(){
        System.out.println((double)1/3);
    }

    public static void test8(){
//        int[] a = {1,2,3};
//        int[] b = {1,2,3};
//        System.out.println(a == b);
//        System.out.println(a.hashCode());
//        System.out.println(b.hashCode());
//        System.out.println(a);
//        System.out.println(b);
//        Integer i1 = new Integer(1000);
//        System.out.println(i1.hashCode());
//        Integer i2 = new Integer(1000);
//        System.out.println(i2.hashCode());
//        Integer i3 = new Integer(1000);
//        System.out.println(i3.hashCode());
//        System.out.println(i2== i1);
//        System.out.println(i2== i3);
//        System.out.println(i3== i1);
//        StringBuilder sb = new StringBuilder("123456");
//        String s = "123456";
//        System.out.println(sb.toString() == "1234567");
        String a=new String("haha");
        String b =new String("haha");
        char c [ ] ={'h','a','a','a'};
        System.out.println(b.equals(c));
    }

    public static void test9(){
        String String = "111";
        int num = 50;
        num = num++*2;
        System.out.println(num);

        int x =  2 ;
         x += 2L;
        long n = 100 + x;

    }

    public static void test10(){
        String[] strings = {"1","123","12","13","111"};
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));
    }

    public static int test11(){
        int a = 1;
        a++;
        return a;
    }

    public static void test12(){
        String str = "123";
        System.out.println(str.charAt(0));
        System.out.println(str.charAt(1));
        System.out.println(str.charAt(2));
        System.out.println(str.charAt(3));
        System.out.println(str.charAt(4));
    }


    public static void test13(){
        A obj = new D();

        System.out.println(obj instanceof B);

        System.out.println(obj instanceof C);

        System.out.println(obj instanceof D);

        System.out.println(obj instanceof A);
    }

    public static void test14(){
        String str = "123456789";
        String[] s = str.split("");
        System.out.println(s.length);
    }
}

class A{}

class B extends A{}

class C extends A{}

class D extends B{}



