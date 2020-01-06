package thirdday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 14:28 2019/6/30
 * 题目描述
 * 给定一个字符串来代表一个员工的考勤纪录，这个纪录仅包含以下两个字符：
 * 'A' : Absent，缺勤
 * 'P' : Present，到场
 * 如果一个员工的考勤纪录中不超过两个'A'(缺勤),那么这个员工会被奖赏。
 *
 * 如果你作为一个员工，想在连续N天的考勤周期中获得奖赏，请问有多少种考勤的组合能够满足要求
 * 输入描述: 3
 * 考勤周期的天数N（正整数）
 * 输出描述: 7
 * 这N天里能获得奖赏的考勤组合数
 */
public class Main1{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        if (n < 0){
            return;
        }
        System.out.println((n*(n-1))/2 + n + 1);
    }
}