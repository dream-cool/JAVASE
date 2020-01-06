package firstday;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 19:48 2019/7/13
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Main7 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int n = Integer.parseInt(str1.substring(0, 1));
        int m = Integer.parseInt(str1.substring(2));
        if (n ==0 || m == 0){
            return;
        }
        String[] strs = str2.split(" ");
        Stack<LinkedList<Integer>> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < strs.length; i++) {
            if (i % m == 0 && i != 0) {
                stack.push(list);
                list = new LinkedList<>();
            }
            list.add(Integer.parseInt(strs[i]));
        }
        stack.push(list);
        while (stack.size() > 0) {
            LinkedList<Integer> ls = stack.pop();
            while (ls.size() > 0) {
                System.out.print(ls.removeFirst() + " ");
            }
        }
    }
}
