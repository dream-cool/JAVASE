package secondday;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 9:46 2019/7/3
 * 题目描述
 * 牛牛总是睡过头，所以他定了很多闹钟，只有在闹钟响的时候他才会醒过来并且决定起不起床。从他起床算起他需要X分钟到达教室，上课时间为当天的A时B分，请问他最晚可以什么时间起床
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含一个正整数，表示闹钟的数量N(N<=100)。
 * 接下来的N行每行包含两个整数，表示这个闹钟响起的时间为Hi(0<=A<24)时Mi(0<=B<60)分。
 * 接下来的一行包含一个整数，表示从起床算起他需要X(0<=X<=100)分钟到达教室。
 * 接下来的一行包含两个整数，表示上课时间为A(0<=A<24)时B(0<=B<60)分。
 * 数据保证至少有一个闹钟可以让牛牛及时到达教室。
 * 输出描述:
 * 输出两个整数表示牛牛最晚起床时间。
 * 示例1
 * 输入
 * 复制
 * 3
 * 5 0
 * 6 0
 * 7 0
 * 59
 * 6 59
 * 输出
 * 复制
 * 6 0
 */
import java.util.Scanner;
import java.util.Arrays;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] time = new int[n];
        for(int i = 0; i < n; i++){
            int h = sc.nextInt();
            int m = sc.nextInt();
            time[i] = h * 60 + m;
        }
        int x = sc.nextInt();
        int h = sc.nextInt();
        int m = sc.nextInt();
        int max = h * 60 + m -x;
        Arrays.sort(time);
        int index = 0;
        for(int i = time.length-1; i >= 0; i--){
            if(time[i] <= max){
                index = i;
                break;
            }
        }
        System.out.println(time[index]/60+" "+time[index]%60);

    }
}

