package fifth;

import java.util.Scanner;
import java.math.BigInteger;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 10:39 2019/6/25
 * 对于任意两个正整数x和k,我们定义repeat(x, k)为将x重复写k次形成的数,
 * 例如repeat(1234, 3) = 123412341234,repeat(20,2) = 2020.
 * 牛牛现在给出4个整数x1, k1, x2, k2, 其中v1 = (x1, k1), v2 = (x2, k2),请你来比较v1和v2的大小。
 * @author Mrchen
 */
public class Main1 {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int k1 = Integer.valueOf(s[1]);
        int k2 = Integer.valueOf(s[3]);
        for (int i = 0; i < k1; i++) {
            sb1.append(s[0]);
        }
        for (int i = 0; i < k2; i++) {
            sb2.append(s[2]);
        }
        if (new BigInteger(sb1.toString()).compareTo(new BigInteger(sb2.toString())) < 0){
            System.out.println("Less");
        } else if (new BigInteger(sb1.toString()).equals(new BigInteger(sb2.toString()))){
            System.out.println("Equal");
        } else {
            System.out.println("Greater");
        }
    }
}
