package fourthday;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 15:55 2019/7/4
 * 题目描述
 * 我们部门需要装饰墙，但是墙非常非常的长，有一千万米。我们会按顺序贴很多海报在上面，这些海报相互之间会重叠，请问下，最后还能看到哪些？（只看到一部分也算）
 * 输入描述:
 * N表示N张海报
 * 接下来每一行代表海报的左右边界（上下默认全满），Li，Ri，均为整数，大于0，小于一千万。海报按输入顺序张贴。
 * 输出描述:
 * 有多少张海报是可见的
 * 示例1
 * 输入
 * 复制
 * 5
 * 1 4
 * 2 6
 * 8 10
 * 3 4
 * 7 10
 * 输出
 * 复制
 * 4
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = start; j <= end; j++) {
                list.add(j);
            }
            lists.add(list);
        }
        List<List<Integer>> addLists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (addLists.size() == 0) {
                addLists.add(lists.get(i));
            } else {

            }

        }


    }
}
