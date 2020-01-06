package sixday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 14:04 2019/6/30
 * 题目描述
 * 给定一个字符串，输出所有指定长度为n的子串，没有则输出-1
 * 输入描述:
 * 输入第一行一个字符串，如：“1234567890”
 *
 * 输入第二行一个数字是n，如5
 * 输出描述:
 * 输出所有长度为n的子串，如“12345”，“23456”，“34567”，“45678”，“56789”
 */
public class Main8{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int num =Integer.valueOf(br.readLine());
        if (str.length() <= 0 || num<0 || num > str.length()){
            System.out.println(-1);
            return;
        }
        for(int i = 0; i <= str.length()-num; i++){
            System.out.print(str.substring(i,i+num)+" ");
        }
    }
}
