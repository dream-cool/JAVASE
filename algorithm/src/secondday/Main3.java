package secondday;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 14:19 2019/7/4
 * 题目描述
 * 对字符串进行RLE压缩，将相邻的相同字符，用计数值和字符值来代替。例如：aaabccccccddeee，则可用3a1b6c2d3e来代替。
 *
 * 输入描述:
 * 输入为a-z,A-Z的字符串，且字符串不为空，如aaabccccccddeee
 * 输出描述:
 * 压缩后的字符串，如3a1b6c2d3e
 * 示例1
 * 输入
 * 复制
 * aaabccccccdd
 * 输出
 * 复制
 * 3a1b6c2d
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;
public class Main3{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        TreeMap<Character, Integer> map = new TreeMap<>();
        for(int i = 0; i < str.length(); i++){
            Integer count = map.get(str.charAt(i));
            map.put(str.charAt(i), count == null ? 1 : ++count);
        }
        StringBuilder sb = new StringBuilder();
        char temp = '1';
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) != null && temp != str.charAt(i)){
                sb.append(map.get(str.charAt(i))+""+String.valueOf(str.charAt(i)));
                temp = str.charAt(i);
            }
        }
        System.out.println(sb);
    }
}
