package arr;

import java.util.Date;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 14:30 2019/7/14
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 1, 4};
        int[] duplication = new int[1];
        System.out.println(duplicate(arr, 5, duplication));
        System.out.println(duplication[0]);
    }

    public static boolean duplicate(int numbers[], int length, int[] duplication) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[numbers[i]]++;
            if (arr[numbers[i]] > 1) {
                duplication[0] = numbers[i];
                return true;

            }
        }
        return false;
    }
}
