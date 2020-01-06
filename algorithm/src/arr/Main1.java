package arr;

import java.util.Scanner;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 23:23 2019/7/24
 * 给定一个非空的整数数组，从数组第一个元素(下标为0的元素)开始遍历进行移动，
 * 下一次向后或向前移动 该元素的值 的位数（值为正数向后移动，值为负数向前移动，值为零不移动），
 * 依次类推进行移动，若某次移动数组出现越界，则说明数组可以跳出，返回true；不能跳出则返回false；
 * （加分项：也可考虑不增加使用其他集合数组辅助完成算法）
 * 例1：
 * 输入数组a[5] = [1,2,3,2,5];从第一个元素开始a[0]=1,下次向后移动1位到第二个元素a[1]=2,
 * 再次向后移动2位到第四个元素a[3],因为下次向后移动2位(a[3]=2)后,向后数组越界,即跳出数组,输出true;
 * 例2：
 * 输入数组a[2] = [1,-3];从第一个元素开始a[0]=1,下次移动1位到第二个元素a[1]=-3,
 * 再次向前移动3位后,向前数组越界,即跳出数组,输出true;
 *
 *
 *
 * 输入描述:
 * 一个非空的整数数组(至少有一个元素,可正可负)
 *
 * 输出描述:
 * 按规则移动后是否能跳出数组
 *
 * 输入例子1:
 * [1]
 *
 * 输出例子1:
 * true
 *
 * 输入例子2:
 * [2,1,3,5]
 *
 * 输出例子2:
 * true
 *
 * 输入例子3:
 * [2,1,-3]
 *
 * 输出例子3:
 * true
 *
 * 输入例子4:
 * [1,1,1,2,-1,1,-3]
 *
 * 输出例子4:
 * false
 */
public class Main1 {
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
        System.out.println(breakArray(arr));
    }
    public static boolean breakArray(int [] array) {
        int count = 0;
        for(int i = 0; i < array.length; ){
            i += array[i];
            count++;
            if(i >= array.length || i < 0){
                return true;
            }
            if(count > array.length){
                return false;
            }
        }
        return false;
    }
}