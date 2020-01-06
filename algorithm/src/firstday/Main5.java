package firstday;

import java.util.Stack;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 9:04 2019/7/6
 * 题目描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class Main5 {
    public static void main(String[] args) {
        int[] push = {1,2,3,4,5};
        int[] pop = {4,5,3,2,1};
        int[] pop1 = {4,3,5,1,2};
        System.out.println(IsPopOrder(push,pop1));

    }
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        int j = 0;
        int k = 0;
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(pushA[k++]);
        while (!stack1.empty()){
            if (j == popA.length){
                break;
            }
            while (stack1.peek() == popA[j]){
                stack1.pop();
                j++;
                if (stack1.empty()){
                    return true;
                }
            }
            if (stack1.peek() != popA[j] && k == pushA.length){
                break;
            }
            if (k < pushA.length){
                stack1.push(pushA[k++]);
            }
        }
        return stack1.empty();
    }
}
