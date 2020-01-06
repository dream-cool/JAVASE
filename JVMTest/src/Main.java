import java.util.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        test1();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Object[] nums = list.toArray();
        System.out.println(Arrays.toString(nums));

        int[] ints = {5,4,3,2,1};
        Arrays.asList(ints);
        System.out.println(ints);

    }

    public static void test1(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        List<Integer> list1 = list.subList(3,5);
        System.out.println(list1);
        System.out.println(list1.get(0));

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){

        }
    }

    public static void test2(){
        LinkedHashMap<String, Integer> map1 = new LinkedHashMap<>();
        map1.put("11",1);
        map1.put("22",2);
        map1.put("44",4);
        map1.put("4242",4);
        map1.put("dsaa",4);
        map1.put("d1e1aa",4);
        map1.put("d242aa",4);
        map1.put("-1",-1);
        map1.put("-121",-1);
        map1.put("-241",-1);
        System.out.println(map1);

        Map<String, Integer> map2 = new HashMap<>(16);
        map2.put("11",1);
        map2.put("22",2);
        map2.put("44",4);
        map2.put("4242",4);
        map2.put("dsaa",4);
        map2.put("d1e1aa",4);
        map2.put("d242aa",4);
        map2.put("-1",-1);
        map2.put("-121",-1);
        map2.put("-241",-1);
        System.out.println(map2);
    }

    public static void test3(){
        Map<String, Integer> map1 = new HashMap<>(16);
        String str = "1";
        map1.put(str,1);
        System.out.println(map1.get(str));
        System.out.println(map1);
        str = "1"+11;
        System.out.println(map1.get(str));
        System.out.println(map1);


        Map<StringBuilder, Integer> map2 = new HashMap<>(16);
        StringBuilder sb = new StringBuilder("1");
        map2.put(sb,1);
        System.out.println(map2.get(sb));
        System.out.println(map2);
        sb.append("11");
        System.out.println(map2.get(sb));
        System.out.println(map2);
    }
}
