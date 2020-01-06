package secondday;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 8:50 2019/6/15
 */
public class NumberOf1 {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-10));
        System.out.println(theOneNumber(-10));
        System.out.println(NumberOf1_low(0));
    }
    public static int theOneNumber(int number){
        int count = 0;
        String str = Integer.toBinaryString(number);
        char[] temp = str.toCharArray();
        for(int i = 0; i < temp.length; i++){
            if (temp[i] == '1'){
                count++;
            }
        }
        return count;
    }

    private static int NumberOf1_low(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}
