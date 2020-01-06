package sixday;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 19:45 2019/7/29
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class Main9 {
    private static int[] chars = new int[256];
    private static String sb;
    public static void main(String[] args) {
        String str = "fiuwgp[w;fa";
        for (int i = 0; i < str.length(); i++) {
            Insert(str.charAt(i));
        }
        System.out.println(FirstAppearingOnce());
    }

    //Insert one char from stringstream
    public static void Insert(char ch)
    {
        chars[ch]++;
        sb += ch;
    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce()
    {
        for (int i = 0; i < sb.length(); i++) {
            if (chars[sb.charAt(i)]==1){
                return sb.charAt(i);
            }
        }
        return '\0';
    }
}
