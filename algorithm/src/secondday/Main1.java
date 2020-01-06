package secondday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 20:17 2019/7/3
 */
public class Main1{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Map<Character, Integer> map = new HashMap<>(26);
        Integer number = 0;
        int pre = 1;
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            number = map.get(str.charAt(i));
            map.put(str.charAt(i), number == null ? 1 :++number);
        }
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
            number = map.get(str.charAt(i)) - 1;
            if (number == 0){
                map.remove(str.charAt(i));
                set.remove(str.charAt(i));
            } else {
                map.put(str.charAt(i),  number);
            }
            if (set.size() == 0){
                sb.append(pre+" ");
                pre = 1;
            } else {
                pre++;
            }

        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
