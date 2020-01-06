package sixday;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 8:40 2019/6/30
 */

/**
 *通过键盘输入一串小写字母(a~z)组成的字符串。
 * 请编写一个字符串归一化程序，统计字符串中相同字符出现的次数，并按字典序输出字符及其出现次数。
 * 例如字符串"babcc"归一化后为"a1b2c2"
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main4{
    public static void main(String[] ages){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] temp = str.toCharArray();
        Map<Character,Integer> map = new HashMap(26);
        for(int i = 0; i < temp.length; i++){
            if(temp[i] < 97 || temp[i] > 122){
                return;
            }
            Integer count = map.get(temp[i]);
            map.put(temp[i], count == null ? 1 : ++count);
        }
        for(int i =97; i <= 122; i++){
            Integer c = map.get((char) i);
            if(c != null){
                System.out.print((char)i+""+ c);
            }
        }
    }
}
