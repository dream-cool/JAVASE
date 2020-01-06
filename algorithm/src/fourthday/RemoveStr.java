package fourthday;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 8:47 2019/6/24
 */

import java.util.HashMap;
import java.util.Scanner;

public class RemoveStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(test(str));
    }

    public static String test(String str) {
        char[] temp = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        HashMap<Character, Character> map = new HashMap<>(temp.length);
        for (int i = 0, length = temp.length; i < length; i++) {
            Character ch = map.get(temp[i]);
            if (ch == null) {
                map.put(temp[i], temp[i]);
                sb.append(temp[i]);
            }
        }
        return sb.toString();
    }
}