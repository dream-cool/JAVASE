package fifth;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 22:30 2019/7/7
 * 假设你正在玩跳格子（所有格子排成一个纵列）游戏。需要 跳完n 个格子你才能抵达终点。
 * 每次你可以跳 1 或 2 个格子。你有多少种不同的方法可以到达终点呢？
 * 注意：给定 n 是一个正整数。
 *
 * 输入描述:
 * 格子数n
 *
 * 输出描述:
 * 跳完n个格子到达终点的方法
 *
 * 输入例子1:
 * 2
 *
 * 输出例子1:
 * 2
 */
import java.util.Scanner;
public class Main6{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n < 0){
            return;
        }
        System.out.println(test(n));
    }
    public static int test(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(n > 2){
            return test(n-1) + test(n-2);
        }
        return 0;
    }
}
