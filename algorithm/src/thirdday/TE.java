package thirdday;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 20:41 2019/7/1
 */
import java.util.*;
import java.io.*;

public class TE {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        String[] line2 = br.readLine().split(" ");
        String[] line3 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int k = Integer.parseInt(line1[1]);
        int[] score = new int[n];
        int[] sleep = new int[n];
        int max1 = 0;
        int win = 0;
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(line2[i]);
            if (Integer.parseInt(line3[i]) == 1) {
                max1 += score[i];
                score[i] = 0;
            }
            if (i < k) {
                win += score[i];
            }
        }
        int max2 = win;
        for (int i = k; i < n; i++) {
            win -= score[i - k];
            win += score[i];
            if (win > max2) {
                max2 = win;
            }
        }
        System.out.println(max1 + max2);
    }
}