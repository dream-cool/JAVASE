package firstday;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 21:56 2019/7/5
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class Main1 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        int[] num1 ={0};
        int[] num2 ={0};
        arr = new int[]{4, 6, 2, 2, 3, 3, 8, 8, 9, 9, 1000000, 1000000};
        System.out.println(Arrays.toString(arr));
        FindNumsAppearOnce(arr, num1, num2);
        System.out.println(Arrays.toString(num1));
        System.out.println(Arrays.toString(num2));
    }

    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Map<Integer, Integer> map = new HashMap<>(array.length);
        for (int i = 0; i < array.length; i++) {
            Integer integer = map.get(array[i]);
            map.put(array[i], integer == null ? 1 : ++integer);
        }
        for (Integer i: map.keySet()) {
            if (map.get(i) == 1 && num1[0] == 0){
                num1[0] = i;
            } else if (map.get(i) == 1 && num1[0] !=0){
                num2[0] = i;
            }
        }
    }
}
