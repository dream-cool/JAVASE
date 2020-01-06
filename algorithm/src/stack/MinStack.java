package stack;

import java.util.Stack;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 9:28 2019/7/30
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * ["PSH3","MIN","PSH4","MIN","PSH2","MIN","PSH3","MIN","POP","MIN","POP","MIN","POP","MIN","PSH0","MIN"]
 */
public class MinStack {
    public static void main(String[] args) {
        push(3);
        System.out.println(min());
        push(4);
        System.out.println(min());
    }
    private static int min = 0;
    private static Stack stack = new Stack();
    public static void push(int node) {
        if (node < min || stack.size() == 0){
            min = node;
        }
        stack.push(node);
    }

    public static void pop() {
        stack.pop();
    }

    public static int top() {
        return (int)stack.peek();
    }

    public static int min() {
        return min;
    }
}
