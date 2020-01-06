package firstday;

import java.util.Arrays;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 22:57 2019/7/5
 */
public class Main3 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        String[] strs = new String[arr.length];
//        for (int i = 0; i < 10; i++) {
//            arr[i] = (int) (Math.random() * 1000);
//            strs[i] = arr[i]+"";
//        }
        arr = new int[]{3,32,321};
//        for (int i = 0; i < arr.length; i++) {
//            strs[i] = arr[i]+"";
//        }
        Arrays.sort(arr);
//        Arrays.sort(strs);
        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(strs));
        System.out.println(PrintMinNumber(arr));

    }

    public static String PrintMinNumber(int [] numbers) {
        String[] strs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strs[i] = numbers[i]+"9";
        }
        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(new StringBuilder(strs[i]).deleteCharAt(strs[i].length()-1));
        }
        return sb.toString();
    }
}
