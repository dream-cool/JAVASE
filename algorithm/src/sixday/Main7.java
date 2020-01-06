package sixday;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 11:10 2019/6/30
 * 题目描述
 * 已知一个字符串数组words，要求寻找其中两个没有重复字符的字符串，使得这两个字符串的长度乘积最大，输出这个最大的乘积。如：
 * words=["abcd","wxyh","defgh"], 其中不包含重复字符的两个字符串是"abcd"和"wxyh"，则输出16
 * words=["a","aa","aaa","aaaa"], 找不到满足要求的两个字符串，则输出0
 * 输入描述:
 * Input:
 *
 * ["a","ab","abc","cd","bcd","abcd"]
 * 输出描述:
 * Output:
 *
 * 4
 */
public class Main7 {
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            str = str.substring(1,str.length()-1);
            str = str.replace("\"","");
            String[] strs = str.split(",");
            List<Set<Character>> list = new ArrayList<>();
            for (int i = 0; i < strs.length; i++) {
                char[] temp = strs[i].toCharArray();
                Set<Character> set = new HashSet<>(26);
                for (int j = 0; j < temp.length; j++) {
                    set.add(temp[j]);
                }
                list.add(set);
            }
            int max = 0;
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    boolean isContain = false;
                    for (Character t2:list.get(j)) {
                        if (list.get(i).contains(t2)){
                            isContain =true;
                        }
                    }
                    if (!isContain){
                        if (list.get(i).size() * list.get(j).size() > max){
                            max = list.get(i).size() * list.get(j).size();
                        }
                    }
                }
            }
            System.out.println(max);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
