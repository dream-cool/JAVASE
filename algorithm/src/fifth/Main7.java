package fifth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 23:23 2019/7/7
 * 假设你是一位很有爱的幼儿园老师，想要给幼儿园的小朋友们一些小糖果。但是，每个孩子最多只能给一块糖果。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的糖果的最小尺寸；并且每块糖果 j ，都有一个尺寸 sj 。如果 sj >= gi ，
 * 我们可以将这个糖果 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * 注意：
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块糖果。
 *
 *
 * 输入描述:
 * 第一行输入每个孩子的胃口值
 *
 * 第二行输入每个糖果的尺寸
 *
 * 孩子数和糖果数不超过1000
 *
 * 输出描述:
 * 能满足孩子数量的最大值
 *
 * 输入例子1:
 * 1 2 3
 * 1 1
 */
public class Main7{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");
        String[] str2 = br.readLine().split(" ");
        int[] n1 = new int[str1.length];
        int[] n2 = new int[str2.length];
        for (int i = 0; i < str1.length; i++) {
            n1[i] = Integer.parseInt(str1[i]);
        }
        for (int i = 0; i < str2.length; i++) {
            n2[i] = Integer.parseInt(str2[i]);
        }
        Arrays.sort(n1);
        Arrays.sort(n2);
        int count = 0;
        for (int i = 0 , j = 0; i < n1.length; j++) {
            if(n2[j] >= n1[i]){
                count++;
                i++;
            }
            if(j == n2.length-1){
                break;
            }
        }
        System.out.println(count);
    }
}
