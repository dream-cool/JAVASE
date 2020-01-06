package fourthday;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 20:41 2019/7/4
 * 农场有n只鸡鸭排为一个队伍，鸡用“C”表示，鸭用“D”表示。当鸡鸭挨着时会产生矛盾。需要对所排的队伍进行调整，使鸡鸭各在一边。每次调整只能让相邻的鸡和鸭交换位置，现在需要尽快完成队伍调整，你需要计算出最少需要调整多少次可以让上述情况最少。例如：CCDCC->CCCDC->CCCCD这样就能使之前的两处鸡鸭相邻变为一处鸡鸭相邻，需要调整队形两次。
 *
 *
 * 输入描述:
 * 输入一个长度为N，且只包含C和D的非空字符串。
 *
 * 输出描述:
 * 使得最后仅有一对鸡鸭相邻，最少的交换次数
 *
 * 输入例子1:
 * CCDCC
 *
 * 输出例子1:
 * 2
 */
public class Main2 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        try {
            str = br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int[] c = new int[str.length()];
        for (int i = 0, j = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'C') {
                c[j++] = i;
            }
        }
        int count = 0;
        int sum1 = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 0) {
                count++;
            } else {
                sum1 += (c[i] - count++);
            }
        }
        int sum2 = 0;
        count = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] == c.length - 1) {
                count++;
            } else {
                sum2 += (c.length - 1 - c[i] - count++);
            }
        }
        System.out.println(Math.min(sum1, sum2));
    }
}
