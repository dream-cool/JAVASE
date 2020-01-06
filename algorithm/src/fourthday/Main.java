package fourthday;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 14:37 2019/7/4
 * 题目描述
 * 求a/b的小数表现形式。如果a可以整除b则不需要小数点。如果是有限小数，则可以直接输出。如果是无限循环小数，则需要把小数循环的部分用"()"括起来。
 * <p>
 * 输入描述:
 * 两个整数a和b，其中
 * <p>
 * 0 <= a <= 1000 000
 * <p>
 * 1 <= b <= 10 000
 * 输出描述:
 * 一个字符串，该分数的小数表现形式
 * 示例1
 * 输入
 * 复制
 * 10 1
 * 输出
 * 复制
 * 10
 * 说明
 * 10/1 = 10
 * 示例2
 * 输入
 * 复制
 * 1 2
 * 输出
 * 复制
 * 0.5
 * 说明
 * 1/2 = 0.5
 * 示例3
 * 输入
 * 复制
 * 1 3
 * 输出
 * 复制
 * 0.(3)
 * 说明
 * 1/3 = 0.333333...
 * 示例4
 * 输入
 * 复制
 * 1 6
 * 输出
 * 复制
 * 0.1(6)
 * 说明
 * 1/6 = 0.16666666....
 * 示例5
 * 输入
 * 复制
 * 1 7
 * 输出
 * 复制
 * 0.(142857)
 * 说明
 * 1 / 7 = 0.1428571428...
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        String str = String.valueOf(a / b);
        String[] strings = str.split("\\.");
        if (strings[1].length() < 16) {
            System.out.println(str);
            return;
        }
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        for (int i = 0; i < strings[1].length(); i++) {
            Integer in = map.get(strings[1].charAt(i));
            if (in == null) {
                map.put(strings[1].charAt(i), i);
            } else {
                boolean flag = true;
                for (int j = in, index = i, count = 0; count < i - in; j++, index++, count++) {
                    if (map.get(j) != map.get(index)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    start = in;
                    end = i;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings[1].length(); i++) {
            if (i < start + 2) {
                sb.append(str.charAt(i));
            }
            if (i == start + 2) {
                sb.append("(");
                sb.append(str.charAt(i));
            }
            while (i > start + 2 && i < end + 2) {
                sb.append(str.charAt(i));
                i++;
            }
        }
        sb.append(")");
        System.out.println(sb);
    }
}
