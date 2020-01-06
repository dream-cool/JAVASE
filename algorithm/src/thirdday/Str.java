package thirdday;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 20:13 2019/6/23
 */
public class Str{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();
        System.out.println(test(str,k));
    }
    public static int test(String str, int k){
        char[] temp = str.toCharArray();
        Map<Character,Integer> map = new HashMap<>(temp.length);
        for (int i = 0, length = temp.length; i < length; i++){
            Integer number = map.get(temp[i]);
            map.put(temp[i], number == null ? 1: ++number);
        }
        int[] arr = new int[map.size()];
        int i = 0;
        for ( Character num: map.keySet()) {
            arr[i] = map.get(num);
            i++;
        }
        Arrays.sort(arr);
        for (int j = 0 ; j < k ; j++){
            arr[arr.length-1]--;
            Arrays.sort(arr);
        }
        int count = 0;
        for (int t = 0 ; t < arr.length ; t++){
            count += arr[t] * arr[t];
        }
        return count;
    }
}
