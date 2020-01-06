package map;

import java.util.LinkedHashMap;

/**
 * @author ：clt
 * @Date ：Created in 10:43 2019/9/26
 * <p>
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class First {
    private static LinkedHashMap<Character, Integer> map = new LinkedHashMap();

    public static void main(String[] args) {
        String str1 = "go";
        String str2 = "google";
        for (int i = 0; i < str1.length(); i++) {
            Insert(str1.charAt(i));
        }
        System.out.println(FirstAppearingOnce());
        for (int i = 0; i < str2.length(); i++) {
            Insert(str2.charAt(i));
        }
        System.out.println(FirstAppearingOnce());
    }

    //Insert one char from stringstream
    public static void Insert(char ch) {
        Integer count = map.get(ch);
        if (count == null) {
            map.put(ch, 1);
        } else {
            map.put(ch, ++count);
        }
    }

    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce() {
        for (Character c : map.keySet()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return '#';
    }
}
