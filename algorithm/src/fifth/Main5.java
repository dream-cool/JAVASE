package fifth;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 22:15 2019/7/7
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，
 * 我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 *
 * 如果一个数的每位数字被旋转以后仍然还是一个数字，
 * 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 *
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 *
 *
 * 输入描述:
 * 输入正整数N
 *
 * 输出描述:
 * 输出1到N中好数个数
 *
 * 输入例子1:
 * 10
 *
 * 输出例子1:
 * 4
 *
 * 例子说明1:
 * 在[1, 10]中有四个好数： 2, 5, 6, 9。
 * 注意 1 和 10 不是好数, 因为他们在旋转之后不变。
 */
import java.util.Scanner;
public class Main5{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        for(int i = 0; i <= N; i++){
            boolean flag1 = false;
            boolean flag2 = true;
            int m;
            for(int number = i; number > 0; number /= 10){
                m = number % 10;
                if(m == 2 || m == 5 || m == 6 || m == 9){
                    flag1 = true;
                }
                if(m == 3 || m == 4 || m == 7){
                    flag1 = false;
                    break;
                }
            }
            if(flag1 && flag2){
                count++;
            }
        }
        System.out.println(count);
    }
}
