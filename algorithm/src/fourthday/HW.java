package fourthday;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 8:26 2019/6/24
 */

import java.util.Arrays;
import java.util.Scanner;

public class HW {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hlength = sc.nextInt();
        int[] h = new int[hlength];
        for (int i = 0; i < hlength; i++) {
            h[i] = sc.nextInt();
        }
        int wlength = sc.nextInt();
        int[] w = new int[wlength];
        for (int j = 0; j < wlength; j++) {
            w[j] = sc.nextInt();
        }
        System.out.println(test(h, w));

    }

    public static int test(int[] h, int[] w) {
        Arrays.sort(h);
        Arrays.sort(w);
        int count = 0;
        for (int i = 0, wlength = w.length; i < wlength; i++) {
            for (int j = 0, hlength = h.length; j < hlength; j++) {
                if (w[i] >= h[j] && h[j] != 0) {
                    count++;
                    h[j] = 0;
                    break;
                }
            }
        }
        return count;
    }
}