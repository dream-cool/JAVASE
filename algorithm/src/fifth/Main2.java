package fifth;

import java.util.Scanner;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 11:33 2019/6/25
 * 小易为了向他的父母表现他已经长大独立了,他决定搬出去自己居住一段时间。
 * 一个人生活增加了许多花费: 小易每天必须吃一个水果并且需要每天支付x元的房屋租金。
 * 当前小易手中已经有f个水果和d元钱,小易也能去商店购买一些水果,商店每个水果售卖p元。
 * 小易为了表现他独立生活的能力,希望能独立生活的时间越长越好,
 * 小易希望你来帮他计算一下他最多能独立生活多少天。
 * @author Mrchen
 */
public class Main2{
    public  static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        System.out.println(test(Integer.parseInt(s[0]),Integer.parseInt(s[1]),
                Integer.parseInt(s[2]),Integer.parseInt(s[3])));
    }
    public static int test(int x, int f, int d, int p){
        int count = 0;
        while(d >= x){
            if(f == 0){
                if(d < p){
                    break;
                }
                d -= p;
                f++;
            }
            if(d < x){
                break;
            }
            f--;
            d -= x;
            count++;
        }
        return count;
    }
}
