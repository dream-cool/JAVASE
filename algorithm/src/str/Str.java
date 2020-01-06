package str;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 12:57 2019/7/14
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母
 */

public class Str {
    public static void main(String[] args) {
        System.out.println(isNumeric("1+23".toCharArray()));
    }
    public static boolean isNumeric(char[] str) {
        StringBuilder sb = new StringBuilder();
        if ((str[0] =='+'&& str[1] == '-') || (str[0] == '-' && str[1] == '+')
            || (str[0] =='+'&& str[1] == '+') || (str[0] == '-' && str[1] == '-')){
            return  false;
        }
        for(int i = 0; i < str.length; i++){
            if((str[i] >= 'a' && str[i] <= 'z' && str[i] != 'e') || (str[i] >= 'A' && str[i] <= 'Z' && str[i] != 'E') ){
                return false;
            }
            if((str[i] == '+' || str[i] == '-') && i > 0 && str[i-1]!='e' && str[i -1] !='E'){
                return false;
            }
            sb.append(str[i]);
        }
        String[] strs = sb.toString().split("e|E");
        if (strs[0].length() != sb.length() && strs.length <= 1){
            return false;
        }
        if(strs.length >= 2 && strs[1].split("\\.").length != 1){
            return false;
        }
        strs = sb.toString().split("\\.");
        if (strs.length > 2){
            return  false;
        }
        return true;
    }
}
