package thirdday;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 22:12 2019/6/23
 */
import java.util.Scanner;
public class ZeroOne{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(test(str));
    }
    public static int test(String str){
        char[] temp = str.toCharArray();
        int j = 1;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0, length = temp.length-1; i < length; i++){
            /**
             * 第一个if即对字符串中找到第一组01串时计算01串的长度
             */
            if(temp[i] != temp[i+1]){
                j++;
            }
            /**
             * 第二个if即对找到的01串计算长度，如果原来就已经出现过01串了则将
             * 计算的01串长度存进第二个count中，每次计算完长度后对长度变量进行重新初始化
             */
            if((temp[i] == temp[i+1] && j!=1) || i+1 == length){
                if (count1 == 0){
                    count1 = j;
                } else {
                    count2 = j;
                }
                j = 1;
            }
            /**
             * 第三个if即判断后一次找到的01串长度是不是大于第一次的01串长度
             * 如果大于则要进行交换处理
             */
            if(temp[i] == temp[i+1] && count1 != 0 && count2 !=0){
                int re ;
                if (count2 > count1){
                    re = count2;
                    count2 = count1;
                    count1 = re;
                }
            }
        }
        return count1;
    }
}
