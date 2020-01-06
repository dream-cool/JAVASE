package secondday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 22:34 2019/7/3
 * 题目描述
 * 给出一个字符串格式的化学分子式，计算原子的个数
 * 每个化学元素都是由一个大写字母，或者一个大写字母后跟着若干个小写字母组成，例如H是一个化学元素，Mg也是一个化学元素。
 * 每个分子式中，原子的个数写在元素后面，如果原子个数是1，那么原子个数省略。例如H2O和H2O2都是有效的分子式，但H1O2不是有效分子式。
 * 每个分子式中包含若干括号，为简单起见，分子式中只有小括号。
 * 每次输入一个分子式，对每个给定的分子式，求出每个原子的个数，按照原子字母表的顺序排列，并输出。
 * 输入描述:
 * 一行，一个字符串表示输入的分子式
 * 输出描述:
 * 按要求输出答案
 * 示例1
 * 输入
 * 复制
 * H2O
 * 输出
 * 复制
 * H2O
 * 说明
 * 示例2
 * 输入
 * 复制
 * Mg(OH)2
 * 输出
 * 复制
 * H2MgO2
 * 说明
 * 示例3
 * 输入
 * 复制
 * K4(ON(SO3)2)2
 * 输出
 * 复制
 * K4N2O14S4
 */
public class Main2 {
//    public static void main(String[] args) throws IOException {
////        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        String str = br.readLine();
////        StringBuilder sb = new StringBuilder(str);
////        for (int i = 0; i < sb.length()-1; i++) {
////            if (i == sb.length()-1 && (sb.charAt(i) < 48 && sb.charAt(i) > 57) ){
////                sb.insert(i+1, '1');
////            }
////            if ((sb.charAt(i) > 65 && sb.charAt(i) < 97) && (sb.charAt(i+1) > 65 && sb.charAt(i+1) < 97)){
////                sb.insert(i+1, '1');
////            }
////            if ((sb.charAt(i+1) == '(') && (sb.charAt(i) > 65 && sb.charAt(i) < 97)){
////                sb.insert(i+1, '1');
////            }
////        }
////        Stack<String> stack = new Stack<>();
////        Map<String,Integer> map = new TreeMap<>();
////        for (int i = 0; i < sb.length() - 1; i++) {
////            if (sb.charAt(i) == ')'){
////                List<String> list = new ArrayList<>();
////                while (!stack.peek().equals("(")){
////                    list.add(String.valueOf(stack.pop()));
////                }
////                stack.pop();
////                if (sb.charAt(i+1) > 48 && sb.charAt(i+1) < 57){
////                    int mu = Integer.valueOf(String.valueOf(sb.charAt(i+1)));
////                    for (int j = 0; j < list.size(); j+=2) {
////                        int x = Integer.parseInt(list.get(j)) * mu;
////                        list.set(j, String.valueOf(x));
////                    }
////                    i++;
////                }
////                for (int j = list.size()-1; j >= 0; j--) {
////                    stack.push(list.get(j));
////                }
////            } else if ( !String.valueOf(sb.charAt(i)).equals(")")){
////                stack.push(String.valueOf(sb.charAt(i)));
////            }
////        }
////        while (stack.size() > 0){
////            String num = stack.pop();
////            Integer c;
////            String str1 = String.valueOf(stack.pop());
////            Integer number = map.get(str1);
////            if (number == null){
////                c = Integer.parseInt(num);
////            } else {
////                c = number + Integer.parseInt(num);
////            }
////            map.put(str1, c);
////        }
////        sb = new StringBuilder(map.toString());
////        System.out.println(sb);
////    }
}
