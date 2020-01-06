package bilibili;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 10:02 2019/7/8
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = new String[100];
        int x = 0;
        String temp;
        while (!(temp = br.readLine()).equals("END")){
            strings[x] = temp;
            x++;
        }
        for (int i = 0; strings[i] != null; i++) {
            System.out.println((result(nextExpre(strings[i]))));
        }

    }
    public static List<String> nextExpre(String src){
        List<String> list = new LinkedList<>();
//        将字符串转换成字符串数组
        String[] temp = strSpilt(src);
//        新建栈结构 往栈中添加底层元素 #
        Stack<String> stack = new Stack<>();
        stack.push("#");
//        运算符优先级键值对表
        Map<String, Map<String,Integer>> map = getTable();
        for (int i = 0; temp[i]!=null && !"".equals(temp[i]); i++) {
//            遍历字符串数组 是运算符则进行压栈和弹栈的判断
            if (temp[i].equals("+") || temp[i].equals("-")|| temp[i].equals("*")|| temp[i].equals("/")||
                    temp[i].equals("(")|| temp[i].equals(")")){
//                右括号判断标识，因为如果此字符为右括号则不需要进行入栈
                boolean flag =true;
                while (map.get("isp").get(stack.peek()) >= map.get("icp").get(temp[i])){
//                    如果相等则一定是匹配到了括号 则不进行字符输出，直接弹栈
                    if (map.get("isp").get(stack.peek()) != map.get("icp").get(temp[i]) ){
                        list.add(stack.pop());
                    } else {
                        flag = false;
                        stack.pop();
                        break;
                    }
                }
//                如果是匹配到了括号则不进行入栈
                if (flag){
                    stack.push(temp[i]);
                }
//                非运算符，直接添加到列表中输出
            } else {
                list.add(temp[i]);
            }
        }
//        遍历完字符串数组后继而将栈中数据取出 进行添加到列表中输出
        while (stack.size() > 1){
            list.add(stack.pop());
        }
        return list;
    }

    /**
     *根据后缀表达式计算结果
     */
    public static int result(List<String> list){
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            String temp = list.get(i);
            if (!"+".equals(temp)  && !"-".equals(temp) && !"*".equals(temp) && !"/".equals(temp)){
                stack.push(String.valueOf(temp));
            } else {
                Integer x = Integer.parseInt(String.valueOf(stack.pop()));
                Integer y = Integer.parseInt(String.valueOf(stack.pop()));
                if ("+".equals(temp)){
                    stack.push(String.valueOf(y + x));
                }
                if ("-".equals(temp)){
                    stack.push(String.valueOf(y - x));
                }
                if ("*".equals(temp)){
                    stack.push(String.valueOf(y * x));
                }
                if ("/".equals(temp)){
                    stack.push(String.valueOf(y / x));
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     *获取运算符优先级表数据
     */
    public static Map<String, Map<String,Integer>> getTable(){
        Map<String, Map<String,Integer>> map = new HashMap<>(2);
        Map<String,Integer> ispMap = new HashMap<>(8);
        ispMap.put("#" ,0);
        ispMap.put("(" ,1);
        ispMap.put("*" ,5);
        ispMap.put("/" ,5);
        ispMap.put("+" ,3);
        ispMap.put("-" ,3);
        ispMap.put(")" ,6);
        map.put("isp", ispMap);
        Map<String,Integer> icpMap = new HashMap<>(8);
        icpMap.put("#" ,0);
        icpMap.put("(" ,6);
        icpMap.put("*" ,4);
        icpMap.put("/" ,4);
        icpMap.put("+" ,2);
        icpMap.put("-" ,2);
        icpMap.put(")" ,1);
        map.put("icp", icpMap);
        return  map;
    }

    /**
     *字符串分割，将字符串根据操作运算符进行分割成字符串数组
     */
    public static String[] strSpilt(String str){
        char[] temp = str.toCharArray();
        String[] strs = new String[temp.length+1];
        int k = 0;
        String s = "";
        for (int i = 0; i < str.length(); i++) {
            if(temp[i] == '+' || temp[i] == '-' || temp[i] == '*'
                    || temp[i] == '/' || temp[i] == '(' || temp[i] == ')'){
                if (!("".equals(s)) && s !="" ){
                    strs[k++] = s;
                }
                strs[k++] = String.valueOf(temp[i]);
                s = "";
            } else {
                s+=String.valueOf(temp[i]);
            }
        }
        if (s !="" || !"".equals(s)){
            strs[k] =  s;
        }
        return  strs;
    }
}
