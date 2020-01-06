package thirdday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 11:34 2019/6/23
 */
public class Arr {
    public static void main(String args[])throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(ir);
        int n = Integer.parseInt(bf.readLine());
        String[] str = bf.readLine().split(" ");
        int[] nums=new int[str.length];
        for (int i=0;i<str.length;++i){
            nums[i]=Integer.parseInt(str[i]);
        }
        System.out.println(test1(nums));
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
