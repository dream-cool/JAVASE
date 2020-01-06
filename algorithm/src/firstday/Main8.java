package firstday;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 22:31 2019/7/13
 * 薯队长在平时工作中需要经常跟数字打交道，某一天薯队长收到了一个满是数字的表格，
 * 薯队长注意到这些数字里边很多数字都包含1，比如101里边包含两个1，616里包含一个1。
 * 请你设计一个程序帮薯队长计算任意一个正整数n(0<n<=2147483647)，
 * 从1到n（包括n）的所有整数数字里含有多少个1。
 *
 * 输入描述:
 * 正整数n(0<n<=2147483647)
 *
 * 输出描述:
 * 从1到n（包括n）的所有整数数字里含有多少个1
 *
 * 输入例子1:
 * 1
 *
 * 输出例子1:
 * 1
 *
 * 输入例子2:
 * 13
 *
 * 输出例子2:
 * 6
 *
 * 例子说明2:
 * 从1到13（包括13）有13个数字，其中包含1的数字有1，10，11，12，13，
 * 这些数字里分别有1，1，2，1，1个1，所以从1到13（包括13）的整数数字中一共有1+1+2+1+1=6个1
 */
import java.util.Scanner;
public class Main8{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int count = 0;
        for(long i = 0; i <= n; i++){
            for(long j = i; j > 0; j /= 10){
                if(j % 10 == 1){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
