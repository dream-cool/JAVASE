package thirdday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 15:13 2019/6/30
 * 题目描述
 * 输入两个字符串a和b，字符串内容为二进制数字，求两个字符串相加的结果，加法计算方法以二进制方式计算，并返回对应的字符串结果。要求程序尽可能的高效。示例如下：
 * 输入描述:
 * 输入两个字符串，如"1101", "1100"
 * 输出描述:
 * "11001"
 */
public class Main2{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] str1 = str.split(" ");
        char[] s1 = str1[0].toCharArray();
        char[] s2 = str1[1].toCharArray();
        int sum = 0;
        for(int i = s1.length-1,j = s2.length-1,k=0; i >=0 || j >= 0; i--,j--,k++){
            int x1 = 0, x2 = 0;
            if (i >= 0){
                x1 = s1[i];
            }
            if (j >= 0){
                x2 = s2[j];
            }
            if (k == 0){
                sum +=  x1 == '1' ? 1 :0  + x2 == '1' ? 1 :0 ;
            } else {
                sum += (int) Math.pow(x1 == '1' ? 2 :0 ,k) + (int) Math.pow(x2 == '1' ? 2 :0 ,k);
            }
        }
        System.out.println(Integer.toBinaryString(sum));
    }
}
