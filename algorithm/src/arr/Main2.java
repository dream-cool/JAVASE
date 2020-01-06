package arr;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 8:10 2019/7/25
 * 给定一个数组A[n], 定义数组的众数 ( Majority Element) 为数组中出现次数超过 n/2 次的元素,
 * 假设数组A[n]非空且一定存在众数, 请设计算法找到该众数并输出.
 *
 *
 * 输入描述:
 * 一个非空且一定存在众数的整数数组,如: [1,2,2]
 *
 * 输出描述:
 * 输出打印该众数,如: 2
 *
 * 输入例子1:
 * [1,2,2]
 *
 * 输出例子1:
 * 2
 *
 * 输入例子2:
 * [3,1,-2,3,1,3,3]
 *
 * 输出例子2:
 * 3
 */
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder(s);
        sb.deleteCharAt(0);
        sb.deleteCharAt(s.length()-2);
        String[] strs = sb.toString().split(",");
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(Array(arr));
    }
    public static int Array(int [] array) {
        Map<Integer,Integer> map = new HashMap<>(array.length/2);
        for(int i = 0; i < array.length; i++){
            Integer num = map.get(array[i]);
            map.put(array[i],num == null ? 1 : ++num);
            if(num != null && num > array.length/2){
                return array[i];
            }
        }
        return 0;
    }
}
