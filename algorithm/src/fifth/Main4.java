package fifth;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 8:09 2019/7/2
 * 题目描述
 * 小Q得到一个神奇的数列: 1, 12, 123,...12345678910,1234567891011...。
 * 并且小Q对于能否被3整除这个性质很感兴趣。
 * 小Q现在希望你能帮他计算一下从数列的第l个到第r个(包含端点)有多少个数可以被3整除。
 * 输入描述:
 * 输入包括两个整数l和r(1 <= l <= r <= 1e9), 表示要求解的区间两端。
 * 输出描述:
 * 输出一个整数, 表示区间内能被3整除的数字个数。
 * 示例1
 * 输入
 * 复制
 * 2 5
 * 输出
 * 复制
 * 3
 */
public class Main4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int begin = sc.nextInt();
        int end = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        List<BigInteger> list = new ArrayList<>();
        int j = 0;
        for(int i = 1; i <=end; i++){
            sb.append(i+"");
            if(i >= begin){
                list.add(new BigInteger(sb.toString()));
            }
        }
        BigInteger three = new BigInteger("3");
        BigInteger zero = new BigInteger("0");
        int count = 0;
        for(BigInteger number: list){
            if(number.mod(three).equals(zero)){
                count++;
            }
        }
        System.out.println(count);
    }
}
