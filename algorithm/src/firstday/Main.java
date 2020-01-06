package firstday;

import java.util.Stack;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 21:20 2019/7/5
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Main {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        if (stack1.size() != 0) {
            stack1.push(node);
            while (stack1.size() != 0) {
                stack2.push(stack1.pop());
            }
        } else {
            stack2.push(node);
            while (stack2.size() != 0) {
                stack1.push(stack2.pop());
            }
        }
    }
    public int pop(){
        if (stack1.size() != 0) {
            return stack1.pop();
        } else {
            return stack2.pop();
        }
    }
}
