package lambda;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：clt
 * @Date ：Created in 16:54 2019/8/25
 */
public class ListTest {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);

        list.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .mapToInt(n -> n)
                .forEach(System.out::println);
    }
}
