package sixday;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 8:58 2019/6/30
 * 输入描述:
 * 每个测试用例的第一行是一个正整数M（1<=M<=100)，表示数据集的样本数目
 *
 * 接下来输入M行，每行是数据集的一个样本，每个样本均是字符串，且后六位是数字字符。
 * 输出描述:
 * 对每个数据集，输出所有样本的后六位构成的数字排序后的结果（每行输出一个样本的结果）
 */

public class Main5{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        String[] strs = new String[m];
        Set<Integer> set = new TreeSet<>();
        for(int i = 0; i < m; i++){
            strs[i] = sc.next();
            set.add(Integer.parseInt(strs[i].substring(strs[i].length()-6)));
        }
        for (Integer i:set) {
            System.out.println(i);
        }
    }
}
