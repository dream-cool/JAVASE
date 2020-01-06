package firstweek;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StrRelpace {

    public String replaceSpace(StringBuffer str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0 ; i < str.length(); i++){
            String temp = str.substring(i,i+1);
            if(" ".equals(temp)){
                sb.append("%20");
            } else {
                sb.append(temp);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i<10; i++){
            stack.push(i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<10; i++){
            list.add(stack.pop());
        }
        System.out.println(list);
    }

}
