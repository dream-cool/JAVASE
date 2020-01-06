import java.util.*;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 18:40 2019/6/24
 * @author Mrchen
 */
public class IteratorTest {
    public static void main(String[] args) {
        setTest();
    }

    public static void itTest(){
        Map<Integer ,String> map = new HashMap<>(10);
        /**
         * 添加数据
         */
        for (int i = 0; i < 10; i++) {
            map.put(i, ""+i+i);

        }
        System.out.println(map);
        /**
         * 通过key集合遍历集合取value数据
         */
        for (Integer i : map.keySet()) {
            System.out.print(map.get(i)+"\t");
        }
        System.out.println();
        /**
         * 直接通过values集合遍历得到值数据
         */
        for (String  str : map.values()) {
            System.out.print(str+"\t");
        }
        System.out.println();
        /**
         * 通过迭代器遍历取value数据
         * map使用迭代器时需要通过entrySet获取
         * 所以迭代器类型也要为Entry
         */

        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while (it.hasNext()){
            System.out.print(it.next().getValue()+"\t");
        }
        System.out.println();
        /**
         * 通过entrySet集合遍历可以同时取得key值和value值
         */
        for (Map.Entry<Integer, String> i : map.entrySet()) {
            System.out.print(i.getKey()+":"+i.getValue()+"\t");
        }
    }

    public static void listItTest(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            System.out.print(it.next()+"\t");
        }
    }

    public static void setTest(){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }
        Iterator<Integer> it =set.iterator();
        while (it.hasNext()){
            System.out.print(it.next()+"\t");
        }
    }
}
