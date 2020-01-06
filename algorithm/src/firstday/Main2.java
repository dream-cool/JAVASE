package firstday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 22:12 2019/7/5
 */
public class Main2 {
    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        System.out.println(Arrays.toString(arr));
        List<Integer> list = GetLeastNumbers_Solution(arr, 5);
        System.out.println(list);
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        Arrays.sort(input);
        List<Integer> list = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return (ArrayList<Integer>) list;
    }
}
