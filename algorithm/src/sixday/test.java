package sixday;


/**
 * @ Author   ：clt.
 * @ Date     ：Created in 10:44 2019/6/30
 */
import java.util.*;

public class test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] array = line.split(",");
            for (String a : array) {
                set.add(Integer.valueOf(a));
            }
        }

        StringBuilder builder = new StringBuilder();
        for (Integer ii : set) {
            builder.append(ii).append(",");
        }


        System.out.println(builder.substring(0, builder.length() - 1));
    }
}