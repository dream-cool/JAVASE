package thirdday;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 10:43 2019/6/23
 */
public class MaxThreeNumberMu {
    public static void main(String[] args){
        int[] arr = {3,2,1,4,0};
        System.out.println(test1(arr));
    }

    public static void testTest(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i <n ; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(test(array));
    }

    public static int test(int[] array){
        int[] arr = {array[0],array[1],array[2]};
        for (int i = arr.length, length = array.length; i < length; i++){
            int min = arr[0];
            int index = 0;
            for (int j = 0; j < 3 ; j++){
                if (min > arr[j]){
                    min = arr[j];
                    index = j;
                }
            }
            if(array[i] > min){
                arr[index] = array[i];
            }
        }
        return arr[0] * arr[1] * arr[2];
    }

    public static int test1(int[] array){
        int[] temp = Arrays.copyOf(array, array.length);
        Arrays.sort(array);
        int count = 0;
        for (int i = 0, length = array.length; i < array.length; i++){
            if (temp[i] != array[i]){
                count++;
            }
        }
        return count;
    }
}

