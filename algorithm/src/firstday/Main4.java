package firstday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 8:50 2019/7/6
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Main4 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        System.out.println(Arrays.toString(arr));
        reOrderArray1(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reOrderArray(int [] array) {
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            while((array[left] % 2) !=0 ){
                left++;
            }
            while((array[right] % 2) ==0 ){
                right--;
            }
            if(left >= right){
                break;
            }
            int temp = array[right];
            array[right] = array[left];
            array[left] = temp;
            left++;
            right--;
        }
    }

    public static void reOrderArray1(int [] array){
        List<Integer> list1 = new ArrayList<>(array.length);
        List<Integer> list2 = new ArrayList<>(array.length);
        for (int i = 0; i < array.length; i++) {
            if ((array[i] % 2) == 0){
                list2.add(array[i]);
            } else {
                list1.add(array[i]);
            }
        }
        int i = 0;
        for (Integer num: list1) {
            array[i++] = num;
        }
        for (Integer num: list2) {
            array[i++] = num;
        }
    }
}
