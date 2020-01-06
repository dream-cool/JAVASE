package fourthday;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 20:26 2019/7/5
 * 字符串转数字
 */
public class Main5 {
    public static void main(String[] args) {
        System.out.println(StrToInt("-4545"));
    }
    public static int StrToInt(String str) {
        int number = 0;
        boolean flag = true;
        for(int i = str.length() - 1, j = 1; i >= 0 ; i--, j *= 10){
            if(i == 0 && str.charAt(i) == '-'){
                flag = false;
                break;
            }
            if(i == 0 && str.charAt(i) == '+'){
                break;
            }
            if(str.charAt(i) < 48 || str.charAt(i) > 57){
                return 0;
            }
            number +=  (str.charAt(i)-48) * j;
        }
        if(!flag){
            number *= -1;
        }
        return number;
    }
}
