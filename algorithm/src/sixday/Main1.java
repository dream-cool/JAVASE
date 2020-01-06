package sixday;

import java.util.Scanner;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 8:07 2019/6/26
 */
public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i <n ; i++) {
            array[i] = sc.nextInt();
        }
        int sum1 = 0, sum2;
        boolean flag = false;
        int count = 0;
        for(int i = 0; i < array.length - 1; i++){
            sum1 += array[i];
            sum2 = 0;
            for (int j = array.length-1; j > i; j--){
                sum2 += array[j];
                if(sum1 == sum2){
                    flag = true;
                    count = sum1;
                }
            }
        }
        if (flag){
            System.out.println(count);
        } else{
            System.out.println(0);
        }
    }
}
