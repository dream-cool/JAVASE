package sixday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 8:47 2019/6/27
 * 题目描述
 * 牛牛以前在老师那里得到了一个正整数数对(x, y), 牛牛忘记他们具体是多少了。
 *
 * 但是牛牛记得老师告诉过他x和y均不大于n, 并且x除以y的余数大于等于k。
 * 牛牛希望你能帮他计算一共有多少个可能的数对。
 *
 * 输入描述:
 * 输入包括两个正整数n,k(1 <= n <= 10^5, 0 <= k <= n - 1)。
 * 输入 5 2  输出 7
 */
public class Main3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        for(int i = 1; i <= n; i++){
            for(int j = k; j <= n; j++){
                if((i % j) >= k){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] temp = str.trim().split(" ");
            Solution(Integer.valueOf(temp[0]), Integer.valueOf(temp[1]));
        }
    }

    private static void Solution(int zuidashu , int zuixiaoyushu) {
//        但是牛牛记得老师告诉过他x和y均不大于n, 并且x除以y的余数大于等于k。



        long count = 0;

        //这种是特殊情况
        if (zuixiaoyushu==0){
            count=zuidashu;
            System.out.println(count*count);
            return;
        }

        for (int chushu =zuixiaoyushu+1;chushu<=zuidashu;chushu++){
            int i =chushu-zuixiaoyushu;
            int hang =(zuidashu+1)/chushu;
            count+=i*hang;
            int rest =(zuidashu+1)%chushu;
            if (rest>0){
                if (rest>chushu-i){
                    count+=rest-(chushu-i);
                }
            }
        }
        System.out.println(count);
    }

}


