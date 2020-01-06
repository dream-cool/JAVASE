package str;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ：clt
 * @Date ：Created in 9:16 2019/9/5
 * 对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，
 * 字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
 * 给定一个原字符串A，请返回逆序后的字符串。例，输入"I am a boy!", 输出"boy! a am I"
 *
 * 输入描述:
 * 输入一行字符串str。(1<=strlen(str)<=10000)
 *
 * 输出描述:
 * 返回逆序后的字符串。
 *
 * 输入例子1:
 * It's a dog!
 *
 * 输出例子1:
 * dog! a It's
 */
public class ReverseOrderString {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strings = str.split(" ");
        StringBuilder sb = new StringBuilder(16);
        for (int i = strings.length - 1; i >= 0 ; i--) {
            sb.append(strings[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
