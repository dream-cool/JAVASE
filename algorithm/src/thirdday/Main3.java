package thirdday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 19:20 2019/7/1
 * 题目描述
 * 今天上课，老师教了小易怎么计算加法和乘法，乘法的优先级大于加法，但是如果一个运算加了括号，那么它的优先级是最高的。例如：
 * 1+2*3=7
 * 1*(2+3)=5
 * 1*2*3=6
 * (1+2)*3=9
 * 现在小易希望你帮他计算给定3个数a，b，c，在它们中间添加"+"， "*"， "("， ")"符号，能够获得的最大值。
 * 输入描述:
 * 一行三个数a，b，c (1 <= a, b, c <= 10)
 * 输出描述:
 * 能够获得的最大值
 */
public class Main3{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int[] numbers = new int[]{Integer.parseInt(strings[0]), Integer.parseInt(strings[1]), Integer.parseInt(strings[2])};
        Arrays.sort(numbers);
        if(numbers[0] == 1){
            System.out.println((numbers[0]+numbers[1])*numbers[2]);
        } else {
            System.out.println(numbers[0]*numbers[1]*numbers[2]);
        }
    }
}
